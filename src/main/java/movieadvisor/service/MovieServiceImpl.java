package movieadvisor.service;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.core.MovieResults;
import info.movito.themoviedbapi.model.core.ResultsPage;
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.people.PersonCrew;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import movieadvisor.model.Movie;
import movieadvisor.model.PageMovie;
import movieadvisor.model.User;
import movieadvisor.recommender.RecommenderEngine;
import movieadvisor.repository.MovieRepository;
//import movieadvisor.repository.WatchlistRepository;



import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("movieService")
public class MovieServiceImpl implements MovieService{
	public static final int NUMBER_OF_RECOMMENDATIONS_PER_PAGE = 12;
	@Autowired
	MovieRepository movieRepository;
	/*@Autowired
	WatchlistRepository watchlistRepository;*/
	
	public static final String API_KEY = "50906e9eb1f85e11a1ddf27e01bd8723";
	TmdbApi tmdbApi = new TmdbApi(API_KEY); 
	
	public Movie getMovie(int movieId) {
		TmdbMovies movies = tmdbApi.getMovies();
		MovieDb movieDb = movies.getMovie(movieId, "en");
		
		//set movieDb properties
		Credits credits = movies.getCredits(movieId);
		
		//set first three cast person
		List<PersonCast> cast = credits.getCast();
		
		List<PersonCast> firstThreeStars = cast.size() > 3? cast.subList(0, 3): cast;
		credits.setCast(firstThreeStars);
		//set director and producer
		List<PersonCrew> crew = credits.getCrew();
		List<PersonCrew> dirAndProd = new ArrayList<PersonCrew>();
		//List<PersonCrew> producers = new ArrayList<PersonCrew>();
		for (PersonCrew personCrew: crew) {
			if (personCrew.getJob().equals("Director")) {
				dirAndProd.add(personCrew);
			}
			else if (personCrew.getJob().equals("Producer")) {
				dirAndProd.add(personCrew);
			}
		}
		
		//<PersonCrew> dirAndProd = crew.subList(0, 2);
		credits.setCrew(dirAndProd);
		
		movieDb.setCredits(credits);
		
		//set background image
		MovieImages images = movies.getImages(movieId, "en");
		List<Artwork> posters = images.getPosters();
		List<Artwork> firstPoster = posters.size() == 0? posters: posters.subList(0, 1);
		images.setPosters(firstPoster);
		
		movieDb.setImages(images);
		
		Movie movie = new Movie(movieDb);
		
		return movie;
	}
	private void setMovieDb(Movie movie) {
		TmdbMovies movies = tmdbApi.getMovies();
		int i = movie.getMovieId().intValue();
		MovieDb movieDb = movies.getMovie(i, "en");
		
		//set movieDb properties
		Credits credits = movies.getCredits(i);
		
		//set first three cast person
		List<PersonCast> cast = credits.getCast();
		List<PersonCast> firstThreeStars = cast.size() > 3? cast.subList(0, 3): cast;
		credits.setCast(firstThreeStars);
		//set director and producer
		List<PersonCrew> crew = credits.getCrew();
		List<PersonCrew> dirAndProd = new ArrayList<PersonCrew>();
		//List<PersonCrew> producers = new ArrayList<PersonCrew>();
		for (PersonCrew personCrew: crew) {
			if (personCrew.getJob().equals("Director")) {
				dirAndProd.add(personCrew);
			}
			else if (personCrew.getJob().equals("Producer")) {
				dirAndProd.add(personCrew);
			}
		}

		credits.setCrew(dirAndProd);
		
		movieDb.setCredits(credits);
		
		//set background image
		MovieImages images = movies.getImages(i, "en");
		List<Artwork> posters = images.getPosters();
		if (posters.size() > 1) {
			String backgroundPosterFilePath = posters.get(1).getFilePath();
			movie.setBackgroundPoster(Movie.POSTER_BASE_URL + backgroundPosterFilePath);
		}
		else if (posters.size() == 1) {
			String backgroundPosterFilePath = posters.get(0).getFilePath();
			movie.setBackgroundPoster(Movie.POSTER_BASE_URL + backgroundPosterFilePath);
		}
		/*List<Artwork> firstPoster = posters.subList(0, 1);
		images.setPosters(firstPoster);
		
		movieDb.setImages(images);*/

		movie.setMovieDb(movieDb);
		movie.setPoster(Movie.POSTER_BASE_URL + movieDb.getPosterPath());
		
	}
	public Movie getMovieFromDb(Long movieId, Long userId) {
		Movie movieDb = movieRepository.getMovie(movieId, userId);
		if (movieDb != null) {
			setMovieDb(movieDb);
			return movieDb;
		}
		else {
			Movie movie = new Movie();
			
			movie.setMovieId(movieId);
			setMovieDb(movie);
			return movie;
		}
	}
	
/*	public Movie formMovieObject(int movieId, Long userId) {
		TmdbMovies movies = tmdbApi.getMovies();
		MovieDb movieDb = movies.getMovie(movieId, "en");
		//Movie movie = new Movie(movieDb);
		// if movie has been rated
		Movie movie = movieRepository.getMovie(movieId, userId);
		if (movie != null) {
			movie.setMovieDb(movieDb);
			
		}
		else {
			movie = new Movie(movieDb);
		}
		// if movie is in the watchlist
		List<Integer> watchlist = watchlistRepository.getUserWatchlist(userId);
		if (watchlist.contains(movieId)) {
			movie.setIsInWatchlist(true);
		}
		else {
			movie.setIsInWatchlist(false);
		}
		return movie;
	}*/
/*	public List<Movie> formMovies(List<RecentlyViewedMovie> recentlyViewed) {
		List<Movie> movies = new ArrayList<Movie>(); 
		for (RecentlyViewedMovie recentlyViewedMovie: recentlyViewed) {
			int movieId = recentlyViewedMovie.getMovieId();
			
			System.out.println(movieId);
			
			Long userId = recentlyViewedMovie.getUser().getUserId();
			
			System.out.println(userId);
			
			Movie movie = formMovieObject(movieId, userId);
			movies.add(movie);
		}
		return movies;
	}
	*/
	
