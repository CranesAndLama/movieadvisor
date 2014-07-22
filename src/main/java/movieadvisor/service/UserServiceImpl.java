package movieadvisor.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import movieadvisor.model.Friend;
import movieadvisor.model.User;
import movieadvisor.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{
	//List<User> users = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveUser(User newUser) {
		//users.add(newUser);
		return userRepository.saveUser(newUser);
		
	}
	
	public User getUserByUsername(String username) {
		/*for (User user: users) {
			if (user.getUsername().equals(username))
					return user;
		}*/
		return userRepository.getUserByUsername(username);
	}

	public User validateUserLogin(User user) {
		User userFromBD = userRepository.getUserByEmail(user.getEmail());
		if ((userFromBD != null) && (userFromBD.getPassword()).equals(user.getPassword())) 
			return userFromBD;
		else
			return null;
	}

	public Set<User> formUsers(Set<Friend> friendsSet) {
		Set<User> users = new HashSet<User>();
		for (Friend friend: friendsSet) {
			Long friendId = friend.getFriendId();
			User user = userRepository.getUserById(friendId);
			System.out.println("Friend username: " + user.getUsername());
			users.add(user);
		}
		return users;
	}

	public Set<User> getAllUsers(User user) {
		Set<User> users = userRepository.getAllUsers();
		for (User u: users) {
			if (u.getUserId().equals(user.getUserId())) {
				users.remove(u);
				return users;
			}
		}
		return users;
	}
	@Transactional
	public Set<User> searchUsers(String query, Integer page, User loginUser) {
		Set<User> users = userRepository.searchUsers(query);
		if (loginUser != null) {
			for (User user: users) {
				if (loginUser.isFriends(user)) {
					user.setIsFriendWithLogin(true);
				}
			}
		}
		return users;
	}
}
