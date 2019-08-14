package cinemaenterpriso;

import com.jfoenix.controls.JFXButton;
import erroralertbox.ErrorAlertBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import movies.Movie;
import movies.MovieDatabase;
import theatre.Theatre;
import theatre.TheatreDatabase;
import javax.naming.spi.InitialContextFactory;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TheatreSelectionPageController implements Initializable{

    @FXML
    private ComboBox<String> dayComboBox;

    @FXML
    private TableView<Theatre> theatreTable;

    @FXML
    private TableColumn<Theatre, String> nameColumn;

    @FXML
    private TableColumn<Theatre, String> locationColumn;

    @FXML
    private TableColumn<Theatre, Integer> noSeatsColumn;

    @FXML
    private TableColumn<Theatre, String> movieNameColumn;

    @FXML
    private TableColumn<Theatre, Double> priceColumn;

    @FXML
    private TableColumn<Theatre, String> ageColumn;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXButton nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        noSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("moviesSeats"));
        movieNameColumn.setCellValueFactory(new PropertyValueFactory<>("moviesName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("moviesPrice"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("moviesAge"));

        dayComboBox.getItems().addAll("Week 1","Week 2","Week 3", "Week 4", "Week 5", "Week 6", "Week 7");

    }


    public void dayComboBoxClicked(){
        ObservableList<Theatre> theatres = null;

        switch (dayComboBox.getValue()){

            case "Week 1":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek1());
                theatreTable.setItems(theatres);
                break;

            case "Week 2":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek2());
                theatreTable.setItems(theatres);
                break;

            case "Week 3":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek3());
                theatreTable.setItems(theatres);
                break;

            case "Week 4":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek4());
                theatreTable.setItems(theatres);
                break;

            case "Week 5":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek5());
                theatreTable.setItems(theatres);
                break;

            case "Week 6":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek6());
                theatreTable.setItems(theatres);
                break;

            case "Week 7":
                theatres = FXCollections.observableArrayList(TheatreDatabase.getWeek7());
                theatreTable.setItems(theatres);
                break;
        }

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

    public void nextButtonClicked() throws IOException {

        if(theatreTable.getSelectionModel().isEmpty() || dayComboBox.getValue().isEmpty()){
            ErrorAlertBox.displayErrorAlert("No Theatre Selected", "Please Select A Theatre");
        }else{
            switch (dayComboBox.getValue()){

                case "Week 1":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 1");

                    for(Theatre theatre : TheatreDatabase.getWeek1()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 2":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 2");

                    for(Theatre theatre : TheatreDatabase.getWeek2()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 3":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 3");

                    for(Theatre theatre : TheatreDatabase.getWeek3()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 4":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 4");

                    for(Theatre theatre : TheatreDatabase.getWeek4()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 5":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 5");

                    for(Theatre theatre : TheatreDatabase.getWeek5()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 6":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 6");

                    for(Theatre theatre : TheatreDatabase.getWeek6()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;

                case "Week 7":
                    theatreTable.getSelectionModel().getSelectedItem().setWeek("Week 7");

                    for(Theatre theatre : TheatreDatabase.getWeek7()){
                        if(theatreTable.getSelectionModel().getSelectedItem().equals(theatre)){
                            TheatreDatabase.setSelectedTheatre(theatreTable.getSelectionModel().getSelectedItem(), theatre);
                        }
                    }

                    break;
            }

            nextButton.getScene().getWindow().hide();

            Stage theatreStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TheatrePage.fxml"));
            theatreStage.setTitle("Cinema Enterpriso - Theatre Select");
            theatreStage.setScene(new Scene(root, 1099, 650));
            theatreStage.setResizable(true);
            theatreStage.show();

        }

    }

}
