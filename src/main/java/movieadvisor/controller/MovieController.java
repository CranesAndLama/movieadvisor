package movieadvisor.controller;

import javax.servlet.http.HttpSession;

import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		model.addAttribute("loginUser", loginUser);
		return "viewMovie";
	}
	@RequestMapping(value = "/ratemovie/{movieId}", method = RequestMethod.POST)
	public String rateMovie(final @PathVariable Long movieId, @ModelAttribute("ratedMovie") Movie ratedMovie, BindingResult bindingResult, HttpSession session) {
		//Byte ratingByte = Byte.parseByte(rating);
		System.out.println(ratedMovie.getRating());
		//Integer movie = Integer.parseInt(movieId);
		User loginUser = (User)session.getAttribute("loginUser");
		
		System.out.println(movieId);
		System.out.println(loginUser.getUsername());
		
		movieService.rateMovie(loginUser, movieId, ratedMovie.getRating());
		return "redirect:/main";
	}
	
	@RequestMapping(value = "addtowatchlist/{movieId}",method = RequestMethod.GET)
	public String addToWatchlist(Model model, final @PathVariable Long movieId, HttpSession session) {
		
		System.out.println(movieId);
		//int movieIntId = Integer.parseInt(movieId);
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.addMovieToWatchlist(user, movieId);
		
		return "redirect:/main";
	}
	@RequestMapping(value = "removefromwatchlist/{movieId}",method = RequestMethod.GET)
	public String removefromwatchlist(Model model, final @PathVariable Long movieId, HttpSession session) {
		
		System.out.println(movieId);
		//int movieIntId = Integer.parseInt(movieId);
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.removeMovieFromWatchlist(user, movieId);
		
		return "redirect:/main";
	}
	
	
	@RequestMapping(value = "rate",method = RequestMethod.GET)
	public String removeScript(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		movieService.setRatings(user);
		
		return "redirect:/main";
	}
	
}
