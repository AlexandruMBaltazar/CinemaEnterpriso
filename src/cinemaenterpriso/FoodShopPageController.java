package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import foodshop.FoodShop;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import receipt.Bookings;

import java.awt.event.ActionEvent;
import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToLongFunction;

public class FoodShopPageController implements Initializable {
    @FXML
    private JFXButton backButton;

    @FXML
    private Button largePopcornButton;

    @FXML
    private Label largePopcornPriceLBL;

    @FXML
    private Label mediumPopcornPriceLBL;

    @FXML
    private Label smallPopcornPriceLBL;

    @FXML
    private Button mediumPopcornButton;

    @FXML
    private Button smallPopcornButton;

    @FXML
    private Button fantaButton;

    @FXML
    private Label fantaPriceLBL;

    @FXML
    private Label cokePriceLBL;

    @FXML
    private Label pepsiPriceLBL;

    @FXML
    private Button cokeButton;

    @FXML
    private Button pepsiButton;

    @FXML
    private Button kitkatButton;

    @FXML
    private Label kitkatPriceLBL;

    @FXML
    private Label mmPriceLBL;

    @FXML
    private Label hariboPriceLBL;

    @FXML
    private Button mmButton;

    @FXML
    private Button hariboButton;

    @FXML
    private Label largePopcornQuantityLBL;

    @FXML
    private Label mediumPopcornQuantityLBL;

    @FXML
    private Label smallPopcornQuantityLBL;

    @FXML
    private Label fantaQuantityLBL;

    @FXML
    private Label cokeQuantityLBL;

    @FXML
    private Label pepsiQuantityLBL;

    @FXML
    private Label kitkatQuantityLBL;

    @FXML
    private Label mmQuantityLBL;

    @FXML
    private Label hariboQuantityLBL;

    @FXML
    private Label ticketsQuantityLBL;

    @FXML
    private Label totalLBL;

    @FXML
    private JFXButton paymentButton;

    private FoodShop foodShop;
    private Integer largePopcornQuantity = 0;
    private Integer mediumPopcornQuantity = 0;
    private Integer smallPopcornQuantity = 0;
    private Integer fantaQuantity = 0;
    private Integer cokeQuantity = 0;
    private Integer pepsiQuantity = 0;
    private Integer kitkatQuantity = 0;
    private Integer mmQuantity = 0;
    private Integer hariboQuantity = 0;
    private Double total = 0.00;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        foodShop = new FoodShop();

        System.out.println(Bookings.getCurrentReceipt());

        ticketsQuantityLBL.setText(Bookings.getCurrentReceipt().getTickets());
        totalLBL.setText(Double.toString(total = Bookings.getCurrentReceipt().getTicketsPrice()));

