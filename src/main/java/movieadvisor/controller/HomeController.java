package movieadvisor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import movieadvisor.model.Movie;
import movieadvisor.model.PageMovie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;
/*import movieadvisor.service.WatchlistService;*/
import movieadvisor.service.UserService;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "page", "newUser"})
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
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
		System.out.println("login user: " + loginUser);
		if (loginUser != null) {
			return "forward:/mainlogged";
		}
		else {	
		
			Integer page = (Integer) session.getAttribute("page");
			
			if (page == null) page = 0;
			System.out.println("page = " + page);
			//Get first 4 movies
			List<Movie> topRated = movieService.getTopRated(page, from, to);
			
			model.addAttribute("topRated", topRated);
			//model.addAttribute("topRated", movieService.getTopRated(page));
			model.addAttribute("newMovies", movieService.getNewMovies(page, from, to));
		}
		return "main";
	}
	
	@RequestMapping(value = "/mainlogged")
	public String mainPageloggedUser(Model model, HttpSession session) throws TasteException {
		
		Integer from = 0;
		Integer to = 3;
		
		User loginUser = (User)session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		
		//Map<String, Object> recommendations = movieService.getRecommendations(loginUser.getUserId(), 1);
		//List<Movie> recommendationsList = (List<Movie>)recommendations.get("returnList");
		
		/*System.out.println("Recommendation list:");
		//System.out.println("Number of pages: " + (Integer)recommendations.get("numberOfPages"));
		for (Movie movie: recommendationsList) {
			System.out.println(movie.getMovieDb().getTitle());
		}
		*/
		PageMovie recommendations = movieService.getRecommendations(loginUser.getUserId(), 1);
		model.addAttribute("recommended", recommendations.getMovies());
		model.addAttribute("topRated", movieService.getTopRatedFromDb(loginUser));
		model.addAttribute("newMovies", movieService.getNewMoviesFromDb(loginUser));
		
		//String rating = "";
		Movie movie = new Movie();
		model.addAttribute("ratedMovie", movie);
		
		model.addAttribute("watchlist", movieService.getUserWatchlist(loginUser.getUserId()));
		
		
		return "mainLoggedUser";
	}
	
	@RequestMapping(value = "search", params = {"page"}, method=RequestMethod.POST)
	public String search(@RequestParam("query") String query, @RequestParam("page") Integer page , Model model, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		PageMovie movies;
		Set<User> users;
		if (page == null) {
			movies = movieService.searchMovies(query, loginUser, 1);
			users = userService.searchUsers(query, 1, loginUser);
		}
		else {
			movies = movieService.searchMovies(query, loginUser, page);
			users = userService.searchUsers(query, page, loginUser);
		}
		model.addAttribute("movies", movies.getMovies());
		model.addAttribute("noOfPages", movies.getNumberOfPages());
		model.addAttribute("currentPage", page);
		
		
		model.addAttribute("users", users);
		return "searchResults";
	}
	@RequestMapping(value = "logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		/*User loginUser = (User)session.getAttribute("loginUser");
		loginUser = null;*/
		session.removeAttribute("loginUser");
		//session.invalidate();
		//session.setAttribute("loginUser", null);
		System.out.println("login user logout: " + (User)session.getAttribute("loginUser"));
		return "redirect:/main";
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
