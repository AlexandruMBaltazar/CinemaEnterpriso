package cinemaenterpriso;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {
    private User user;



    @BeforeEach
    void setUp() {
        this.user = new User("Allexander99", "Alexandru", "Baltazar", "alexandru.baltazar@gmail.com,", 19, "123");
        UserDatabase.addUser(user.getUsername(),user);
    }

    @Test
    void addUser() {

        //We will add another user to make sure that our addUser method works
        User newUser = new User("Ryan99", "Ryan", "Lawton", "ryan.lawton@gmail.com,", 18, "1234");
        UserDatabase.addUser(newUser.getUsername(), newUser);

        //userDatabase should not be null
        assertNotNull(UserDatabase.getUsers());
    }

    @Test
    void getUsers() {

        //userDatabase should not be null
        assertNotNull(UserDatabase.getUsers());

        //The key of the hashmap should be equal with the user's username
        assertEquals(user.getUsername(), UserDatabase.getUsers().get(user.getUsername()).getUsername());

        //The user retrieved from our hashmap should be the same user that we have created above
        assertSame(user, UserDatabase.getUsers().get(user.getUsername()));


    }

    @Test
    void setCurrentUser() {

        //The currentUser should be retrieved successfully from the userDatabase hashmap
        UserDatabase.setCurrentUser(UserDatabase.getUsers().get(user.getUsername()));

        //currentUser should not be null
        assertNotNull(UserDatabase.getCurrentUser());

    }

    @Test
    void getCurrentUser() {

        UserDatabase.setCurrentUser(UserDatabase.getUsers().get(user.getUsername()));

        //currentUser should not be null
        assertNotNull(UserDatabase.getCurrentUser());

        //The currentUser should be the same user that we have created above
        assertSame(user, UserDatabase.getCurrentUser());

    }
}