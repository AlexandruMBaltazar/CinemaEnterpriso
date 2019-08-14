package cinemaenterpriso;
import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class UserDatabase {

    //I am going to store all of my users in a hashmap called userDatabase
    private static HashMap<String,User> usersDatabase = new HashMap<>();

    //The logged in user will be stored in the currentUser object
    private static User currentUser = new User();

    public static void addUser(String key, User user){
        usersDatabase.put(key, user);
    }

    public static void setUsersDatabase(HashMap<String, User> usersDatabase) {
        UserDatabase.usersDatabase = usersDatabase;
    }

    public static HashMap<String,User> getUsers(){
        return usersDatabase;
    }


    public static void setCurrentUser(User user){
        currentUser = user;
    }

    public static User getCurrentUser(){
        return currentUser;
    }

}
