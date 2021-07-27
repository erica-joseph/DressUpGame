package ucf.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainConsoleController implements Initializable {
    public ImageView Intro;
    public Button playWater;
    public Button modelOutfits;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    
    public void waterGun(ActionEvent event) throws IOException {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpBattle.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("To-do List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
        stage.show(); // display the stage
    }
    public void Outfits(ActionEvent event) throws IOException {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpMain.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("To-do List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
        stage.show(); // display the stage
    }
}
