/*package movieadvisor.controller;

import javax.servlet.http.HttpSession;

import movieadvisor.model.User;
import movieadvisor.service.WatchlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "greeting"})
public class WatchlistController {
	@Autowired
	private WatchlistService watchlistService;
	
	@RequestMapping(value = "addtowatchlist/{movieId}",method = RequestMethod.GET)
	public String addToWatchlist(Model model, final @PathVariable Integer movieId, HttpSession session) {
		
		System.out.println(movieId);
		//int movieIntId = Integer.parseInt(movieId);
		
		User user = (User) session.getAttribute("loginUser");
		System.out.println(user.getUsername());
		
		watchlistService.addMovieToWatchlist(user, movieId);
		
		return "redirect:/main";
		
	}
}
*/