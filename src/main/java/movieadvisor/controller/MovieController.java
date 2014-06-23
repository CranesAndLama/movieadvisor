package movieadvisor.controller;

import javax.servlet.http.HttpSession;

import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "greeting"})
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET)
	public String getMovie(Model model, final @PathVariable Long movieId, HttpSession session) {
		
		
		Movie movie;
		User loginUser = (User)session.getAttribute("loginUser");
		if (loginUser != null) {
			movieService.addMovieToRecentViewed(movieId, loginUser);
			movie = movieService.getMovieFromDb(movieId, loginUser.getUserId());
		}
		else {
			int i = movieId.intValue();
			movie = movieService.getMovie(i);
		}
		model.addAttribute("movie", movie);
		//model.addAttribute("loginUser", loginUser);
		return "viewMovie";
	}

	@RequestMapping(value = "/ratemovie/{movieId}", method = RequestMethod.POST)
	public @ResponseBody String rateMovie(final @PathVariable Long movieId, @RequestParam(value="rating", required=true) Byte rating, HttpSession session) {
		//Byte ratingByte = Byte.parseByte(rating);
		System.out.println("RATE MOVIE CONTROLLER");
		System.out.println(rating);
		
		User loginUser = (User)session.getAttribute("loginUser");
		
		//System.out.println(movieId);
		System.out.println(loginUser.getUsername());
		
		movieService.rateMovie(loginUser, movieId, rating);
		return rating.toString();
	}
	
	
	@RequestMapping(value = "addtowatchlist/{movieId}",method = RequestMethod.GET)
	public @ResponseBody String addToWatchlist(final @PathVariable Long movieId, HttpSession session) {
		
		System.out.println(movieId);
		//int movieIntId = Integer.parseInt(movieId);
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.addMovieToWatchlist(user, movieId);
		
		return "true";
	}
	
	@RequestMapping(value = "removefromwatchlist/{movieId}",method = RequestMethod.GET)
	public @ResponseBody String removefromwatchlist(final @PathVariable Long movieId, HttpSession session) {
		
		System.out.println(movieId);
		//int movieIntId = Integer.parseInt(movieId);
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.removeMovieFromWatchlist(user, movieId);
		
		return "false";
	}
	
/*	@RequestMapping(value = "rate",method = RequestMethod.GET)
	public String removeScript(HttpSession session) {
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.setRatings(user);
		
		return "redirect:/main";
	}*/
	
}
