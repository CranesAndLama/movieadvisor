package movieadvisor.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import movieadvisor.model.User;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	public User saveUser(User user) {
		if (user.getUserId() == null) {
			em.persist(user);
			em.flush(); 
		}
		else {
			user = em.merge(user);
		}
		return user;
	}
	public User getUserByUsername(String username) {
		//Query query = em.createQuery("Select user from User user where user.username = :username");
		TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_USERNAME, User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
		User user = users.get(0);
		return user;
	}
	public User getUserByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery(User.GET_USER_BY_EMAIL, User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		User user = users.get(0);
		System.out.println(user.getEmail() + "  " + user.getPassword());
		return user;
	}
	public User getUserById(Long friendId) {
		User user = (User) em.find(User.class, friendId);
		System.out.println("User username after DB: " + user.getUsername());
		return user;
	}
	public Set<User> getAllUsers() {
		TypedQuery<User> query = em.createNamedQuery(User.GET_ALL_USERS, User.class);
		List<User> listUsers = query.getResultList();
		Set<User> users = new HashSet<User>(listUsers);
		return users;
	}

}
