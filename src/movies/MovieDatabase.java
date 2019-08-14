package movies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class MovieDatabase {
    private static ArrayList<Movie> movieDatabase = new ArrayList<Movie>() {
        {
            add(new Movie("Avatar",5.00,12,"12:30", "7.8","2h 42min",100));
            add(new Movie("Star Wars The Last Jedi", 7.00,12, "5:30","7.2", "2h 32min",100));
            add(new Movie("Frozen",6.00,0, "11:30","7.5", "1h 42min",150));
            add(new Movie("The Ring",1.50,15, "16:30","7.1", "1h 55min",150));
            add(new Movie("The Godfather",2.00,15, "12:00","9.2", "2h 55min",200));
            add(new Movie("Schindler's List",2.00,15, "17:00","8.9", "3h 15min",200));
            add(new Movie("The Silence Of The Lambs",2.00,15, "13:30","8.6", "1h 58min",90));
            add(new Movie("Titanic",2.00,12, "17:30","7.8", "3h 14min",90));
            add(new Movie("Logan",6.00,15, "11:25","8.1", "2h 17min",120));
            add(new Movie("IT",5.50,15, "18:30","7.4", "2h 15min",120));
            add(new Movie("John Wick Chapter 2",7.00,18, "17:30","7.5", "2h 2min",100));
            add(new Movie("John Wick",5.50,15, "12:15","7.3", "1h 41min",100));
            add(new Movie("The Incredibles",2.00,0, "12:00","8.0", "1h 55min",80));
            add(new Movie("The Incredibles II",7.00,0, "14:30","7.8", "1h 58min",80));
            add(new Movie("Braveheart",2.00,15, "10:30","8.4", "2h 58min",120));
            add(new Movie("Jurassic World",4.50,12, "14:30","7.0", "2h 4min",120));
            add(new Movie("Ant-Man",5.50,12, "11:30","7.3", "1h 57min",200));
            add(new Movie("Creed 2",7.50,12, "15:30","7.6", "2h 13min",200));
            add(new Movie("Assassin's Creed",5.50,12, "13:30","5.8", "1h 55min",100));
            add(new Movie("The Matrix",2.00,15, "17:30","8.7", "2h 16min",100));
        }
    };

    private static ArrayList<Movie>movies = (ArrayList<Movie>) movieDatabase.clone();

    public static ArrayList<Movie> getMovies(){

        ArrayList<Movie>tempMovieList = new ArrayList<>();
        tempMovieList.clear();

        if(movies.isEmpty()){
            movies = (ArrayList<Movie>) movieDatabase.clone();
        }

        for(int i=0; i<= 1; i++){
            tempMovieList.add(movies.get(0));
            movies.remove(0);
        }

        return tempMovieList;
    }


    //Used for testing
    public static ArrayList<Movie> getMovieDatabase() {
        return movieDatabase;
    }
}
