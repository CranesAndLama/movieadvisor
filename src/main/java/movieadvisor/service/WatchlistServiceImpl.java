/*package movieadvisor.service;

import java.util.ArrayList;
import java.util.List;

import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.model.Watchlist;
import movieadvisor.repository.WatchlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("watchlistService")
public class WatchlistServiceImpl implements WatchlistService{
	@Autowired
	private WatchlistRepository watchlistRepository;
	@Autowired
	private MovieService movieService;
	
	@Transactional
	public void addMovieToWatchlist(User user, int movieId) {
		Watchlist watchlistMovie = new Watchlist();
		watchlistMovie.setUser(user);
		watchlistMovie.setMovieId(movieId);
		watchlistRepository.addWatchlist(watchlistMovie);
		
	}
	
	public List<Movie> getUserWatchlist(Long userId) {
		List<Integer> moviesId = watchlistRepository.getUserWatchlist(userId);
		List<Movie> userWatchlist = new ArrayList<Movie>();
		for (int movieId: moviesId) {
			Movie movie = movieService.getMovie(movieId);
			userWatchlist.add(movie);
		}
		return userWatchlist;
	}

}
*/