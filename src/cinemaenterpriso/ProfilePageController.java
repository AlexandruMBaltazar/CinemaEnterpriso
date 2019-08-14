package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import erroralertbox.ErrorAlertBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePageController implements Initializable {

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton changePicButton;

    @FXML
    private TextField surnameTXT;

    @FXML
    private TextField forenameTXT;

    @FXML
    private TextField emailTXT;

    @FXML
    private TextField ageTXT;

    @FXML
    private JFXButton saveButton;

    @FXML
    private Label newSurnameLBL;

    @FXML
    private Label newForenameLBL;

    @FXML
    private Label newEmailLBL;

    @FXML
    private Label newAgeLBL;

    @FXML
    private Label oldSurnameLBL;

    @FXML
    private Label oldForenameLBL;

    @FXML
    private Label oldEmailLBL;

    @FXML
    private Label oldAgeLBL;

    @FXML
    private ImageView profilePicImage;

    private String imageUrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Here we are going to use binding as well to display the new details
        //Also we are going to display user's old details

        oldSurnameLBL.setText(UserDatabase.getCurrentUser().getSurname());
        oldForenameLBL.setText(UserDatabase.getCurrentUser().getForename());
        oldEmailLBL.setText(UserDatabase.getCurrentUser().getEmail());
        oldAgeLBL.setText(Integer.toString(UserDatabase.getCurrentUser().getAge()));

        newSurnameLBL.textProperty().bind(surnameTXT.textProperty());
        newForenameLBL.textProperty().bind(forenameTXT.textProperty());
        newEmailLBL.textProperty().bind(emailTXT.textProperty());
        newAgeLBL.textProperty().bind(ageTXT.textProperty());


    }

    public void changePicButtonClicked() throws FileNotFoundException, IOException {

        //Here we are going to allow the user to change his/her profile pic

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Your Photo");
        File file = fileChooser.showOpenDialog(null);

        if(file != null){

                imageUrl = file.toURI().toURL().toExternalForm();
                Image image = new Image(imageUrl);
                profilePicImage.setImage(image);
                profilePicImage.setFitHeight(150);
                profilePicImage.setFitWidth(122);
        }

    }


    public void saveButtonClicked(){
        //User will be able to save his new details
        //We will also do some error checking and we will allow the user to change details now

        boolean ageIsInt = false;

        if(isInt(ageTXT)){
            ageIsInt = true;
        }else {
            ErrorAlertBox.displayErrorAlert("Save Error","You age is not a number!");
        }


        if(ageIsInt){

            if(surnameTXT.getText().isEmpty() || forenameTXT.getText().isEmpty() || emailTXT.getText().isEmpty() || ageTXT.getText().isEmpty()){
                ErrorAlertBox.displayErrorAlert("Save Error","You have empty fields!");
            }else{

                UserDatabase.getCurrentUser().setSurname(surnameTXT.getText());
                UserDatabase.getCurrentUser().setForename(forenameTXT.getText());
                UserDatabase.getCurrentUser().setEmail(emailTXT.getText());
                UserDatabase.getCurrentUser().setAge(Integer.parseInt(ageTXT.getText()));
                UserDatabase.getCurrentUser().setProfilePic(imageUrl);

                surnameTXT.clear();
                forenameTXT.clear();
                emailTXT.clear();
                ageTXT.clear();
            }

        }

    }


    public void backButtonClicked() throws IOException {

        backButton.getScene().getWindow().hide();

        Stage mainPageStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        mainPageStage.setTitle("Cinema Enterpriso - Main Page");
        mainPageStage.setScene(new Scene(root, 1011, 792));
        mainPageStage.setResizable(false);
        mainPageStage.show();

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
