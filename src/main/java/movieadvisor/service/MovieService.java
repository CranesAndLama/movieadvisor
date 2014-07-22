package movieadvisor.service;

import java.util.List;

import movieadvisor.model.Movie;
import movieadvisor.model.PageMovie;
import movieadvisor.model.User;

import org.apache.mahout.cf.taste.common.TasteException;

public interface MovieService {
	
	Movie getMovie(int movieId);
	
	Movie getMovieFromDb(Long movieId, Long userId);
	
	List<Movie> getTopRated(Integer page, Integer from, Integer to);

	void rateMovie(User user, Long movie, Byte rating);

	void addMovieToRecentViewed(Long i, User user);
	
	List<Movie> getRecentlyViewed(User user);

	//Movie formMovieObject(int movieId, Long userId);

	//List<Movie> formMovies(List<RecentlyViewedMovie> recentlyViewed);
	
	void addMovieToWatchlist(User user, Long movieId);

	void removeMovieFromWatchlist(User user, Long movieId);

	List<Movie> getUserWatchlist(Long userId);

	List<Movie> getTopRatedFromDb(User user);

	void setRatings(User user);

	PageMovie getRecommendations(Long userId, int page) throws TasteException;

	List<Movie> getNewMovies(Integer page, Integer from, Integer to);

	List<Movie> getNewMoviesFromDb(User loginUser);

	PageMovie searchMovies(String query, User loginUser, Integer page);

	
}
