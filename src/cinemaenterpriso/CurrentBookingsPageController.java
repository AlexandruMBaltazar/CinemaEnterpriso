package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import receipt.Receipt;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ResourceBundle;

public class CurrentBookingsPageController implements Initializable {

    @FXML
    private TableView<Receipt> bookingsTable;

    @FXML
    private TableColumn<Receipt, String> theatreNameColumn;

    @FXML
    private TableColumn<Receipt, String> theatreLocationColumn;

    @FXML
    private TableColumn<Receipt, String> movieColumn;

    @FXML
    private TableColumn<Receipt, String> weekColumn;

    @FXML
    private TableColumn<Receipt, String> showTimeColumn;

    @FXML
    private TableColumn<Receipt, String> ticketsColumn;

    @FXML
    private TableColumn<Receipt, Double> priceColumn;

    @FXML
    private TableColumn<Receipt, String> paymentTypeColumn;

    @FXML
    private JFXButton backButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        theatreNameColumn.setCellValueFactory(new PropertyValueFactory<>("theatreName"));
        theatreLocationColumn.setCellValueFactory(new PropertyValueFactory<>("theatreLocation"));
        movieColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        weekColumn.setCellValueFactory(new PropertyValueFactory<>("week"));
        showTimeColumn.setCellValueFactory(new PropertyValueFactory<>("showTime"));
        ticketsColumn.setCellValueFactory(new PropertyValueFactory<>("tickets"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPayment"));
        paymentTypeColumn.setCellValueFactory(new PropertyValueFactory<>("payment"));

        System.out.println(UserDatabase.getCurrentUser().getBookings());


        if(UserDatabase.getCurrentUser().getBookings() != null){
            bookingsTable.setItems(getReceipts());
        }

    }

    public ObservableList<Receipt> getReceipts(){

        ObservableList<Receipt> receipts = FXCollections.observableArrayList(UserDatabase.getCurrentUser().getBookings());

        return receipts;
    }

    public void backButtonClicked() throws IOException {
        backButton.getScene().getWindow().hide();

        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        mainStage.setTitle("Cinema Enterpriso - Main Page");
        mainStage.setScene(new Scene(root, 1011, 792));
        mainStage.setResizable(false);
        mainStage.show();
    }


}
