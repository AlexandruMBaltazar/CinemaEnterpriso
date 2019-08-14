package receipt;

import java.util.ArrayList;

public class Bookings {
   private static ArrayList<Receipt> bookings = new ArrayList<>();
   private static Receipt currentBooking = new Receipt();

    public static ArrayList<Receipt> getBookings() {
        return bookings;
    }

    public static void addBookings(Receipt currentBooking){
        bookings.add(currentBooking);
    }

    public static Receipt getCurrentReceipt() {
        return currentBooking;
    }

    public static void setCurrentReceipt(Receipt currentReceipt) {
        currentBooking = currentReceipt;
    }

}
