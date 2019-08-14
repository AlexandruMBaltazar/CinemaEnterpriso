package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Label usernameLBL;

    @FXML
    private Label surnameLBL;

    @FXML
    private Label forenameLBL;

    @FXML
    private Label emailLBL;

    @FXML
    private Label ageLBL;

    @FXML
    private JFXButton logOutButton;

    @FXML
    private JFXButton viewProfileButton;

    @FXML
    private JFXButton bookingsButton;

    @FXML
    private ImageView profileImage;

    @FXML
    private Text welcomeNameTXT;

    @FXML
    private JFXButton theatreButton;

    @FXML
    private ImageView cinemaAnimationImage;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Here we are going to initialize the user details (username, surname etc) plus the GIF

        System.out.println(UserDatabase.getCurrentUser());

        cinemaAnimationImage.setVisible(true);

        usernameLBL.setText(UserDatabase.getCurrentUser().getUsername());
        surnameLBL.setText(UserDatabase.getCurrentUser().getSurname());
        forenameLBL.setText(UserDatabase.getCurrentUser().getForename());
        emailLBL.setText(UserDatabase.getCurrentUser().getEmail());
        ageLBL.setText(Integer.toString(UserDatabase.getCurrentUser().getAge()));

        welcomeNameTXT.setText(UserDatabase.getCurrentUser().getSurname());

        if(UserDatabase.getCurrentUser().getProfilePic() != null){

            Image image = new Image(UserDatabase.getCurrentUser().getProfilePic());
            profileImage.setImage(image);
            profileImage.setFitHeight(150);
            profileImage.setFitWidth(122);

        }

    }

    public void logOutButtonClicked() throws IOException {

        logOutButton.getScene().getWindow().hide();

        Stage logInStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        logInStage.setTitle("Cinema Enterpriso - Log In");
        logInStage.setScene(new Scene(root, 719, 452));
        logInStage.setResizable(false);
        logInStage.show();

    }

    public void viewProfileButtonClicked() throws IOException{

        viewProfileButton.getScene().getWindow().hide();

        Stage profileStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
        profileStage.setTitle("Cinema Enterpriso - Profile");
        profileStage.setScene(new Scene(root, 990, 724));
        profileStage.setResizable(false);
        profileStage.show();

    }

    public void theatreButtonClicked() throws IOException {

        theatreButton.getScene().getWindow().hide();

        Stage theatreSelectStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TheatreSelectionPage.fxml"));
        theatreSelectStage.setTitle("Cinema Enterpriso - Theatre Select");
        theatreSelectStage.setScene(new Scene(root, 1270, 817));
        theatreSelectStage.setResizable(true);
        theatreSelectStage.show();

    }

    public void bookingsButtonClicked() throws IOException{
        bookingsButton.getScene().getWindow().hide();

        Stage currentBookingsStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CurrentBookingsPage.fxml"));
        currentBookingsStage.setTitle("Cinema Enterpriso - Theatre Select");
        currentBookingsStage.setScene(new Scene(root, 1249, 637));
        currentBookingsStage.setResizable(true);
        currentBookingsStage.show();

    }



}
