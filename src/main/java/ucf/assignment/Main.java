package ucf.assignment;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Erica Joseph
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpConsole.fxml"))); //access the file needed to load FXML; this will be the source of the code
            Scene scene = new Scene(root); // attach scene graph to scene
            stage.setTitle("Get Styled"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stage
            stage.getIcons().add(new Image("ucf/assignment/Backgrounds/GirlsLifeLogo2.png"));
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage

                AudioInputStream audio = null;
                String clipPath = "src/main/resources/ucf/assignment/Music/ROOKIE.wav";
                audio = AudioSystem.getAudioInputStream(new File(clipPath));
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                FloatControl gainControl =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-30.0f); // Reduce volume by 10 decibels.
                clip.start();


        }
        catch (Exception ignored){

        }
    }


    public static void main(String[] args) {
        launch(args);
    } //man call to launch
}

//--module-path C:\Users\erica\Documents\OOP\openjfx-16_windows-x64_bin-sdk\javafx-sdk-16\lib --add-modules=javafx.swing,javafx.graphics,javafx.fxml,javafx.media,javafx.web --add-reads javafx.graphics=ALL-UNNAMED --add-opens javafx.controls/com.sun.javafx.charts=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.iio.common=ALL-UNNAMED --add-opens javafx.graphics/com.sun.javafx.css=ALL-UNNAMED --add-opens javafx.base/com.sun.javafx.runtime=ALL-UNNAMED
