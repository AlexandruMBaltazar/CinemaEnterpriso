package foodshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteFoodTest {

    private Food concreteFood;

    @BeforeEach
    void setUp() {
        concreteFood = new ConcreteFood("Oreo", 1.50, 3);
    }

    @Test
    void getName() {
        assertEquals("Oreo", concreteFood.getName());
    }

    @Test
    void setName() {
        concreteFood.setName("Kit Kat");
        assertEquals("Kit Kat", concreteFood.getName());
    }

    @Test
    void getPrice() {
        assertEquals(1.50, concreteFood.getPrice());
    }

    @Test
    void setPrice() {
        concreteFood.setPrice(2.50);
        assertEquals(2.50, concreteFood.getPrice());
    }

    @Test
    void getQuantity() {
        assertEquals(3, concreteFood.getQuantity());
    }

    @Test
    void setQuantity() {
        concreteFood.setQuantity(4);
        assertEquals(4, concreteFood.getQuantity());
    }
}