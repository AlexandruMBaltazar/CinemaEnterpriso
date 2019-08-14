package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.sun.org.apache.xml.internal.utils.StringBufferPool;
import erroralertbox.ErrorAlertBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
//if field not empty
    @FXML
    private TextField forenameTXT;

    @FXML
    private Label forenameLBL;

    @FXML
    private Label emailLBL;

    @FXML
    private Label surnameLBL;

    @FXML
    private TextField emailTXT;

    @FXML
    private Label usernameLBL;

    @FXML
    private TextField ageTXT;

    @FXML
    private JFXButton registerButton;

    @FXML
    private TextField usernameTXT;

    @FXML
    private Label ageLBL;

    @FXML
    private TextField surnameTXT;

    @FXML
    private JFXButton backButton;

    @FXML
    private PasswordField passwordTXT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Binding - The user will be able to preview his details in real time
        usernameLBL.textProperty().bind(usernameTXT.textProperty());
        surnameLBL.textProperty().bind(surnameTXT.textProperty());
        forenameLBL.textProperty().bind(forenameTXT.textProperty());
        emailLBL.textProperty().bind(emailTXT.textProperty());
        ageLBL.textProperty().bind(ageTXT.textProperty());

    }

    public void backButtonClicked() throws IOException {
        //Return to log in page
        backButton.getScene().getWindow().hide();

        Stage logInStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        logInStage.setTitle("Cinema Enterpriso - Log In");
        logInStage.setScene(new Scene(root, 719, 452));
        logInStage.setResizable(false);
        logInStage.show();


    }

    public void registerButtonClicked() throws IOException {
        /*
        Here we will do some error checking before storing our user
        Firstly, we check if the username is unique
        Secondly, we check if the user completed all of the registration fields
         */


        boolean usernameTaken = false;
        boolean ageIsInt = false;

        for (String key : UserDatabase.getUsers().keySet()) {
            if (usernameTXT.getText().equals(UserDatabase.getUsers().get(key).getUsername())) {

                ErrorAlertBox.displayErrorAlert("Sign Up Error","Username Already Taken");
                usernameTaken = true;
                break;
            }

        }


        if(isInt(ageTXT) && Integer.parseInt(ageTXT.getText()) > 0){
            ageIsInt = true;
        }else {
            ErrorAlertBox.displayErrorAlert("Sign Up Error","Invalid age format");
        }


        if (!usernameTaken && ageIsInt){

            if(usernameTXT.getText().isEmpty() || surnameTXT.getText().isEmpty() || forenameTXT.getText().isEmpty()
                    || emailTXT.getText().isEmpty() || ageTXT.getText().isEmpty() || passwordTXT.getText().isEmpty()) {

                ErrorAlertBox.displayErrorAlert("Sign Up Error","All of the fields are compulsory. Please complete them.");

            }else{
                UserDatabase.addUser(usernameTXT.getText(), new User(usernameTXT.getText(),surnameTXT.getText(),forenameTXT.getText(),emailTXT.getText(),Integer.parseInt(ageTXT.getText()), passwordTXT.getText()));

                Alert signUpAlert = new Alert(Alert.AlertType.CONFIRMATION);
                signUpAlert.setTitle("Registered");
                signUpAlert.setHeaderText("You have registered successfully");
                signUpAlert.setContentText("Do you want to log in now ?");
                Optional<ButtonType> result = signUpAlert.showAndWait();
                if(result.get() == ButtonType.OK){

                    registerButton.getScene().getWindow().hide();
                    Stage logInStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
                    logInStage.setTitle("Cinema Enterpriso - Log In");
                    logInStage.setScene(new Scene(root, 719, 452));
                    logInStage.setResizable(false);
                    logInStage.show();
                    System.out.println(UserDatabase.getUsers());
                }

                usernameTXT.clear();
                surnameTXT.clear();
                forenameTXT.clear();
                forenameTXT.clear();
                ageTXT.clear();
                emailTXT.clear();
                passwordTXT.clear();
            }

        }

    }

    public boolean isInt(TextField input){
        try{
            int age = Integer.parseInt(input.getText());
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }

}





