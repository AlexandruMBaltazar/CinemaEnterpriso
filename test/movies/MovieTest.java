package movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp(){
        movie = new Movie("Frozen",6.00,0, "11:30","7.5", "1h 42min",150);
    }

    @Test
    public void getMovieName() {
        assertEquals("Frozen", movie.getMovieName());
    }

    @Test
    public void setMovieName() {
        movie.setMovieName("Avatar");
        assertEquals("Avatar", movie.getMovieName());
    }

    @Test
    public void getPrice() {
        assertEquals(6.00, movie.getPrice(), 0.0001);
    }

    @Test
    public void setPrice() {
        movie.setPrice(4.00);
        assertEquals(4.00, movie.getPrice(), 0.0001);
    }

    @Test
    public void getAge() {
        assertEquals(0, movie.getAge());
    }

    @Test
    public void setAge() {
        movie.setAge(15);
        assertEquals(15, movie.getAge());
    }

    @Test
    public void getShowTimes() {
        assertEquals("11:30", movie.getShowTimes());
    }

    @Test
    public void setShowTimes() {
        movie.setShowTimes("15:00");
        assertEquals("15:00", movie.getShowTimes());
    }

    @Test
    public void getRating() {
        assertEquals("7.5", movie.getRating());
    }

    @Test
    public void setRating() {
        movie.setRating("8");
        assertEquals("8", movie.getRating());
    }

    @Test
    public void getLength() {
        assertEquals("1h 42min", movie.getLength());
    }

    @Test
    public void setLength() {
        movie.setLength("2h 30min");
        assertEquals("2h 30min", movie.getLength());
    }

    @Test
    public void getSeats() {
        assertEquals(150, movie.getSeats());
    }

    @Test
    public void setSeats() {
        movie.setSeats(90);
        assertEquals(90, movie.getSeats());
    }
}