import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEmptyMovieList.class, TestMovieList.class, TestMovieListWithOneMovie.class,
		TestMovieListWithTwoMovies.class })
public class AllTests {

}
