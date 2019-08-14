package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import erroralertbox.ErrorAlertBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    @FXML
    private JFXButton registerButton;

    @FXML
    private JFXTextField usernameTXT;

    @FXML
    private JFXButton logInButton;

    @FXML
    private JFXPasswordField passwordTXT;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println(UserDatabase.getUsers());
    }



    public void registerButtonClicked() throws IOException {

        registerButton.getScene().getWindow().hide();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        primaryStage.setTitle("Cinema Enterpriso - Registration");
        primaryStage.setScene(new Scene(root, 680, 593));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void logInButtonClicked() throws IOException{

        boolean found = false;

        if(UserDatabase.getUsers().isEmpty()){

            ErrorAlertBox.displayErrorAlert("Log In Error","Invalid Username Or Password");

        }else{
            for (String key : UserDatabase.getUsers().keySet()) {
                if((UserDatabase.getUsers().get(key).getUsername().equals(usernameTXT.getText())) && (UserDatabase.getUsers().get(key).getPassword().equals(passwordTXT.getText()))){

                    UserDatabase.setCurrentUser(UserDatabase.getUsers().get(key));
                    System.out.println("Current user is: ");
                    System.out.println(UserDatabase.getCurrentUser());

                    logInButton.getScene().getWindow().hide();

                    Stage mainStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                    mainStage.setTitle("Cinema Enterpriso - Main Page");
                    mainStage.setScene(new Scene(root, 1011, 792));
                    mainStage.setResizable(false);
                    mainStage.show();

                    found = true;
                    break;
                }
            }

            if(!found){

                ErrorAlertBox.displayErrorAlert("Log In Error","Invalid Username Or Password");

            }

        }

    }
}
