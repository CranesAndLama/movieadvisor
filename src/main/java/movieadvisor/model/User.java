package movieadvisor.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name=User.GET_USER_BY_USERNAME, query="Select user1 from User user1 where user1.username = :username"),
	@NamedQuery(name=User.GET_USER_BY_EMAIL, query="Select user1 from User user1 where user1.email = :email"),
	@NamedQuery(name=User.GET_ALL_USERS, query="Select user1 from User user1")
})
public class User {
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	@Id
	@GeneratedValue
	private Long userId;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
	private String username;
	
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
	private String fullName;
	
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	private String password;
	
	@Pattern(regexp=EMAIL_PATTERN, message="Invalid email address.")
	private String email;
	
	/*@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Watchlist> watchlist = new ArrayList<Watchlist>(0);*/  
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Movie> ratedMovies = new ArrayList<Movie>(0);
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Friend> friends = new HashSet<Friend>(0);
	
	/*@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<RecentlyViewedMovie> recentlyViewed = new ArrayList<RecentlyViewedMovie>(0);*/
	

	
/*	private String city;
	private String country;
	private Date birthDate;*/
	
	
	
	
	public static final String GET_USER_BY_USERNAME = "getUserByUsername";
	public static final String GET_USER_BY_EMAIL = "getUserByEmail";
	public static final String GET_ALL_USERS = "getAllUsers";
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
/*	public List<Watchlist> getWatchlist() {
		return watchlist;
	}
	public void setWatchlist(List<Watchlist> watchlist) {
		this.watchlist = watchlist;
	}*/

	public List<Movie> getRatedMovies() {
		return ratedMovies;
	}
	public void setRatedMovies(List<Movie> ratedMovies) {
		this.ratedMovies = ratedMovies;
	}
	public Set<Friend> getFriends() {
		return friends;
	}
	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
/*	public List<RecentlyViewedMovie> getRecentlyViewed() {
		return recentlyViewed;
	}
	public void setRecentlyViewed(List<RecentlyViewedMovie> recentlyViewed) {
		this.recentlyViewed = recentlyViewed;
	}*/
	
/*	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}*/
	
}