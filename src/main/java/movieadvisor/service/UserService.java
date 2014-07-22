package movieadvisor.service;

import java.util.List;
import java.util.Set;

import movieadvisor.model.Friend;
import movieadvisor.model.User;

public interface UserService {
	User saveUser(User user);
	User getUserByUsername(String username);
	User validateUserLogin(User user);
	Set<User> formUsers(Set<Friend> friendsSet);
	Set<User> getAllUsers(User user);
	Set<User> searchUsers(String query, Integer page, User loginUser);
}
