package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import receipt.Bookings;
import receipt.Receipt;
import theatre.Theatre;
import theatre.TheatreDatabase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TheatrePageController implements Initializable {

    @FXML
    private Text weekTXT;

    @FXML
    private Text hourTXT;

    @FXML
    private Text seatTXT;

    @FXML
    private Text totalTXT;

    @FXML
    private Text ticketPriceTXT;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton nextButton;

    @FXML
    private ComboBox<String> ticketComboBox;

    @FXML
    private Text rateTXT;

    @FXML
    private Text durationTXT;

    @FXML
    private Text ageTXT;

    @FXML
    private ComboBox<String> moviesComboBox;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;

    int movieChoice = 3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        moviesComboBox.getItems().add(TheatreDatabase.getSelectedTheatre().getMovies().get(0).getMovieName());
        moviesComboBox.getItems().add(TheatreDatabase.getSelectedTheatre().getMovies().get(1).getMovieName());


        weekTXT.setText(TheatreDatabase.getSelectedTheatre().getWeek());


        ticketComboBox.getItems().addAll("1","2","3","4");


    }

    public void moviesComboBoxClicked(){

        if (moviesComboBox.getValue() == TheatreDatabase.getSelectedTheatre().getMovies().get(0).getMovieName()){
            movieChoice = 0;
            displayDetails(hourTXT,ticketPriceTXT,rateTXT,durationTXT,ageTXT,0);
            seatTXT.setText(Integer.toString(TheatreDatabase.getSelectedTheatre().getMovies().get(0).getSeats()));
            playTrailer(TheatreDatabase.getSelectedTheatre(),movieChoice);
        }else{
            movieChoice = 1;
            displayDetails(hourTXT,ticketPriceTXT,rateTXT,durationTXT,ageTXT,1);
            seatTXT.setText(Integer.toString(TheatreDatabase.getSelectedTheatre().getMovies().get(1).getSeats()));
            playTrailer(TheatreDatabase.getSelectedTheatre(),movieChoice);
        }
    }

    public void ticketComboBoxClicked(){
        if (moviesComboBox.getValue() == TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getMovieName()){
            double total = TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getPrice() * Integer.parseInt(ticketComboBox.getValue());
            totalTXT.setText(Double.toString(total));
        }else{
            double total = TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getPrice() * Integer.parseInt(ticketComboBox.getValue());
            totalTXT.setText(Double.toString(total));
        }
    }


    public void playTrailer(Theatre selectedTheatre, int i){
        String path = new File("src/media/"+ selectedTheatre.getMovies().get(i).getMovieName() +".mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        //mediaPlayer.setAutoPlay(true);
    }



    public void backButtonClicked() throws IOException {


        backButton.getScene().getWindow().hide();

        Stage theatreSelectStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TheatreSelectionPage.fxml"));
        theatreSelectStage.setTitle("Cinema Enterpriso - Theatre Select");
        theatreSelectStage.setScene(new Scene(root, 1270, 817));
        theatreSelectStage.setResizable(true);
        theatreSelectStage.show();

    }

    public void nextButtonClicked() throws IOException {

        if(moviesComboBox.getValue() == null || ticketComboBox.getValue() == null){

            Alert movieSelection = new Alert(Alert.AlertType.ERROR);
            movieSelection.setTitle("Movie Selection Error");
            movieSelection.setHeaderText("Please Select Movie/Tickets First");
            movieSelection.showAndWait();

        } else if( UserDatabase.getCurrentUser().getAge() < Integer.parseInt(ageTXT.getText())) {

            Alert signUpAlert = new Alert(Alert.AlertType.ERROR);
            signUpAlert.setTitle("Age Error");
            signUpAlert.setHeaderText("Sorry but you are too young to watch this movie");
            signUpAlert.showAndWait();

        }else{
            TheatreDatabase.updateTheatreSeats(ticketComboBox.getValue(), movieChoice);

            Bookings.setCurrentReceipt(new Receipt(TheatreDatabase.getSelectedTheatre().getName(), TheatreDatabase.getSelectedTheatre().getLocation(),
                    TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getMovieName(),ticketComboBox.getValue(),Double.parseDouble(totalTXT.getText()) ,
                    weekTXT.getText(), hourTXT.getText(), Integer.parseInt(ageTXT.getText())));

            nextButton.getScene().getWindow().hide();
            Stage foodShopStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FoodShopPage.fxml"));
            foodShopStage.setTitle("Cinema Enterpriso - Foods");
            foodShopStage.setScene(new Scene(root, 1397, 871));
            foodShopStage.setResizable(true);
            foodShopStage.show();
        }

    }

    public void play(){
        mediaPlayer.play();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public void fast(){
        mediaPlayer.setRate(2);
    }

    public void slow(){
        mediaPlayer.setRate(.5);
    }
    public void reload(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }

    public void start(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.stop();
    }
    public void last(){
        mediaPlayer.seek(mediaPlayer.getTotalDuration());
        mediaPlayer.stop();
    }

    public void displayDetails(Text hour, Text ticketPrice, Text rate, Text duration,Text age, int movieChoice){
        hour.setText(TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getShowTimes());
        ticketPrice.setText(Double.toString(TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getPrice()));
        rate.setText(TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getRating());
        duration.setText(TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getLength());
        age.setText(Integer.toString(TheatreDatabase.getSelectedTheatre().getMovies().get(movieChoice).getAge()));
    }

}
