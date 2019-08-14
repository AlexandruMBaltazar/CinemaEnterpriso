package theatre;

import movies.Movie;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Theatre {
    private String name;
    private String location;
    private ArrayList<String> moviesSeats = new ArrayList<>();
    private String week;
    private ArrayList<Movie> movies;
    private ArrayList<String> moviesName = new ArrayList<>();
    private ArrayList<String> moviesPrice = new ArrayList<>();
    private ArrayList<String> moviesAge = new ArrayList<>();

    public Theatre() {

    }

    public Theatre(String name, String location, ArrayList<Movie> movies) {
        this.name = name;
        this.location = location;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String day) {
        this.week = day;
    }

    public String getMoviesName(){
        moviesName.clear();
        moviesName.add(getMovies().get(0).getMovieName());
        moviesName.add(getMovies().get(1).getMovieName());
        return moviesName.stream().collect(Collectors.joining("\n"));
    }

    public String getMoviesPrice(){
        moviesPrice.clear();
        moviesPrice.add(Double.toString(getMovies().get(0).getPrice()));
        moviesPrice.add(Double.toString(getMovies().get(1).getPrice()));
        return moviesPrice.stream().collect(Collectors.joining("\n"));
    }

    public String getMoviesAge(){
        moviesAge.clear();
        moviesAge.add(Integer.toString(getMovies().get(0).getAge()));
        moviesAge.add(Integer.toString(getMovies().get(1).getAge()));
        return moviesAge.stream().collect(Collectors.joining("\n"));
    }

    public String getMoviesSeats(){
        moviesSeats.clear();
        moviesSeats.add(Integer.toString(getMovies().get(0).getSeats()));
        moviesSeats.add(Integer.toString(getMovies().get(1).getSeats()));
        return moviesSeats.stream().collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", week='" + week + '\'' +
                ", movies=" + movies +
                ", moviesName=" + moviesName +
                ", moviesPrice=" + moviesPrice +
                ", moviesAge=" + moviesAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return name.equals(theatre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
