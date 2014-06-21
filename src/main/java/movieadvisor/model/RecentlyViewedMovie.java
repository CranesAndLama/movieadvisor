/*package movieadvisor.model;

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
	@NamedQuery(name=RecentlyViewedMovie.GET_MOVIE_BY_USERID_AND_MOVIEID, 
			query="Select movie from RecentlyViewedMovie movie where (movie.user.userId = :userId and movie.movieId = :movieId)")
})
public class RecentlyViewedMovie {
	public static final String GET_MOVIE_BY_USERID_AND_MOVIEID = "getRecentlyViewed";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public void setMovieId(int movieId2) {
		this.movieId = movieId2;
	}
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (this.getClass() != other.getClass()) {
			return false;
		}
		RecentlyViewedMovie otherObject = (RecentlyViewedMovie)other;
		if ((this.getMovieId() == otherObject.getMovieId()) 
				&& (this.getUser().getUserId() == otherObject.getUser().getUserId())) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
*/