        setPricesForPopcorn(Double.toString(foodShop.getPopcorn().get("Popcorn Large").getPrice()),Double.toString(foodShop.getPopcorn().get("Popcorn Medium").getPrice()), Double.toString(foodShop.getPopcorn().get("Popcorn Small").getPrice()) );
        setPricesForDrinks(Double.toString(foodShop.getDrinks().get("Fanta").getPrice()),Double.toString(foodShop.getDrinks().get("Coke").getPrice()), Double.toString(foodShop.getDrinks().get("Pepsi").getPrice()));
        setPricesForSnacks(Double.toString(foodShop.getSnacks().get("KitKat").getPrice()),Double.toString(foodShop.getSnacks().get("M&M").getPrice()), Double.toString(foodShop.getSnacks().get("Haribo").getPrice()));
    }

    public void setPricesForPopcorn(String largePopcornPrice, String mediumPopcornPrice, String smallPopcornPrice){
        largePopcornPriceLBL.setText("£" + largePopcornPrice);
        mediumPopcornPriceLBL.setText("£" + mediumPopcornPrice);
        smallPopcornPriceLBL.setText("£" + smallPopcornPrice);
    }

    public void setPricesForDrinks(String fantaPrice, String cokePrice, String pepsiPrice){
        fantaPriceLBL.setText("£" + fantaPrice);
        cokePriceLBL.setText("£" + cokePrice);
        pepsiPriceLBL.setText("£" + pepsiPrice);
    }

    public void setPricesForSnacks(String kitkatPrice, String mmPrice, String hariboPrice){
        kitkatPriceLBL.setText("£" + kitkatPrice);
        mmPriceLBL.setText("£" + mmPrice);
        hariboPriceLBL.setText("£" + hariboPrice);
    }

    public void calculatePopcornTotal(String productName){
        total = total + (foodShop.getPopcorn().get(productName).getPrice());
        totalLBL.textProperty().bind(new SimpleStringProperty(Double.toString(total)));
    }

    public void calculateDrinksTotal(String productName){
        total = total + (foodShop.getDrinks().get(productName).getPrice());
        totalLBL.textProperty().bind(new SimpleStringProperty(Double.toString(total)));
    }

    public void calculateSnacksTotal(String productName){
        total = total + (foodShop.getSnacks().get(productName).getPrice());
        totalLBL.textProperty().bind(new SimpleStringProperty(Double.toString(total)));
    }


    public void largePopcornButtonClicked() {
        largePopcornQuantity++;
        foodShop.getPopcorn().get("Popcorn Large").setQuantity(largePopcornQuantity);
        largePopcornQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getPopcorn().get("Popcorn Large").getQuantity())));
        calculatePopcornTotal("Popcorn Large");
    }


    public void mediumPopcornButtonClicked() {
        mediumPopcornQuantity++;
        foodShop.getPopcorn().get("Popcorn Medium").setQuantity(mediumPopcornQuantity);
        mediumPopcornQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getPopcorn().get("Popcorn Medium").getQuantity())));
        calculatePopcornTotal("Popcorn Medium");
    }


    public void smallPopcornButtonClicked() {
        smallPopcornQuantity++;
        foodShop.getPopcorn().get("Popcorn Small").setQuantity(smallPopcornQuantity);
        smallPopcornQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getPopcorn().get("Popcorn Small").getQuantity())));
        calculatePopcornTotal("Popcorn Small");
    }


    public void fantaButtonClicked(){
        fantaQuantity++;
        foodShop.getDrinks().get("Fanta").setQuantity(fantaQuantity);
        fantaQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getDrinks().get("Fanta").getQuantity())));
        calculateDrinksTotal("Fanta");
    }

    public void cokeButtonClicked(){
        cokeQuantity++;
        foodShop.getDrinks().get("Coke").setQuantity(cokeQuantity);
        cokeQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getDrinks().get("Coke").getQuantity())));
        calculateDrinksTotal("Coke");
    }

    public void pepsiButtonClicked(){
        pepsiQuantity++;
        foodShop.getDrinks().get("Pepsi").setQuantity(pepsiQuantity);
        pepsiQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getDrinks().get("Pepsi").getQuantity())));
        calculateDrinksTotal("Pepsi");
    }


    public void kitkatButtonClicked(){
        kitkatQuantity++;
        foodShop.getSnacks().get("KitKat").setQuantity(kitkatQuantity);
        kitkatQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getSnacks().get("KitKat").getQuantity())));
        calculateSnacksTotal("KitKat");
    }

    public void mmButtonClicked(){
        mmQuantity++;
        foodShop.getSnacks().get("M&M").setQuantity(mmQuantity);
        mmQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getSnacks().get("M&M").getQuantity())));
        calculateSnacksTotal("M&M");
    }

    public void hariboButtonClicked(){
        hariboQuantity++;
        foodShop.getSnacks().get("Haribo").setQuantity(hariboQuantity);
        hariboQuantityLBL.textProperty().bind(new SimpleStringProperty(Integer.toString(foodShop.getSnacks().get("Haribo").getQuantity())));
        calculateSnacksTotal("Haribo");
    }

    public void addFoodToReceipt(){
        Bookings.getCurrentReceipt().getFoodSelected().clear();

        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getPopcorn().get("Popcorn Large"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getPopcorn().get("Popcorn Medium"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getPopcorn().get("Popcorn Small"));

        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getDrinks().get("Fanta"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getDrinks().get("Coke"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getDrinks().get("Pepsi"));

        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getSnacks().get("KitKat"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getSnacks().get("M&M"));
        Bookings.getCurrentReceipt().getFoodSelected().add(foodShop.getSnacks().get("Haribo"));

        Bookings.getCurrentReceipt().setTotalPayment(total);
    }

    public void backButtonClicked() throws IOException {

        backButton.getScene().getWindow().hide();

        Stage theatreStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TheatrePage.fxml"));
        theatreStage.setTitle("Cinema Enterpriso - Theatre Page");
        theatreStage.setScene(new Scene(root, 1099, 650));
        theatreStage.setResizable(true);
        theatreStage.show();
    }

    public void paymentButtonClicked() throws IOException{

        addFoodToReceipt();

        System.out.println(Bookings.getCurrentReceipt());
        paymentButton.getScene().getWindow().hide();

        Stage paymentStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SelectPaymentPage.fxml"));
        paymentStage.setTitle("Cinema Enterpriso - Select Payment");
        paymentStage.setScene(new Scene(root, 666, 446));
        paymentStage.setResizable(true);
        paymentStage.show();
    }

}
