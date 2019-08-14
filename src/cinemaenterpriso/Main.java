package cinemaenterpriso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import theatre.TheatreDatabase;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        TheatreDatabase.setTheatresForEachWeek();
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        primaryStage.setTitle("Cinema Enterpriso - Log In");
        primaryStage.setScene(new Scene(root, 719, 452));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
