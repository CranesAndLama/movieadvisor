package movieadvisor.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import movieadvisor.model.Friend;
import movieadvisor.model.Movie;
import movieadvisor.model.PageMovie;
import movieadvisor.model.User;
import movieadvisor.service.MovieService;
import movieadvisor.service.UserService;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"loginUser", "greeting", "newUser"})
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String showUserLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "loginForm";
	}
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("newUser") User newUser, Model model, HttpSession session) {
		User loginUser = userService.validateUserLogin(newUser);
		
		if (loginUser != null) {
			System.out.println("User login successfully");
			model.addAttribute("loginUser", loginUser);
			session.setAttribute("loginUser", loginUser);
			return "redirect:/main";
		}
		else {
			System.out.println("User failed to login");
			return "main";
		}
	}
	
	@RequestMapping(value = "user/signup", method = RequestMethod.GET)
	public String createUserProfile(Model model) {
		model.addAttribute("newUser", new User());
		return "signupForm";
	}
	
	@RequestMapping(value = "user/signup", method=RequestMethod.POST)
	public String addUserFromForm(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
				return "main";
		}
		//save user in the database
		userService.saveUser(newUser);
		/*try {
			if (!image.isEmpty()) {
				ImageProcessor.validateImage(image);
				ImageProcessor.saveImage(newUser.getUserId()+".jpg",image);
			}
		} 
		catch(RuntimeException e) {
			bindingResult.reject(e.getMessage());
			return"signupForm";
		}*/
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="user/{username}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model) throws TasteException{
	User user =	userService.getUserByUsername(username);
	
	model.addAttribute("user", user);
	
	Set<Friend> friendsSet = user.getFriends();
	System.out.println("Friends before forming: " + friendsSet.size());
	Set<User> friends = userService.formUsers(friendsSet);
	System.out.println("Friends after forming: " + friends.size());
	model.addAttribute("friends", friends);
	
	List<Movie> recentlyViewed = movieService.getRecentlyViewed(user);
	List<Movie> watchlist = movieService.getUserWatchlist(user.getUserId());
	//System.out.println("movie collection size before forming objects" + recentlyViewed.size());
	//List<Movie> recentlyViewedMovies = movieService.formMovies(recentlyViewed);
	
	/*System.out.println("movie collection size" + recentlyViewedMovies.size());
	for (Movie movie:recentlyViewedMovies) {
		System.out.println(movie.getMovieDb().getId());
		System.out.println(movie.getMovieDb().getTitle());
		System.out.println(movie.getRating());
		System.out.println(movie.getIsInWatchlist());
	}*/
	
	model.addAttribute("recentlyViewedMovies", recentlyViewed);
	model.addAttribute("watchlist", watchlist);
	/*List<Movie> recommended = movieService.getRecommendations(user.getUserId());
	model.addAttribute("recommended", recommended);*/
	
	return "userView";
	}
	
	@RequestMapping(value="user/users", method=RequestMethod.GET)
	public String getUsers(Model model, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		Set<User> allUsers = userService.getAllUsers(loginUser);
		model.addAttribute("allUsers", allUsers);
		model.addAttribute("loginUser", loginUser);
		return "allUsers";
	}
	
	
	@RequestMapping(value="recommendations", params = {"page"}, method=RequestMethod.GET)
	public String getUserRecommendations(@RequestParam("page") int page, Model model, HttpSession session) throws TasteException {
		System.out.println("RECOMENDATION CONTROLLER");
		User loginUser = (User) session.getAttribute("loginUser");
		
		//Map<String, Object> rec = movieService.getRecommendations(loginUser.getUserId(), page);
		PageMovie recommendations = movieService.getRecommendations(loginUser.getUserId(), page);
		model.addAttribute("recommended", recommendations.getMovies());
		model.addAttribute("noOfPages", recommendations.getNumberOfPages());
		/*for (Movie movie:rec) {
			System.out.println(movie.getMovieDb().getTitle());
		}*/
		
		//model.addAttribute("recommended", (List<Movie>)rec.get("resultList"));
		model.addAttribute("currentPage", page);
		//model.addAttribute("noOfPages", (Integer)rec.get("numberOfPages"));
		return "recommended";
	}
}