	public List<Movie> getTopRated(Integer page, Integer from, Integer to) {
		TmdbMovies movies = tmdbApi.getMovies();
		ResultsPage<MovieDb> moviesResults = movies.getTopRatedMovies("english", page);
		
		
		
		int pages = moviesResults.getTotalPages();
		System.out.println("Top rated Total Pages: " + pages);
		int totalResults = moviesResults.getTotalResults();
		System.out.println("Top rated Total Results: " + totalResults);
		
		List<MovieDb> resultList = moviesResults.getResults();
		List<Movie> moviesList = new ArrayList<Movie>();
		if (from != null) {
			List<MovieDb> returnObjects = resultList.subList(from, to);
			moviesList = convertToMovieList(returnObjects); 
		}
		else {
			moviesList = convertToMovieList(resultList); 
		}
		return moviesList;
	}
	private List<Movie> convertToMovieList(List<MovieDb> moviDbList) {
		List<Movie> movies = new ArrayList<Movie>();
		for (MovieDb movieDb: moviDbList) {
			Movie movie = new Movie(movieDb);
			movies.add(movie);
		}
		return movies;
	}
	
	public List<Movie> getTopRatedFromDb(User user) {
		
		TmdbMovies movies = tmdbApi.getMovies();
		ResultsPage<MovieDb> moviesResults = movies.getTopRatedMovies("english", 0);
		
		List<MovieDb> resultList = moviesResults.getResults();
		//List<MovieDb> returnObjects = resultList.subList(fromIndex, toIndex);
		List<Movie> resultMovieList = checkAndFormMovieObjects(resultList, user);
		return resultMovieList;	
			/*
			Integer i = movieDb.getId();
			
			//if (userMovies.contains(movieDb))
			//Movie movie = getMovieFromDb(i.longValue(), user.getUserId());
			if (movie != null) {
				movie.setMovieDb(movieDb);
			}
			else {
				movie = new Movie(movieDb);
			}
			resultMovieList.add(movie);
		}
		*/
		//return resultMovieList;
	}
	
	
	
	@Transactional
	public void rateMovie(User user, Long movieId, Byte rating) {
		Movie movieDb = movieRepository.getMovie(movieId, user.getUserId());
		if (movieDb != null) {
			movieDb.setRating(rating);
			movieRepository.updateMovie(movieDb);
		}
		else {
			//Movie movie = formMovieObject(movieId, user.getUserId());
			Movie movie = new Movie();
			
			movie.setMovieId(movieId);
			
			movie.setUserId(user.getUserId());
			movie.setUser(user);
			movie.setRating(rating);
			movieRepository.saveMovie(movie);
		}
	}
	
