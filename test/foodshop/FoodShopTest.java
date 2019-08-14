package foodshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FoodShopTest extends Food {
   private Food popcorn;
   private Food drink;
   private Food snack;
   private FoodShop foodShop;

    @BeforeEach
    void setUp() {

        /*
        When the foodshop object is instantiated it already has all of his food objects stored in the required hashmaps
        We don't need to create them here
         */
        foodShop = new FoodShop();
    }

    @Test
    void getPopcorn() {
        //The hashmap storing the popcorn should not be empty in the beginning
        assertNotNull(foodShop.getPopcorn());

        //Three products should pe stored
        assertEquals(3, foodShop.getPopcorn().size());

        //The keys should be the name of a product stored
        assertEquals("Popcorn Large", foodShop.getPopcorn().get("Popcorn Large").getName());
        assertEquals("Popcorn Medium", foodShop.getPopcorn().get("Popcorn Medium").getName());
        assertEquals("Popcorn Small", foodShop.getPopcorn().get("Popcorn Small").getName());

    }

    @Test
    void getDrinks() {
        //The hashmap storing the popcorn should not be empty in the beginning
        assertNotNull(foodShop.getDrinks());

        //Three products should pe stored
        assertEquals(3, foodShop.getDrinks().size());

        //The keys should be the name of a product stored
        assertEquals("Fanta", foodShop.getDrinks().get("Fanta").getName());
        assertEquals("Coke", foodShop.getDrinks().get("Coke").getName());
        assertEquals("Pepsi", foodShop.getDrinks().get("Pepsi").getName());

    }

    @Test
    void getSnacks() {
        //The hashmap storing the popcorn should not be empty in the beginning
        assertNotNull(foodShop.getSnacks());

        //Three products should pe stored
        assertEquals(3, foodShop.getSnacks().size());

        //The keys should be the name of a product stored
        assertEquals("KitKat", foodShop.getSnacks().get("KitKat").getName());
        assertEquals("M&M", foodShop.getSnacks().get("M&M").getName());
        assertEquals("Haribo", foodShop.getSnacks().get("Haribo").getName());

    }

}