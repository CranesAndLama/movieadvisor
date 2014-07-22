package movieadvisor.controller;

import javax.servlet.http.HttpSession;

import movieadvisor.model.User;
import movieadvisor.service.FriendService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"loginUser", "page", "newUser"})
public class FriendController {
	@Autowired
	FriendService friendService;
	
	@RequestMapping(value="/addfriend/{friendId}", method=RequestMethod.GET)
	public @ResponseBody String addFriend(final @PathVariable Long friendId, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		friendService.addFriend(loginUser, friendId);
		return "success";
	}
	@RequestMapping(value="/removefriend/{friendId}", method=RequestMethod.GET)
	public @ResponseBody String removeFriend(final @PathVariable Long friendId, HttpSession session) {
		User loginUser = (User)session.getAttribute("loginUser");
		friendService.removeFriend(loginUser, friendId);
		return "success";
	}
}
