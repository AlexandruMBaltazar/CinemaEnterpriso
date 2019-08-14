package theatre;

import movies.MovieDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TheatreDatabaseTest {

    private ArrayList<Theatre> theatres;
    private Theatre theatre;



    @Test
    void getTheatres() {
        theatres = TheatreDatabase.getTheatres();

        //The arraylist theatres should not be null
        assertNotNull(theatres);

        //There should be 10 theatres
        assertEquals(10, theatres.size());

    }

    @Test
    void setTheatresForEachWeek() {
        TheatreDatabase.setTheatresForEachWeek();

        assertNotNull(TheatreDatabase.getWeek1());
        assertNotNull(TheatreDatabase.getWeek2());
        assertNotNull(TheatreDatabase.getWeek3());
        assertNotNull(TheatreDatabase.getWeek4());
        assertNotNull(TheatreDatabase.getWeek5());
        assertNotNull(TheatreDatabase.getWeek6());
        assertNotNull(TheatreDatabase.getWeek7());

    }

    @BeforeEach
    void setUp() {
        TheatreDatabase.setTheatresForEachWeek();
    }

    @Test
    void getWeek1() {
        assertNotNull(TheatreDatabase.getWeek1());
    }

    @Test
    void getWeek2() {
        assertNotNull(TheatreDatabase.getWeek2());
    }

    @Test
    void getWeek3() {
        assertNotNull(TheatreDatabase.getWeek3());
    }

    @Test
    void getWeek4() {
        assertNotNull(TheatreDatabase.getWeek4());
    }

    @Test
    void getWeek5() {
        assertNotNull(TheatreDatabase.getWeek5());
    }

    @Test
    void getWeek6() {
        assertNotNull(TheatreDatabase.getWeek6());
    }

    @Test
    void getWeek7() {
        assertNotNull(TheatreDatabase.getWeek7());
    }

    @Test
    void getSelectedTheatre() {
        theatre = new Theatre("Theatre A", "Location A", MovieDatabase.getMovies());

        //The selected theatre should be empty in the beginning
        assertNull(TheatreDatabase.getSelectedTheatre());

        //After "selection" it should not be null
        TheatreDatabase.setSelectedTheatre(theatre, TheatreDatabase.getWeek1().get(0));
        assertNotNull(TheatreDatabase.getSelectedTheatre());

        //The selected theatre should be equal with the theatre created above
        assertSame(theatre, TheatreDatabase.getSelectedTheatre());
    }

    @Test
    void setSelectedTheatre() {
        theatre = new Theatre("Theatre A", "Location A", MovieDatabase.getMovies());

        TheatreDatabase.setSelectedTheatre(theatre, TheatreDatabase.getWeek1().get(0));
        assertNotNull(TheatreDatabase.getSelectedTheatre());

    }
}