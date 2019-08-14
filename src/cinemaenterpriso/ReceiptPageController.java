package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import receipt.Bookings;

import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceiptPageController implements Initializable {

    @FXML
    private Label theatreNameLBL;

    @FXML
    private Label theatreLocationLBL;

    @FXML
    private Label movieNameLBL;

    @FXML
    private Label weekLBL;

    @FXML
    private Label showTimeLBL;

    @FXML
    private Label ageLBL;

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
    private Label paymetMethodLBL;

    @FXML
    private JFXButton saveButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeTheatreDetails();
        initializeFoodDetails();
        ticketsQuantityLBL.setText(Bookings.getCurrentReceipt().getTickets());
        totalLBL.setText(Double.toString(Bookings.getCurrentReceipt().getTotalPayment()));
        paymetMethodLBL.setText(Bookings.getCurrentReceipt().getPayment());

    }

    public void initializeTheatreDetails(){
        theatreNameLBL.setText(Bookings.getCurrentReceipt().getTheatreName());
        theatreLocationLBL.setText(Bookings.getCurrentReceipt().getTheatreLocation());
        movieNameLBL.setText(Bookings.getCurrentReceipt().getMovieName());
        weekLBL.setText(Bookings.getCurrentReceipt().getWeek());
        showTimeLBL.setText(Bookings.getCurrentReceipt().getShowTime());
        ageLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getAge()));
    }


    public void initializeFoodDetails(){
        largePopcornQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(0).getQuantity()));
        mediumPopcornQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(1).getQuantity()));
        smallPopcornQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(2).getQuantity()));

        fantaQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(3).getQuantity()));
        cokeQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(4).getQuantity()));
        pepsiQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(5).getQuantity()));

        kitkatQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(6).getQuantity()));
        mmQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(7).getQuantity()));
        hariboQuantityLBL.setText(Integer.toString(Bookings.getCurrentReceipt().getFoodSelected().get(8).getQuantity()));
    }

    public void saveButtonClicked() throws IOException {
        Bookings.addBookings(Bookings.getCurrentReceipt());
        UserDatabase.getCurrentUser().setBookings(Bookings.getBookings());
        UserDatabase.addUser(UserDatabase.getCurrentUser().getUsername(), UserDatabase.getCurrentUser());

        saveButton.getScene().getWindow().hide();

        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        mainStage.setTitle("Cinema Enterpriso - Main Page");
        mainStage.setScene(new Scene(root, 1011, 792));
        mainStage.setResizable(false);
        mainStage.show();
    }


}
