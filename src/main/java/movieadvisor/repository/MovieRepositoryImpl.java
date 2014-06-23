package movieadvisor.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import movieadvisor.model.Movie;



import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public class MovieRepositoryImpl implements MovieRepository{
	@PersistenceContext
	private EntityManager em;

	public void saveMovie(Movie newMovie) {
		System.out.println("Save Movie");
		System.out.println(newMovie.getUser().getUserId());
		System.out.println(newMovie.getUserId());
		System.out.println(newMovie.getMovieId());
		System.out.println(newMovie.getRating());
		em.persist(newMovie);
		em.flush();
	}

	public void deleteMovie(Movie movie) {
		em.remove(movie);
		em.flush();
		
	}

	public void updateMovie(Movie movieDb) {
		em.merge(movieDb);
		em.flush();
		
	}
	

	public Movie getMovie(Long movieId, Long userId) {
		TypedQuery<Movie> query = em.createNamedQuery(Movie.GET_RATING_BY_USERID_AND_MOVIEID, Movie.class);
		query.setParameter("userId", userId);
		query.setParameter("movieId", movieId);
		List<Movie> movies = query.getResultList();
		System.out.println(movies.size());
		if (movies.size() == 0) 
			return null;
		else {
			Movie movie = movies.get(0);
			return movie;
		}
	}

	public List<Movie> getRecentlyViewed(Long userId) {
		TypedQuery<Movie> query = em.createNamedQuery(Movie.GET_RECENTLY_VIEWED, Movie.class);
		query.setParameter("userId", userId);
		query.setMaxResults(10);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	
	

	public List<Movie> getUserWatchlist(Long userId) {
		TypedQuery<Movie> query = em.createNamedQuery(Movie.GET_USER_WATCHLIST, Movie.class);
		query.setParameter("userId", userId);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	public List<Movie> getAllUserMovies(Long userId) {
		TypedQuery<Movie> query = em.createNamedQuery(Movie.GET_ALL_USER_MOVIES, Movie.class);
		query.setParameter("userId", userId);
		List<Movie> movies = query.getResultList();
		return movies;
	}

	/*public void deleteRecentViewed(RecentlyViewedMovie movie) {
	em.remove(movie);
	em.flush();
	}
 */
	
	/*public void saveRecentViewed(RecentlyViewedMovie movie) {
	em.merge(movie);
	//em.persist(movie);
	em.flush();
}*/
	
	
}
