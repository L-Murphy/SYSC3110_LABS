import java.util.ArrayList;

public class MovieList {
	private ArrayList<Movie> movieList;
	
	public MovieList() {
		this.movieList = new ArrayList<Movie>();
	}
	
	public int size() {
		return this.movieList.size();
	}
	
	public void add(Movie aMovie) {
		this.movieList.add(aMovie);
	}
	
	public boolean contains(Movie aMovie) {
		return movieList.contains(aMovie);
	}
}
