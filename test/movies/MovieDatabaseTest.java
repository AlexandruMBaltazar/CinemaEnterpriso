package movies;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieDatabaseTest {

    Object[] expectedMovies = new Object[2];

    @Before
    public void setUp() throws Exception {
        expectedMovies[0] = new Movie("Frozen",6.00,0, "11:30","7.5", "1h 42min",150);
        expectedMovies[1] = new Movie("The Ring",1.50,15, "16:30","7.1", "1h 55min",150);
    }

    @Test
    public void getMovies() {
          /*It should only return two movies every time when the method is called
          Because each theatre will display only 2 movies
        */
        assertEquals(2, MovieDatabase.getMovies().size());

        /*
        When we call the method a second time it should return the next two movies:
        Frozen and The Ring
         */

        Object[] testMovies = MovieDatabase.getMovies().toArray();
        assertArrayEquals(expectedMovies, testMovies);
    }

    @Test
    public void getMoviesRepopulate(){
        /*I created a different test method that will specifically test if after we get the movies for one week it will
        automatically repopulate for the second and so on.
         */

        //Firstly I will empty my list so we need to call the method 10 times (10 theatres)
        //Test if the list is empty after that
        for(int i = 0; i < 10; i++ ){
            if(MovieDatabase.getMovieDatabase().isEmpty()){
                assertEquals(0, MovieDatabase.getMovieDatabase().size());
            }
            MovieDatabase.getMovies();
        }

        //Test if the list is repopulated
        assertEquals(20, MovieDatabase.getMovieDatabase().size());
    }
}