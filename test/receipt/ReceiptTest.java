package receipt;

import foodshop.Food;
import foodshop.Popcorn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptTest {

    private Receipt receipt;
    private Food popcorn;

    @Before
    public void setUp(){
        receipt = new Receipt("Theatre A", "Location A", "Avatar", "4", 5.50, "Week A", "20:30", 19);
        popcorn = new Popcorn("Popcorn Large",5,1,"Large");
    }

    @Test
    public void getTheatreName() {
        assertEquals("Theatre A", receipt.getTheatreName());
    }

    @Test
    public void getTheatreLocation() {
        assertEquals("Location A", receipt.getTheatreLocation());
    }

    @Test
    public void getMovieName() {
        assertEquals("Avatar", receipt.getMovieName());
    }

    @Test
    public void getTickets() {
        assertEquals("4", receipt.getTickets());
    }

    @Test
    public void getTicketsPrice() {
        assertEquals(5.50, receipt.getTicketsPrice(),0.0001);
    }

    @Test
    public void getWeek() {
        assertEquals("Week A", receipt.getWeek());
    }

    @Test
    public void setWeek() {
        receipt.setWeek("Week C");
        assertEquals("Week C", receipt.getWeek());
    }

    @Test
    public void getShowTime() {
        assertEquals("Week A", receipt.getWeek());
    }

    @Test
    public void getFoodSelected() {
        receipt.getFoodSelected().add(popcorn);

        assertSame(popcorn, receipt.getFoodSelected().get(0));
    }

    @Test
    public void getPayment() {
        receipt.setPayment("By Card");
        assertEquals("By Card", receipt.getPayment());
    }

    @Test
    public void setPayment() {
        receipt.setPayment("By Card");
        assertEquals("By Card", receipt.getPayment());
    }

    @Test
    public void getTotalPayment() {
        receipt.setTotalPayment(20);
        assertEquals(20, receipt.getTotalPayment(), 0.0001);
    }

    @Test
    public void setTotalPayment() {
        receipt.setTotalPayment(20);
        assertEquals(20, receipt.getTotalPayment(), 0.0001);
    }

    @Test
    public void getAge() {
        receipt.setAge(19);
        assertEquals(19, receipt.getAge());
    }

    @Test
    public void setAge() {
        receipt.setAge(19);
        assertEquals(19, receipt.getAge());
    }
}