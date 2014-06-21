package movieadvisor.repository;

import java.util.List;

import movieadvisor.model.Movie;
import java.util.Set;


public interface MovieRepository {

	void saveMovie(Movie newMovie);
	
	void deleteMovie(Movie movie);
	
	void updateMovie(Movie movieDb);
	
	Movie getMovie(Long movieId, Long userId);

	//void saveRecentViewed(RecentlyViewedMovie movie);

	List<Movie> getRecentlyViewed(Long userId);

	//void deleteRecentViewed(RecentlyViewedMovie movie);

	List<Movie> getUserWatchlist(Long userId);

	List<Movie> getAllUserMovies(Long userId);

	

	

	


}
