package erroralertbox;

import javafx.scene.control.Alert;

public class ErrorAlertBox {

    public static void displayErrorAlert(String title, String header){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

}
