package ucf.assignment;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.beans.property.IntegerProperty;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BattleController implements Initializable {
    public ImageView Her;
    public Button attackButton;
    public ImageView You;
    public Text attackProgress;
    public ProgressBar yourHealth;
    public ProgressBar herHealth;
    public Button Attack2;
    public Text attackProgress1;
    public Text lifeStatus;
    public Text lifeStatus1;
    public Button Quit;
    public Button youDefend;
    public Button sheDefend;
    public Button WaterGun;
    public Button Balloon;
    public Button Bucket;
    public Button Player2WaterGun;
    public Button Player2Balloon;
    public Button Player2Bucket;
    public Button Player1WaterGun;
    public Button Player1Balloon;
    public Button Player1Bucket;
    public Button Player1attack;
    public Button Player2attack;
    int HealthHer = 100;
    int HealthYou = 100;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Her.setImage(new Image("/ucf/assignment/Battles/Shirly.png"));
        You.setImage(new Image("/ucf/assignment/Battles/MainHello.png"));

        //player1
        Player1WaterGun.setVisible(false);
        Player1Balloon.setVisible(false);
        Player1Bucket.setVisible(false);
        sheDefend.setVisible(false);

        //player2
        Player2WaterGun.setVisible(false);
        Player2Balloon.setVisible(false);
        Player2Bucket.setVisible(false);
        youDefend.setVisible(false);

        Player1attack.setVisible(false);
        Player2attack.setVisible(false);

        Player1attack.fire();

    }

    public void attackPlayer1(ActionEvent event) throws IOException {
        Player1WaterGun.setVisible(true);
        Player1Balloon.setVisible(true);
        Player1Bucket.setVisible(true);
        youDefend.setVisible(true);

        Player2WaterGun.setVisible(false);
        Player2Balloon.setVisible(false);
        Player2Bucket.setVisible(false);
        sheDefend.setVisible(false);

        int RandomIndex = (int) (Math.random() * (100-1)+1);;

        if(RandomIndex >=0 && RandomIndex <=24){
            //gun (25%)
            int RandomDisplay8 = (int)(Math.random()*2);

            if(RandomDisplay8==0) {
                youDefend.setDisable(false);
                Player1Bucket.setDisable(true);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay8==1) {
                youDefend.setDisable(true);
                Player1Bucket.setDisable(false);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay8 == 2) {
                youDefend.setDisable(true);
                Player1Bucket.setDisable(true);
                Player1Balloon.setDisable(false);
            }
        }
        else if(RandomIndex>24 && RandomIndex <=30){
            // bucket (12%)
            // disable (gun || balloon)
            int RandomDisplay7 = (int)(Math.random()*2);

            if(RandomDisplay7==0) {
                youDefend.setDisable(false);
                Player1WaterGun.setDisable(true);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay7==1) {
                youDefend.setDisable(true);
                Player1WaterGun.setDisable(false);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay7 == 2) {
                youDefend.setDisable(true);
                Player1WaterGun.setDisable(true);
                Player1Balloon.setDisable(false);
            }

        }
        else if(RandomIndex>31 && RandomIndex <=49){
            // health (13%)
            // disable (gun || balloon)
            int RandomDisplay5 = (int)(Math.random()*2);

            if(RandomDisplay5==0) {
                Player1Bucket.setDisable(false);
                Player1WaterGun.setDisable(true);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay5==1) {
                Player1Bucket.setDisable(true);
                Player1WaterGun.setDisable(false);
                Player1Balloon.setDisable(true);
            }
            else if(RandomDisplay5 == 2) {
                Player1Bucket.setDisable(true);
                Player1WaterGun.setDisable(true);
                Player1Balloon.setDisable(false);
            }
            System.out.println("Health was chosen");

        }
        else if(RandomIndex>50 && RandomIndex <=99){
            //balloon (25%)
            // disable (cup || gun)

            int RandomDisplay6 = (int)(Math.random()*2);

            if(RandomDisplay6==0) {
                Player1Bucket.setDisable(false);
                Player1WaterGun.setDisable(true);
                youDefend.setDisable(true);
            }
            else if(RandomDisplay6==1) {
                Player1Bucket.setDisable(true);
                Player1WaterGun.setDisable(false);
                youDefend.setDisable(true);
            }
            else if(RandomDisplay6 == 2) {
                Player1Bucket.setDisable(true);
                Player1WaterGun.setDisable(true);
                youDefend.setDisable(false);
            }
            System.out.println("Balloon was chosen");
        }

    }

    public void attackPlayer2(ActionEvent event) throws IOException {

        Player1WaterGun.setVisible(false);
        Player1Balloon.setVisible(false);
        Player1Bucket.setVisible(false);
        youDefend.setVisible(false);

        Player2WaterGun.setVisible(true);
        Player2Balloon.setVisible(true);
        Player2Bucket.setVisible(true);
        sheDefend.setVisible(true);

        int RandomIndex = (int) (Math.random() * (100));;
        // bucket > watergun > water balloon

        if(RandomIndex >=0 && RandomIndex <=24){
            //gun (25%)

            //disable (cup || ballon)
            int RandomDisplay4 = (int)(Math.random()*2);

            if(RandomDisplay4==0) {
                Player2Bucket.setDisable(false);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay4==1) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(false);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay4 == 2) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(false);
            }
            System.out.println("Watergun was chosen");
        }
        else if(RandomIndex>24 && RandomIndex <=30){
            // bucket (12%)
            // disable (gun || balloon)
            int RandomDisplay3 = (int)(Math.random()*2);

            if(RandomDisplay3==0) {
                sheDefend.setDisable(false);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay3==1) {
                sheDefend.setDisable(true);
                Player2WaterGun.setDisable(false);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay3 == 2) {
                sheDefend.setDisable(true);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(false);
            }
            System.out.println("Bucket was chosen");

        }
        else if(RandomIndex>31 && RandomIndex <=49){
            // health (50%)
            // disable (gun || balloon)

            int RandomDisplay2 = (int)(Math.random()*2);

            if(RandomDisplay2==0) {
                Player2Bucket.setDisable(false);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay2==1) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(false);
                Player2Balloon.setDisable(true);
            }
            else if(RandomDisplay2 == 2) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(true);
                Player2Balloon.setDisable(false);
            }
            System.out.println("Health was chosen");

        }
        else if(RandomIndex>50 && RandomIndex <=99){
            //balloon (25%)
            // disable (cup || gun)
            Player2Balloon.setDisable(false);

            int RandomDisplay1 = (int)(Math.random()*2);

            if(RandomDisplay1==0) {
                Player2Bucket.setDisable(false);
                Player2WaterGun.setDisable(true);
                sheDefend.setDisable(true);
            }
            else if(RandomDisplay1==1) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(false);
                sheDefend.setDisable(true);
            }
            else if(RandomDisplay1 == 2) {
                Player2Bucket.setDisable(true);
                Player2WaterGun.setDisable(true);
                sheDefend.setDisable(false);
            }
            System.out.println("Balloon was chosen");
        }

    }



