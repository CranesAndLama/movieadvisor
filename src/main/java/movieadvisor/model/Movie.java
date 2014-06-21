package movieadvisor.model;

import info.movito.themoviedbapi.model.MovieDb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

class MovieId {
	private Long movieId;
	private Long userId;
}

@Entity @IdClass(MovieId.class)
@NamedQueries({
	@NamedQuery(name=Movie.GET_RATING_BY_USERID_AND_MOVIEID, 
			query="Select movie1 from Movie movie1 where (movie1.user.userId = :userId and movie1.movieId = :movieId)"),
	@NamedQuery(name=Movie.GET_USER_WATCHLIST, 
			query="Select movie1 from Movie movie1 where (movie1.user.userId = :userId and movie1.isInWatchlist = true)"),
	@NamedQuery(name=Movie.GET_RECENTLY_VIEWED, 
			query="Select movie1 from Movie movie1 where (movie1.user.userId = :userId and movie1.isRecentlyViewed = true)"),
	@NamedQuery(name=Movie.GET_ALL_USER_MOVIES, 
			query="Select movie1 from Movie movie1 where movie1.user.userId = :userId")
})
public class Movie implements Serializable, Comparable{

	public static final String GET_RATING_BY_USERID_AND_MOVIEID = "getMovieRating";
	public static final String GET_USER_WATCHLIST = "getUserWatchlist";
	public static final String GET_RECENTLY_VIEWED = "getRecentlyViewed";
	public static final String GET_ALL_USER_MOVIES = "getAllUserMovies";
	
	public static final String POSTER_BASE_URL = "http://image.tmdb.org/t/p/w500"; 

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;*/
	
	private Byte rating;
	
	@Id
	private Long movieId;
	
	@Id
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	private Boolean isInWatchlist = false;
	
	private Boolean isRecentlyViewed = false;

	@Transient
	private MovieDb movieDb;
	
	@Transient
	private String poster;

	public Movie() {
		
	}
	public Movie(MovieDb movieDb) {
		this.movieDb = movieDb;
		poster = POSTER_BASE_URL + movieDb.getPosterPath();
		Integer i = movieDb.getId();
		movieId =  i.longValue();
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MovieDb getMovieDb() {
		return movieDb;
	}
	public void setMovieDb(MovieDb movieDb) {
		this.movieDb = movieDb;
	}
	
	public Byte getRating() {
		return rating;
	}

	public void setRating(Byte rating) {
		this.rating = rating;
	}
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Boolean getIsInWatchlist() {
		return isInWatchlist;
	}
	public void setIsInWatchlist(Boolean isInWatchlist) {
		this.isInWatchlist = isInWatchlist;
	}
	public Boolean getIsRecentlyViewed() {
		return isRecentlyViewed;
	}
	public void setIsRecentlyViewed(Boolean isRecentlyViewed) {
		this.isRecentlyViewed = isRecentlyViewed;
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
		Movie otherObject = (Movie)other;
		if ((this.getMovieId() == otherObject.getMovieId()) 
				&& (this.getUser().getUserId() == otherObject.getUser().getUserId())) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public int compareTo(Object o) {
		Movie movie = (Movie)o;
		if (this.getMovieId() > movie.getMovieId()) return 1;
		else if (this.getMovieId() < movie.getMovieId()) return -1;
		else return 0;
	}

}
