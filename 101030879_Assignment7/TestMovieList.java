import junit.framework.TestCase;

public class TestMovieList extends TestCase {
	 private MovieList movieList;
	 private Movie starWars;
	 private Movie starTrek;
	 private Movie stargate;
	 
	 protected void setUp() {
		 this.movieList = new MovieList();
		 this.starWars = new Movie("Star Wars");
		 this.starTrek = new Movie("Star Trek");
		 this.stargate = new Movie("StarGate");
	 }
	 
	public void testEmptyListSize() {
		 assertEquals("Size of empty movie list should be 0.", 0, this.movieList.size());
	 }
	 
	 public void testSizseAfterAddingOne() {
		 this.movieList.add(starWars);
		 assertEquals("Size of one item list should be 1.", 1, this.movieList.size());
	 }

	 public void testSizeAfterAddingTwo() {
		 this.movieList.add(starWars);
		 this.movieList.add(starTrek);
		 assertEquals("Size of a two item list should be 2.", 2,  this.movieList.size());
	}

	 public void testContents() {
		 movieList.add(starWars);
		 movieList.add(starTrek);
		 assertTrue("List should contain starWars.", movieList.contains(starWars));
		 assertTrue("List should contain starTrek.", movieList.contains(starTrek));
		 assertFalse("List should not contain stargate.", movieList.contains(stargate));
		}

	 
	 
	 public static void main(String[] args) {
	 junit.textui.TestRunner.run(TestMovieList.class);
	 }
}
