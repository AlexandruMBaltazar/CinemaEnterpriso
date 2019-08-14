package theatre;

import javafx.scene.text.Text;
import movies.MovieDatabase;

import java.util.ArrayList;

public class TheatreDatabase {


    private static ArrayList<Theatre> week1;
    private static ArrayList<Theatre>week2;
    private static ArrayList<Theatre>week3;
    private static ArrayList<Theatre>week4;
    private static ArrayList<Theatre>week5;
    private static ArrayList<Theatre>week6;
    private static ArrayList<Theatre>week7;
    private static Theatre selectedTheatre;


    public static ArrayList<Theatre> getTheatres(){

        ArrayList<Theatre> theatres = new ArrayList<>();
        theatres.clear();

        theatres.add(new Theatre("Theatre A", "Location A", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre B", "Location B", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre C", "Location C", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre D", "Location D", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre E", "Location E", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre F", "Location F", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre G", "Location G", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre H", "Location H", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre I", "Location I", MovieDatabase.getMovies()));
        theatres.add(new Theatre("Theatre J", "Location J", MovieDatabase.getMovies()));

        return theatres;
    }

    public static void setTheatresForEachWeek(){
        week1 = getTheatres();
        week2 = getTheatres();
        week3 = getTheatres();
        week4 = getTheatres();
        week5 = getTheatres();
        week6 = getTheatres();
        week7 = getTheatres();
    }

    public static ArrayList<Theatre> getWeek1() {
        return week1;
    }

    public static ArrayList<Theatre> getWeek2() {
        return week2;
    }

    public static ArrayList<Theatre> getWeek3() {
        return week3;
    }

    public static ArrayList<Theatre> getWeek4() {
        return week4;
    }

    public static ArrayList<Theatre> getWeek5() {
        return week5;
    }

    public static ArrayList<Theatre> getWeek6() {
        return week6;
    }

    public static ArrayList<Theatre> getWeek7() {
        return week7;
    }

    public static Theatre getSelectedTheatre() {
        return selectedTheatre;
    }

    public static void setSelectedTheatre(Theatre selectedTheatre, Theatre weekTheatre) {
        TheatreDatabase.selectedTheatre = selectedTheatre;
        weekTheatre = TheatreDatabase.selectedTheatre;
    }


    public static void updateTheatreSeats(String ticketsBought, int movieChoiche){
        selectedTheatre.getMovies().get(movieChoiche).setSeats(selectedTheatre.getMovies().get(movieChoiche).getSeats() - Integer.parseInt(ticketsBought));
    }

}