//Player 1

    //Player 1 Watergun Attack
    //Bucket (15-25) || 10-15 || 0-10
    public void player1WaterGun (ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int RNG1 = (int) ((Math.random() * (10 - 5)) + 5);
        HealthHer = HealthHer - RNG1;
        //attackProgress1.setText(String.valueOf(HealthHer));
        Her.setImage(new Image("/ucf/assignment/Battles/ShirlyHit.png"));
        You.setImage(new Image("/ucf/assignment/Battles/MainShoot.png"));

        System.out.println("Her health is" + HealthHer);
        if(HealthHer>=75){
            lifeStatus1.setText("TTTT");
        }
        else if(HealthHer>=50 && HealthHer<74){
            lifeStatus1.setText("TTT");
        }
        else if(HealthHer>=25 && HealthHer<49){
            lifeStatus1.setText("TT");
        }
        else if(HealthHer>=0 && HealthHer<24){
            lifeStatus1.setText("T");
        }
        if(HealthHer<=0){
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/Win.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }

        Player2attack.fire();
        Player1WaterGun.setDisable(false);
        Player1Balloon.setDisable(false);
        Player1Bucket.setDisable(false);
        youDefend.setDisable(false);
        watergun();
        Thread.sleep(1500);

    }

    //Player 1 Balloon Attack
    public void player1Balloon(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int RNG2 = (int) (Math.random() * 5);
        HealthHer = HealthHer - RNG2;
        //attackProgress1.setText(String.valueOf(HealthHer));
        Her.setImage(new Image("/ucf/assignment/Battles/ShirlyHitWaterBalloon.png"));
        You.setImage(new Image("/ucf/assignment/Battles/YouAttackBalloon1.png"));
        System.out.println(HealthHer);
        if (HealthHer >= 75) {
            lifeStatus1.setText("TTTT");
        } else if (HealthHer >= 50 && HealthHer < 74) {
            lifeStatus1.setText("TTT");
        } else if (HealthHer >= 25 && HealthHer < 49) {
            lifeStatus1.setText("TT");
        } else if (HealthHer >= 0 && HealthHer < 24) {
            lifeStatus1.setText("T");
        }
        if (HealthHer <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/Win.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player2attack.fire();
        Player1WaterGun.setDisable(false);
        Player1Balloon.setDisable(false);
        Player1Bucket.setDisable(false);
        youDefend.setDisable(false);
        waterballoon();
        Thread.sleep(1500);
    }
    //Player 1 Bucket Attack
    public void player1Bucket(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        //balloon (25%)
        // disable (cup || gun)
        int RNG3 = (int) (Math.random() * (15- 10)) + 10;
        HealthHer = HealthHer - RNG3;
        //attackProgress1.setText(String.valueOf(HealthHer));

        System.out.println(HealthHer);
        Her.setImage(new Image("/ucf/assignment/Battles/SheHitBucket.png"));
        You.setImage(new Image("/ucf/assignment/Battles/YouAttackBucket.png"));

        if (HealthHer >= 75) {
            lifeStatus1.setText("TTTT");
        } else if (HealthHer >= 50 && HealthHer < 74) {
            lifeStatus1.setText("TTT");
        } else if (HealthHer >= 25 && HealthHer < 49) {
            lifeStatus1.setText("TT");
        } else if (HealthHer >= 0 && HealthHer < 24) {
            lifeStatus1.setText("T");
        }
        if (HealthHer <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/Win.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player2attack.fire();
        Player1WaterGun.setDisable(false);
        Player1Balloon.setDisable(false);
        Player1Bucket.setDisable(false);
        youDefend.setDisable(false);
        bucket();
        Thread.sleep(1500);
    }


    //Player 1 Health regen
    public void yourDefense(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int randomHealth1 = (int)(Math.random()*5);

        HealthYou += randomHealth1;

        //attackProgress.setText(String.valueOf(HealthYou));

        System.out.println(HealthHer + "Your health");
        Her.setImage(new Image("/ucf/assignment/Battles/Shirly.png"));
        You.setImage(new Image("/ucf/assignment/Battles/MainHello.png"));

        if(HealthYou >100){
            HealthYou = 100;
        }

        if (HealthYou >= 75) {
            lifeStatus.setText("TTTT");
        } else if (HealthYou >= 50 && HealthYou < 74) {
            lifeStatus.setText("TTT");
        } else if (HealthYou >= 25 && HealthYou < 49) {
            lifeStatus.setText("TT");
        } else if (HealthYou >= 0 && HealthYou < 24) {
            lifeStatus.setText("T");
        }
        if (HealthYou<= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/GameOver.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player2attack.fire();
        Player1WaterGun.setDisable(false);
        Player1Balloon.setDisable(false);
        Player1Bucket.setDisable(false);
        youDefend.setDisable(false);
        health();
        Thread.sleep(1500);
    }

    //Player 2

    //Player 2 Health Regen
    public void herDefense(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int randomHealth2 = (int)(Math.random()*5);
        HealthHer += randomHealth2;
        //attackProgress1.setText(String.valueOf(HealthHer));
        System.out.println(HealthYou + "Her health");
        Her.setImage(new Image("/ucf/assignment/Battles/Shirly.png"));
        You.setImage(new Image("/ucf/assignment/Battles/MainHello.png"));

        if(HealthHer >100){
            HealthHer = 100;
        }
        if (HealthHer >= 75) {
            lifeStatus1.setText("TTTT");
        } else if (HealthHer  >= 50 && HealthHer  < 74) {
            lifeStatus1.setText("TTT");
        } else if (HealthHer  >= 25 && HealthHer  < 49) {
            lifeStatus1.setText("TT");
        } else if (HealthHer  >= 0 && HealthHer < 24) {
            lifeStatus1.setText("T");
        }
        if (HealthYou <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/GameOver.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player1attack.fire();
        Player2WaterGun.setDisable(false);
        Player2Balloon.setDisable(false);
        Player2Bucket.setDisable(false);
        sheDefend.setDisable(false);
        health();
        Thread.sleep(1500);

    }

    //Player 2 Watergun Attack
    //Bucket (15-25) || 10-15 || 0-10
    public void player2WaterGun(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int RNG4 = (int) (Math.random() * (10 - 5)) + 5;
        HealthYou = HealthYou - RNG4;
        //attackProgress.setText(String.valueOf(HealthYou));
        Her.setImage(new Image("/ucf/assignment/Battles/ShirlyShoot.png"));
        You.setImage(new Image("/ucf/assignment/Battles/MainActuallyHit.png"));

        if (HealthYou >= 75) {
            lifeStatus.setText("TTTT");
        } else if (HealthYou >= 50 && HealthYou < 74) {
            lifeStatus.setText("TTT");
        } else if (HealthYou >= 25 && HealthYou < 49) {
            lifeStatus.setText("TT");
        } else if (HealthYou >= 0 && HealthYou < 24) {
            lifeStatus.setText("T");
        }
        if (HealthYou <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/GameOver.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player1attack.fire();
        Player2WaterGun.setDisable(false);
        Player2Balloon.setDisable(false);
        Player2Bucket.setDisable(false);
        sheDefend.setDisable(false);
        watergun();
        Thread.sleep(1500);

    }

    //Player 2 Balloon Attack
    public void player2Balloon(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        int RNG5 = (int) (Math.random() * 5);
        HealthYou = HealthYou - RNG5;
        //attackProgress.setText(String.valueOf(HealthYou));
        Her.setImage(new Image("/ucf/assignment/Battles/SheAttacksBalloon.png"));
        You.setImage(new Image("/ucf/assignment/Battles/YouHitBalloon.png"));

        if (HealthYou >= 75) {
            lifeStatus.setText("TTTT");
        } else if (HealthYou >= 50 && HealthYou < 74) {
            lifeStatus.setText("TTT");
        } else if (HealthYou >= 25 && HealthYou < 49) {
            lifeStatus.setText("TT");
        } else if (HealthYou >= 0 && HealthYou < 24) {
            lifeStatus.setText("T");
        }
        if (HealthYou <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/GameOver.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player1attack.fire();
        Player2WaterGun.setDisable(false);
        Player2Balloon.setDisable(false);
        Player2Bucket.setDisable(false);
        sheDefend.setDisable(false);
        waterballoon();
        Thread.sleep(1500);

    }

    //Player 2 Bucket Attack
    public void player2Bucket(ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        //balloon (25%)
        // disable (cup || gun)
        int RNG6 = (int) (Math.random() * (15 - 10)) + 10;
        HealthYou = HealthYou - RNG6;
        //attackProgress.setText(String.valueOf(HealthYou));
        Her.setImage(new Image("/ucf/assignment/Battles/SheAttacksBucket.png"));
        You.setImage(new Image("/ucf/assignment/Battles/YouHitBucket.png"));

        if (HealthYou >= 75) {
            lifeStatus.setText("TTTT");
        } else if (HealthYou >= 50 && HealthYou < 74) {
            lifeStatus.setText("TTT");
        } else if (HealthYou >= 25 && HealthYou < 49) {
            lifeStatus.setText("TT");
        } else if (HealthYou >= 0 && HealthYou < 24) {
            lifeStatus.setText("T");
        }
        if (HealthYou <= 0) {
            Stage stage;//set stage
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/GameOver.fxml")));//load the main view of fxml
            Scene scene = new Scene(root); // attach scene graph to scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("To-do List"); // displayed in window's title bar
            stage.setScene(scene); // attach scene to stag
            scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
            stage.show(); // display the stage
        }
        Player1attack.fire();
        Player2WaterGun.setDisable(false);
        Player2Balloon.setDisable(false);
        Player2Bucket.setDisable(false);
        sheDefend.setDisable(false);
        bucket();
        Thread.sleep(1500);

    }
    //Quit game
    public void quitGame(ActionEvent event) throws IOException {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpConsole.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("To-do List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
        stage.show(); // display the stage
    }


    public void bucket () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream dress = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/WaterSplash.wav";
        dress = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(dress);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }

    public void health () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream dress = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/Health.wav";
        dress = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(dress);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }


    public void watergun () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream dress = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/WaterGun.wav";
        dress = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(dress);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }
    public void waterballoon () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream dress = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/WaterBalloon.wav";
        dress = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(dress);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }
}


//attackBalloon
    //attack-minus-ran
    //fire reset button
//attackBucket
    //attack-minus-ran
    //fire reset button
//attackWaterGun
    //attack-minus-ran
    //fire reset button


//reset button1
    //resets to enable 2 random buttons

//reset button 2
    //resets to enable 2 random buttons





