package movieadvisor.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   //get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		/*TmdbApi tmdbApi = new TmdbApi(API_KEY); 
		TmdbMovies movies = tmdbApi.getMovies();
		ResultsPage<MovieDb> moviesResults = movies.getTopRatedMovies("english", 0);
		List<MovieDb> resultList = moviesResults.getResults();
		resultList.sort(null);
		for (MovieDb movieDb: resultList) {
			System.out.println(movieDb.getId());
		}
		System.out.println(resultList.size());
	}*/
	}
}
