package foodshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FoodShop {

    private Popcorn largePopcorn = new Popcorn("Popcorn Large",5,0,"Large");
    private Popcorn mediumPopcorn = new Popcorn("Popcorn Medium",4,0,"Medium");
    private Popcorn smallPopcorn = new Popcorn("Popcorn Small",2.5,0,"Small");
    private Drinks fanta = new Drinks("Fanta",1.50,0);
    private Drinks coke = new Drinks("Coke",1.50,0);
    private Drinks pepsi = new Drinks("Pepsi",1.50,0);
    private Snacks kitkat = new Snacks("KitKat", 2.50,0);
    private Snacks mm = new Snacks("M&M", 2.50,0);
    private Snacks haribo = new Snacks("Haribo", 2.50,0);

    private Map<String,Food> popcorn = new HashMap<String, Food>(){
        {
            put(largePopcorn.getName(),largePopcorn);
            put(mediumPopcorn.getName(),mediumPopcorn);
            put(smallPopcorn.getName(),smallPopcorn);
        }
    };

    private Map<String,Food> drinks = new HashMap<String, Food>(){
        {
            put(fanta.getName(),fanta);
            put(coke.getName(),coke);
            put(pepsi.getName(),pepsi);
        }
    };


    private Map<String,Food> snacks = new HashMap<String, Food>(){
        {
            put(kitkat.getName(),kitkat);
            put(mm.getName(),mm);
            put(haribo.getName(),haribo);
        }
    };

    // No setters needed
    public Map<String, Food> getPopcorn() {
        return popcorn;
    }

    public Map<String, Food> getDrinks() {
        return drinks;
    }

    public Map<String, Food> getSnacks() {
        return snacks;
    }


}
