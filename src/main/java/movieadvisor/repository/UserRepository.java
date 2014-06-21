package movieadvisor.repository;

import java.util.Set;

import movieadvisor.model.User;

public interface UserRepository {
	public User saveUser(User user);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	public User getUserById(Long friendId);
	public Set<User> getAllUsers();
}
