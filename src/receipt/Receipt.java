package receipt;

import foodshop.Food;
import movies.Movie;
import theatre.Theatre;

import java.util.ArrayList;

public class Receipt {
    private String theatreName;
    private String theatreLocation;
    private String movieName;
    private String tickets;
    private Double ticketsPrice;
    private String week;
    private String showTime;
    private int age;
    private ArrayList<Food> foodSelected = new ArrayList<>();
    private double totalPayment;
    private String payment;


    public Receipt() {
    }

    public Receipt(String theatreName, String theatreLocation, String movieName, String tickets, Double ticketsPrice, String week, String showTime, int age) {
        this.theatreName = theatreName;
        this.theatreLocation = theatreLocation;
        this.movieName = movieName;
        this.tickets = tickets;
        this.ticketsPrice = ticketsPrice;
        this.week = week;
        this.showTime = showTime;
        this.age = age;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTickets() {
        return tickets;
    }

    public Double getTicketsPrice() {
        return ticketsPrice;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getShowTime() {
        return showTime;
    }

    public ArrayList<Food> getFoodSelected() {
        return foodSelected;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "theatreName='" + theatreName + '\'' +
                ", theatreLocation='" + theatreLocation + '\'' +
                ", movieName='" + movieName + '\'' +
                ", tickets='" + tickets + '\'' +
                ", ticketsPrice=" + ticketsPrice +
                ", week='" + week + '\'' +
                ", showTime='" + showTime + '\'' +
                ", foodSelected=" + foodSelected +
                ", payment='" + payment + '\'' +
                '}';
    }
}