	private static Random rand = new Random();
	
	@Transactional
	public void setRatings(User user) {
		
		for (int i = 0; i < 50; i++) {
			Integer randInt = (Integer)rand.nextInt(20);
			
			Long longMovieId = 200l + randInt.longValue();
			Byte rating = (byte) rand.nextInt(10);
			rateMovie(user, longMovieId, rating);
		}
	}
	
	
	@Transactional
	public void addMovieToRecentViewed(Long movieId, User user) {
		Movie movieDb = movieRepository.getMovie(movieId, user.getUserId());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentTime = new Date();
		if (movieDb != null) {
			//movieRepository.deleteMovie(movieDb);
			
			movieDb.setViewTime(currentTime);
			System.out.println(dateFormat.format(currentTime));
			movieRepository.updateMovie(movieDb);
		}
		else {
			//Movie movie = formMovieObject(movieId, user.getUserId());
			Movie movie = new Movie();
			movie.setViewTime(currentTime);
			System.out.println(dateFormat.format(currentTime));
			movie.setMovieId(movieId);
			movie.setUser(user);
			movie.setUserId(user.getUserId());
			movieRepository.saveMovie(movie);
		}
	}
	
	@Transactional
	public void addMovieToWatchlist(User user, Long movieId) {
		Movie movieDb = movieRepository.getMovie(movieId, user.getUserId());
		if (movieDb != null) {
			movieDb.setIsInWatchlist(true);
			movieRepository.updateMovie(movieDb);
		}
		else {
			//Movie movie = formMovieObject(movieId, user.getUserId());
			Movie movie = new Movie();
			movie.setIsInWatchlist(true);
			movie.setMovieId(movieId);
			movie.setUser(user);
			movie.setUserId(user.getUserId());
			movieRepository.saveMovie(movie);
		}
		
	}
	@Transactional
	public void removeMovieFromWatchlist(User user, Long movieId) {
		Movie movieDb = movieRepository.getMovie(movieId, user.getUserId());
			movieDb.setIsInWatchlist(false);
			movieRepository.updateMovie(movieDb);
	}
	
	public List<Movie> getUserWatchlist(Long userId) {
		List<Movie> movies= movieRepository.getUserWatchlist(userId);
		for (Movie movie: movies) {
			
			setMovieDb(movie);
			
			System.out.println("Watchlist movie: " + movie.getMovieDb().getTitle());
		}
		return movies;	
	}
	public List<Movie> getRecentlyViewed(User user) {
		List<Movie> movies= movieRepository.getRecentlyViewed(user.getUserId());
		for (Movie movie: movies) {
			setMovieDb(movie);
		}
		return movies;
	}
	
	public PageMovie getRecommendations(Long userId, int page) throws TasteException {
		List<Movie> resultList = new ArrayList<Movie>();
		
		List<RecommendedItem> recommendations = RecommenderEngine.makeRecommendations(userId, page * NUMBER_OF_RECOMMENDATIONS_PER_PAGE);
		
		int numberOfItems = recommendations.size();
		int from = (page - 1) * NUMBER_OF_RECOMMENDATIONS_PER_PAGE;
		for (int i = from; i < numberOfItems; i++) {
			System.out.println(recommendations.get(i));
			Long movieId = recommendations.get(i).getItemID();
			Movie movie = getMovieFromDb(movieId, userId);
			resultList.add(movie);
		}
		int numberOfPages = numberOfItems / NUMBER_OF_RECOMMENDATIONS_PER_PAGE + 1;
		PageMovie returnPage = new PageMovie(resultList, numberOfPages);
		/*for (RecommendedItem recommendedItem : recommendations) {
			System.out.println(recommendedItem);
			Long movieId = recommendedItem.getItemID();
			Movie movie = getMovieFromDb(movieId, userId);
			resultList.add(movie);	
		}*/
		
		/*System.out.println("Recommendation list: Service layout : ");
		for (Movie movie: resultList) {
			System.out.println(movie.getMovieDb().getTitle());
		}
		
		int numberOfPages = numberOfItems / NUMBER_OF_RECOMMENDATIONS_PER_PAGE + 1;
		System.out.println("Pages of recommendations: " + numberOfPages);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultList", resultList);
		resultMap.put("numberOfPages", numberOfPages);*/
		
		/*System.out.println("Recommendation list: Service layout after put: ");
		for (Movie movie: (List<Movie>)resultMap.get("resultList")) {
			System.out.println(movie.getMovieDb().getTitle());
		}*/
		
		return returnPage;
	}

