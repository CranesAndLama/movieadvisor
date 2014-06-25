package movieadvisor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;
/*import movieadvisor.service.WatchlistService;*/


import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "greeting", "page", "newUser"})
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	/*@Autowired
	private WatchlistService watchlistService;*/
	
	@RequestMapping(value = "/main")
	public String mainPage(Model model, HttpSession session) {
		//Return objects from 0 to 3 from MovieDB
		Integer from = 0;
		Integer to = 4;
		User newUser = new User();
		session.setAttribute("newUser", newUser);
		model.addAttribute("newUser", newUser);
		
		User loginUser = (User)session.getAttribute("loginUser");
		if (loginUser != null) {
			return "forward:/mainlogged";
		}
		else {
			session.setAttribute("greeting", "Welcome guest");
			System.out.println(session.getAttribute("greeting"));
			model.addAttribute("greeting", "Welcome guest");
		}
		Integer page = (Integer) session.getAttribute("page");
		
		if (page == null) page = 0;
		System.out.println("page = " + page);
		//Get first 4 movies
		List<Movie> topRated = movieService.getTopRated(page, from, to);
		
		model.addAttribute("topRated", topRated);
		//model.addAttribute("topRated", movieService.getTopRated(page));
		model.addAttribute("newMovies", movieService.getNewMovies(page, from, to));
		
		return "main";
	}
	
	@RequestMapping(value = "/mainlogged")
	public String mainPageloggedUser(Model model, HttpSession session) throws TasteException {
		
		Integer from = 0;
		Integer to = 3;
		
		User loginUser = (User)session.getAttribute("loginUser");
		String helloToUser = "Welcome back, " + loginUser.getUsername();
		session.setAttribute("greeting", helloToUser);
		System.out.println(session.getAttribute("greeting"));
		model.addAttribute("greeting", helloToUser);
		model.addAttribute("loginUser", loginUser);
		
		model.addAttribute("recommended", movieService.getRecommendations(loginUser.getUserId()));
		model.addAttribute("topRated", movieService.getTopRatedFromDb(loginUser));
		model.addAttribute("newMovies", movieService.getNewMoviesFromDb(loginUser));
		
		//String rating = "";
		Movie movie = new Movie();
		model.addAttribute("ratedMovie", movie);
		
		model.addAttribute("watchlist", movieService.getUserWatchlist(loginUser.getUserId()));
		
		
		return "mainLoggedUser";
	}
	
	@RequestMapping(value = "/loadmorenewmovies")
	public @ResponseBody List<Movie> loadMoreNewMovies(HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		List<Movie> resultList = new ArrayList<Movie>();
		if (loginUser == null) {
			Integer page = 0;
			Integer from = 4;
			Integer to = 8;
			resultList = movieService.getNewMovies(page, from, to);
			//model.addAttribute("newMovies", movieService.getNewMovies(page, from, to));
		}
		else {
			//TODO !!!!!!!!!!!!!!!!!!
			System.out.println("USER LOGIN!");
		}
		return resultList;
	}
	
}
