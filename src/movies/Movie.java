package movies;

import java.util.Objects;

public class Movie {

    private String movieName;
    private double price;
    private int age;
    private String showTimes;
    private String rating;
    private String length;
    private int seats;

    public Movie(String movieName, double price, int age, String showTimes, String rating, String length, int seats) {
        this.movieName = movieName;
        this.price = price;
        this.age = age;
        this.showTimes = showTimes;
        this.rating = rating;
        this.length = length;
        this.seats = seats;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    //Used for testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.price, price) == 0 &&
                age == movie.age &&
                seats == movie.seats &&
                Objects.equals(movieName, movie.movieName) &&
                Objects.equals(showTimes, movie.showTimes) &&
                Objects.equals(rating, movie.rating) &&
                Objects.equals(length, movie.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, price, age, showTimes, rating, length, seats);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", price=" + price +
                ", age=" + age +
                ", showTimes='" + showTimes + '\'' +
                ", rating='" + rating + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