	public List<Movie> getNewMovies(Integer page, Integer from, Integer to) {
		TmdbMovies movies = tmdbApi.getMovies();
		ResultsPage<MovieDb> moviesResults = movies.getNowPlayingMovies("english", page);
		
		int pages = moviesResults.getTotalPages();
		System.out.println("Top rated Total Pages: " + pages);
		int totalResults = moviesResults.getTotalResults();
		System.out.println("Top rated Total Results: " + totalResults);
		
		List<MovieDb> resultList = moviesResults.getResults();
		List<Movie> moviesList = new ArrayList<Movie>();
		//List<MovieDb> returnObjects = new ArrayList<MovieDb>();
		if (from != null) {
			List<MovieDb> returnObjects = resultList.subList(from, to);
			moviesList = convertToMovieList(returnObjects); 
		}
		else {
			moviesList = convertToMovieList(resultList); 
		}
		//return returnObjects;
		return moviesList;
	}
	public List<Movie> getNewMoviesFromDb(User loginUser) {
		
		TmdbMovies movies = tmdbApi.getMovies();
		ResultsPage<MovieDb> moviesResults = movies.getNowPlayingMovies("english", 0);
		
		List<MovieDb> resultList = moviesResults.getResults();
		//List<MovieDb> returnObjects = resultList.subList(fromIndex, toIndex);
		List<Movie> resultMovieList = checkAndFormMovieObjects(resultList, loginUser);
		
		
		return resultMovieList;	
	}
	private List<Movie> checkAndFormMovieObjects(List<MovieDb> resultList, User user) {
		List<Movie> resultMovieList = new ArrayList<Movie>();
		if (resultList.isEmpty()) return resultMovieList;
		resultList.sort(null);
		List<Movie> userMovies = movieRepository.getAllUserMovies(user.getUserId());
		userMovies.sort(null);
		//for movie
		int i = 0;
		//for movieDb
		int j = 0;
		boolean notStop = true;
		boolean endOfUserMovies = false;
		
		while(notStop) {
			if (endOfUserMovies || userMovies.size() == 0) {
				MovieDb movieDb = resultList.get(j);
				++j;
				if (resultList.size() == j) 
					notStop = false;
					
				Movie movie = new Movie(movieDb);
				resultMovieList.add(movie);
			}
			else {
			Movie movie = userMovies.get(i);
			MovieDb movieDb = resultList.get(j);
			
			if (movieDb.getId() > movie.getMovieId()) {
				++i;
				if (userMovies.size() == i) {
					endOfUserMovies = true;
				}
			}
			else if (movieDb.getId() < movie.getMovieId()) {
				++j;
				if (resultList.size() == j) 
					notStop = false;
					
				movie = new Movie(movieDb);
				resultMovieList.add(movie);
			}
			else {
				movie.setMovieDb(movieDb);
				movie.setPoster(Movie.POSTER_BASE_URL + movieDb.getPosterPath());
				resultMovieList.add(movie);
				++i;
				++j;
				if (resultList.size() == j) 
					notStop = false;
				
				if (userMovies.size() == i) {
					endOfUserMovies = true;
				}
			}
			}
		}
		return resultMovieList;
	}
	public PageMovie searchMovies(String query, User user, Integer page) {
		TmdbApi tmdbApi = new TmdbApi(API_KEY);
	 	TmdbSearch search = tmdbApi.getSearch();
	 	MovieResults results = search.searchMovie(query, 0, null, true, page);
	 	int numOfPages = results.getTotalPages();
	 	List<MovieDb> movies= results.getResults();
	 	List<Movie> resultMovies = checkAndFormMovieObjects(movies, user);
	 	PageMovie resultPage = new PageMovie(resultMovies, numOfPages);
		return resultPage;
	}
	
	/*	public static void main(String[] args) {
	TmdbApi tmdbApi = new TmdbApi(API_KEY);
	TmdbMovies movies = new TmdbApi(API_KEY).getMovies();
    
    MovieDb movie = movies.getMovie(550, "en");
    System.out.println(movie.getTitle());
    TmdbConfiguration configuration = tmdbApi.getConfiguration();

}*/
}
