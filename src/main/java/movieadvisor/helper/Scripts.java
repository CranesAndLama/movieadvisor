package movieadvisor.helper;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResults;

import java.util.List;
import java.util.Random;

import movieadvisor.model.User;
import movieadvisor.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;

public class Scripts {
	@Autowired
	private static MovieService movieService;
	
	private static Random rand = new Random();
	public static void setRatings(Long userId) {
		User user = new User();
		user.setUserId(userId);
		for (int i = 0; i < 50; i++) {
			Integer movieId = (Integer)rand.nextInt(20);
			Long longMovieId = movieId.longValue();
			Byte rating = (byte) rand.nextInt(10);
			movieService.rateMovie(user, longMovieId, rating);
		}
	}
	public static final String API_KEY = "50906e9eb1f85e11a1ddf27e01bd8723";
	public static void main(String args[]) {
		
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));*/
		/*TmdbApi tmdbApi = new TmdbApi(API_KEY); 
		TmdbMovies movies = tmdbApi.getMovies();
		MovieDb movie = movies.getMovie(240, "en");
		Credits credits = movies.getCredits(240);
		movie.setCredits(credits);
		List<PersonCast> movieCast = movie.getCredits().getCast();
		List<PersonCast> cast = credits.getCast();
		
		for (PersonCast personCast: movieCast) {
			System.out.println(personCast.getCastId());
			System.out.println(personCast.getCharacter());
			System.out.println(personCast.getName());
		}
		List<PersonCrew> crew = credits.getCrew();
		for (PersonCrew personCrew: crew) {
			System.out.println(personCrew.getCastId());
			System.out.println(personCrew.getDepartment());
			System.out.println(personCrew.getJob());
			//System.out.println(personCrew);
			System.out.println(personCrew.getName());
		}*/
		
		/*MovieImages images = movies.getImages(240, "en");
		System.out.println(images.getId());
		List<Artwork> backdrops = images.getBackdrops();
		List<Artwork> posters = images.getPosters();
		List<Artwork> profiles = images.getProfiles();
		
		for (Artwork backdrop: backdrops) {
			System.out.println("BACKDROP: " + backdrop);
		}
		for (Artwork poster: posters) {
			System.out.println(poster.getFilePath());
			System.out.println("POSTER: " + poster);
		}
*/		/*for (Artwork profile: profiles) {
			System.out.println("PROFILES: " + profiles);
		}*/
		
		/*System.out.println(credits);
		//movie.getCredits()
		System.out.println(movie.getReleaseDate());		
		System.out.println(movie.getGenres());
	
		System.out.println(movie.getOverview());*/
		
		
		/*ResultsPage<MovieDb> moviesResults = movies.getTopRatedMovies("english", 0);
		moviesResults.handleUnknown(API_KEY, moviesResults);
		List<MovieDb> resultList = moviesResults.getResults();
		resultList.sort(null);
		for (MovieDb movieDb: resultList) {
			System.out.println(movieDb.getId());
			System.out.println(movieDb.getOverview());
			System.out.println(movieDb.getCast());
		}
		System.out.println(resultList.size());
	//}
	 */
	 	TmdbApi tmdbApi = new TmdbApi(API_KEY);
	 	TmdbSearch search = tmdbApi.getSearch();
	 	MovieResults results = search.searchMovie("godfather", 0, null, true, 1);
	 	List<MovieDb> movies= results.getResults();
	 	for (MovieDb movie: movies) {
	 		System.out.println(movie.getTitle());
	 	}
	}
}
