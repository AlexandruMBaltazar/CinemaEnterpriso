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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectPaymentPageController implements Initializable {

    @FXML
    private JFXButton payByCardButton;

    @FXML
    private JFXButton cashButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void payByCardButtonClicked() throws IOException {
        payByCardButton.getScene().getWindow().hide();

        Stage theatreSelectStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CardPaymentPage.fxml"));
        theatreSelectStage.setTitle("Cinema Enterpriso - Theatre Select");
        theatreSelectStage.setScene(new Scene(root, 804, 538));
        theatreSelectStage.setResizable(true);
        theatreSelectStage.show();
    }

    public void cashButtonClicked() throws IOException{
        Bookings.getCurrentReceipt().setPayment("To be payed in cash");

        cashButton.getScene().getWindow().hide();

        Stage receiptStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ReceiptPage.fxml"));
        receiptStage.setTitle("Cinema Enterpriso - Receipt");
        receiptStage.setScene(new Scene(root, 1039, 787));
        receiptStage.setResizable(true);
        receiptStage.show();

    }

}
