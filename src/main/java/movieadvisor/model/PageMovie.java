package movieadvisor.model;

import java.util.List;

public class PageMovie {
	private List<Movie> movies;
	private int numberOfPages;
	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public PageMovie(List<Movie> movies, int numberOfPages) {
		this.movies = movies;
		this.numberOfPages = numberOfPages;
	}
}
