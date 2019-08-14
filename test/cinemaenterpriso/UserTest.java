package cinemaenterpriso;

import org.junit.Before;
import org.junit.Test;
import receipt.Bookings;
import receipt.Receipt;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        user = new User("Allexander99", "Baltazar", "Alexandru", "alexandru.baltazar@gmail.com", 19, "123");
        receipt = new Receipt("Theatre A", "Location A", "Avatar", "4", 5.50, "Week A", "20:30", 19);
    }

    @Test
    public void getUsername() {
        assertEquals("Allexander99", user.getUsername());
    }

    @Test
    public void setUsername() {
        user.setUsername("Ryan99");
        assertEquals("Ryan99", user.getUsername());
    }

    @Test
    public void getSurname() {
        assertEquals("Baltazar", user.getSurname());
    }

    @Test
    public void setSurname() {
        user.setSurname("Wood");
        assertEquals("Wood", user.getSurname());
    }

    @Test
    public void getForename() {
        assertEquals("Alexandru", user.getForename());
    }

    @Test
    public void setForename() {
        user.setForename("Mike");
        assertEquals("Mike", user.getForename());
    }

    @Test
    public void getEmail() {
        assertEquals("alexandru.baltazar@gmail.com", user.getEmail());
    }

    @Test
    public void setEmail() {
        user.setEmail("alexandrubaltazar@hud.ac.uk");
        assertEquals("alexandrubaltazar@hud.ac.uk", user.getEmail());
    }

    @Test
    public void getAge() {
        assertEquals(19, user.getAge());
    }

    @Test
    public void setAge() {
        user.setAge(12);
        assertEquals(12, user.getAge());
    }

    @Test
    public void getPassword() {
        assertEquals("123", user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("456");
        assertEquals("456", user.getPassword());
    }

    @Test
    public void getProfilePic() {
        user.setProfilePic("parrots.jpg");
        assertEquals("parrots.jpg", user.getProfilePic());
    }

    @Test
    public void setProfilePic() {
        user.setProfilePic("dogs.jpg");
        assertEquals("dogs.jpg", user.getProfilePic());
    }

    @Test
    public void getBookings() {
        ArrayList<Receipt> bookings = new ArrayList<>();

        bookings.add(receipt);
        user.setBookings(bookings);

        assertEquals(bookings, user.getBookings());
    }

    @Test
    public void setBookings() {
        ArrayList<Receipt> bookings = new ArrayList<>();

        bookings.add(receipt);
        user.setBookings(bookings);

        assertEquals(bookings, user.getBookings());
    }
}