package movieadvisor.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import movieadvisor.helper.ImageProcessor;
import movieadvisor.model.Friend;
import movieadvisor.model.Movie;
import movieadvisor.model.User;
import movieadvisor.service.FriendService;
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
import org.springframework.web.multipart.MultipartFile;


@Controller
@SessionAttributes({"loginUser", "greeting"})
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private FriendService friendService;
	/*@Inject
	public UserController(UserService userService){
	this.userService=userService;
	}*/
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String showUserLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "loginForm";
	}
	@RequestMapping(value = "user/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user,Model model, HttpSession session) {
		User loginUser = userService.validateUserLogin(user);
		
		if (loginUser != null) {
			System.out.println("User login successfully");
			model.addAttribute("loginUser", loginUser);
			session.setAttribute("loginUser", loginUser);
			return "redirect:/main";
		}
		else {
			System.out.println("User failed to login");
			return "loginForm";
		}
	}
	
	@RequestMapping(value = "user/signup", method = RequestMethod.GET)
	public String createUserProfile(Model model) {
		model.addAttribute("newUser", new User());
		return "signupForm";
	}
	
	@RequestMapping(value = "user/signup", method=RequestMethod.POST)
	public String addUserFromForm(@Valid @ModelAttribute("newUser") User newUser,@RequestParam(value="image",required=false)
								MultipartFile image, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
				return"signupForm";
		}
		//save user in the database
		userService.saveUser(newUser);
		try {
			if (!image.isEmpty()) {
				ImageProcessor.validateImage(image);
				ImageProcessor.saveImage(newUser.getUserId()+".jpg",image);
			}
		} 
		catch(RuntimeException e) {
			bindingResult.reject(e.getMessage());
			return"signupForm";
		}
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="user/{username}", method=RequestMethod.GET)
	public String showUserProfile(@PathVariable String username, Model model) throws TasteException{
	User user =	userService.getUserByUsername(username);
	
	model.addAttribute("user", user);
	
	Set<Friend> friendsSet = user.getFriends();
	System.out.println("Friends before forming: " + friendsSet.size());
	Set<User> friends = userService.formUsers(friendsSet);
	System.out.println("Friends before forming: " + friends.size());
	model.addAttribute("friends", friends);
	
	List<Movie> recentlyViewed = movieService.getRecentlyViewed(user);
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
	
	List<Movie> recommended = movieService.getRecommendations(user.getUserId());
	model.addAttribute("recommended", recommended);
	
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
	@RequestMapping(value="addfriend/{friendId}", method=RequestMethod.GET)
	public String addFriend(Model model, final @PathVariable Long friendId, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		friendService.addFriend(loginUser, friendId);
		return "redirect:/user/users";
	}
}
