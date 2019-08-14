package receipt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingsTest {
    Receipt receipt;

    @BeforeEach
    void setUp() {
        this.receipt = new Receipt("Theatre A", "Location A", "Avatar", "4", 5.50, "Week A", "20:30", 19);
    }

    @Test
    void getBookings() {
        //Bookings array list should be empty in the beginning
        assertEquals(0, Bookings.getBookings().size());

        //We should be able to retrieve all items from the bookings array list and should be the same object as the receipts created
        Receipt receipt2 = new Receipt("Theatre B", "Location B", "Titanic", "2", 2.50, "Week B", "11:00", 12);
        Bookings.addBookings(receipt);
        Bookings.addBookings(receipt2);

        assertSame(receipt, Bookings.getBookings().get(0));
        assertSame(receipt2, Bookings.getBookings().get(1));

    }

    @Test
    void addBookings() {
        //We should be able to add any number of receipts to our bookings array list
        Receipt receipt2 = new Receipt("Theatre B", "Location B", "Titanic", "2", 2.50, "Week B", "11:00", 12);
        Bookings.addBookings(receipt);
        Bookings.addBookings(receipt2);

    }

    @Test
    void getCurrentReceipt() {
        //The current receipt should have null values in the beginning
        assertNull(Bookings.getCurrentReceipt().getTheatreName());

        //The current receipt that we get should be the same as the receipt created above
        Bookings.setCurrentReceipt(receipt);
        assertSame(receipt, Bookings.getCurrentReceipt());
    }

    @Test
    void setCurrentReceipt() {
        //We should be able set a current receipt for the user and it should be the same as the receipt above
        Bookings.setCurrentReceipt(receipt);
        assertSame(receipt, Bookings.getCurrentReceipt());
    }
}