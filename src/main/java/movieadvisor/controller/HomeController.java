package movieadvisor.controller;

import javax.servlet.http.HttpSession;

import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;
/*import movieadvisor.service.WatchlistService;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "greeting", "page"})
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	/*@Autowired
	private WatchlistService watchlistService;*/
	
	@RequestMapping(value = "/main")
	public String mainPage(Model model, HttpSession session) {
		
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
		model.addAttribute("topRated", movieService.getTopRated(page));
		model.addAttribute("newMovies", movieService.getNewMovies());
		
		return "main";
	}
	
	@RequestMapping(value = "/mainlogged")
	public String mainPageloggedUser(Model model, HttpSession session) {
		
		User loginUser = (User)session.getAttribute("loginUser");
		String helloToUser = "Welcome back, " + loginUser.getUsername();
		session.setAttribute("greeting", helloToUser);
		System.out.println(session.getAttribute("greeting"));
		model.addAttribute("greeting", helloToUser);
		model.addAttribute("loginUser", loginUser);
		
		model.addAttribute("topRated", movieService.getTopRatedFromDb(loginUser));
		
		//String rating = "";
		Movie movie = new Movie();
		model.addAttribute("ratedMovie", movie);
		
		model.addAttribute("watchlist", movieService.getUserWatchlist(loginUser.getUserId()));
		
		
		return "mainLoggedUser";
	}
	
}
