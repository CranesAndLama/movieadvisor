/*package movieadvisor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Watchlist.GET_USER_WATCHLIST, query="Select watchlist.movieId from Watchlist watchlist where watchlist.user.userId = :userId"),
	
})
public class Watchlist {
	public static final String GET_USER_WATCHLIST = "getUserWatchlist";
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private int movieId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}	

	public void setUser(User user) {
		this.user = user;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	

	
}
*/