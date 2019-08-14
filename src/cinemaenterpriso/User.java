package cinemaenterpriso;

import receipt.Receipt;

import java.util.ArrayList;

public class User {
    private String username;
    private String surname;
    private String forename;
    private String email;
    private int age;
    private String password;
    private String profilePic;
    private ArrayList<Receipt> bookings;

    public User() {
        this.username = "";
        this.surname = "";
        this.forename = "";
        this.email = "";
        this.age = -1;
        this.password = "";
    }


    public User(String username, String surename, String forename, String email, int age, String password) {
        this.username = username;
        this.surname = surename;
        this.forename = forename;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public ArrayList<Receipt> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Receipt> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", forename='" + forename + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
