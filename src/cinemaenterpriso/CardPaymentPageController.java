package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import erroralertbox.ErrorAlertBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import receipt.Bookings;

import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardPaymentPageController implements Initializable {

    @FXML
    private TextField cardNumberTXT;

    @FXML
    private TextField securityCodeTXT;

    @FXML
    private ComboBox<String> expirationMonthCombo;

    @FXML
    private ComboBox<String> expirationYearCombo;

    @FXML
    private JFXButton bookButton;

    @FXML
    private JFXButton backButton;

    @FXML
    private Label totalLBL;

    private boolean isCorrectCardNumber = false;
    private boolean isCorrectSecurityCode = false;
    private boolean isCorrectExpirationMonth = false;
    private boolean isCorrectExpirationYear = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalLBL.setText(Double.toString(Bookings.getCurrentReceipt().getTotalPayment()));

        expirationMonthCombo.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July",  "August", "September", "October", "November", "December");

        expirationYearCombo.getItems().addAll("2020", "2021", "2022", "2023", "2024", "2025");
    }

    public void bookButtonClicked() throws IOException{
        if(cardNumberTXT.getText().matches("[0-9]+") && cardNumberTXT.getText().length() == 16){
            isCorrectCardNumber = true;

            if(securityCodeTXT.getText().matches("[0-9]+") && securityCodeTXT.getText().length() == 3 && isCorrectCardNumber){
                isCorrectSecurityCode = true;

                if(!expirationMonthCombo.getSelectionModel().isEmpty() && isCorrectCardNumber && isCorrectSecurityCode){
                    isCorrectExpirationMonth = true;

                    if(!expirationYearCombo.getSelectionModel().isEmpty() && isCorrectCardNumber && isCorrectSecurityCode && isCorrectExpirationMonth){
                        isCorrectExpirationMonth = true;

                        Bookings.getCurrentReceipt().setPayment("Payed by card");

                        bookButton.getScene().getWindow().hide();

                        Stage receiptStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("ReceiptPage.fxml"));
                        receiptStage.setTitle("Cinema Enterpriso - Receipt");
                        receiptStage.setScene(new Scene(root, 1039, 787));
                        receiptStage.setResizable(true);
                        receiptStage.show();

                    }else{
                        ErrorAlertBox.displayErrorAlert("Processing Payment Error","Please select the expiration year");
                    }

                }else{
                    ErrorAlertBox.displayErrorAlert("Processing Payment Error","Please select the expiration month");
                }

            }else{
                ErrorAlertBox.displayErrorAlert("Processing Payment Error","Your security code is wrong");
            }

        }else{
            ErrorAlertBox.displayErrorAlert("Processing Payment Error","Your card number is wrong");
        }

    }

    public void backButtonClicked() throws IOException {
        backButton.getScene().getWindow().hide();

        Stage paymentStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SelectPaymentPage.fxml"));
        paymentStage.setTitle("Cinema Enterpriso - Select Payment");
        paymentStage.setScene(new Scene(root, 666, 446));
        paymentStage.setResizable(true);
        paymentStage.show();

    }


}
