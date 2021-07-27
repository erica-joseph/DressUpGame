package ucf.assignment;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.File;

public class Controller implements Initializable {
    public Spinner<Integer> girlSpinner;
    public ImageView girlChoice;
    public ImageView girlChoiceBottom;
    public ImageView girlChoiceTop;
    public ImageView girlChoiceShoes;
    public int index;
    public Button selected;
    public Button save;
    public Spinner<Integer> girlSpinner1;
    public Button selected1;
    public Spinner<Integer> girlSpinner2;
    public Button selected2;
    public Spinner<Integer> girlSpinner3;
    public Button tops;
    public Button bottoms;
    public Button shoes;
    public Button longShirt;
    public Button longShirt1;
    public Button longShirt2;
    public Button longShirt3;
    public Button bottoms1;
    public Button bottoms2;
    public Button bottoms3;
    public Button shoes1;
    public Button shoes2;
    public Button shoes3;
    public Button playWater;
    public Button modelOutfits;
    public Button home;
    public Button saveOutfit;
    public Button loadOutfit;
    public Button random;
    ArrayList<String> array =  new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) { //loading the initialized statements
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2);
        valueFactory.setValue(0);
        valueFactory.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (girlSpinner.getValue() == 0) {
                girlChoice.setImage(new Image("/ucf/assignment/Girls/Girl1A.png"));
                array.add("/ucf/assignment/Girls/Girl1A.png");
                if(array.contains("/ucf/assignment/Clothes/Bottom2.png")){
                    array.remove("/ucf/assignment/Clothes/Bottom2.png");
                }
                if(array.contains("/ucf/assignment/Girls/Girl2A.png")){
                    array.remove("/ucf/assignment/Girls/Girl2A.png");
                }
                girlSpinner.setStyle("-fx-control-inner-background: #d9ac8f; -fx-border-color: transparent; -fx-text-color: #d9ac8f;");
            }
            else if (girlSpinner.getValue() == 1) {
                girlChoice.setImage(new Image("/ucf/assignment/Girls/Girl2A.png"));
                array.add("/ucf/assignment/Girls/Girl2A.png");
                if(array.contains("/ucf/assignment/Girls/Girl1A.png")){
                    array.remove("/ucf/assignment/Girls/Girl1A.png");
                }
                if(array.contains("/ucf/assignment/Girls/Girl3A.png")){
                    array.remove("/ucf/assignment/Girls/Girl3A.png");
                }
                girlSpinner.setStyle("-fx-control-inner-background: #42260e;");
            }
            else if (girlSpinner.getValue() == 2) {
                girlChoice.setImage(new Image("/ucf/assignment/Girls/Girl3A.png"));
                array.add("/ucf/assignment/Girls/Girl3A.png");
                if(array.contains("/ucf/assignment/Girls/Girl2A.png")){
                    array.remove("/ucf/assignment/Girls/Girl2A.png");
                }
                if(array.contains("/ucf/assignment/Girls/Girl1A.png")){
                    array.remove("/ucf/assignment/Girls/Girl1A.png");
                }
                girlSpinner.setStyle("-fx-control-inner-background: #b76d3e;");
            }
        });
        girlSpinner.setValueFactory(valueFactory);
        girlChoice.setImage(new Image("/ucf/assignment/Girls/GirlSilhouette.png"));
        index = girlSpinner.getValue();

    }



        public void bottomsLong (ActionEvent event){
            girlChoiceBottom.setImage(new Image("/ucf/assignment/Clothes/Bottom1.png")); //long skirt
            array.add("/ucf/assignment/Clothes/Bottom1.png");
            if(array.contains("/ucf/assignment/Clothes/Bottom2.png")){
                array.remove("/ucf/assignment/Clothes/Bottom2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Bottom3.png")){
                array.remove("/ucf/assignment/Clothes/Bottom3.png");
            }
        }
        public void bottomsSkirt (ActionEvent event){
            girlChoiceBottom.setImage(new Image("/ucf/assignment/Clothes/Bottom2.png")); //shorts
            array.add("/ucf/assignment/Clothes/Bottom2.png");
            if(array.contains("/ucf/assignment/Clothes/Bottom1.png")){
                array.remove("/ucf/assignment/Clothes/Bottom1.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Bottom3.png")){
                array.remove("/ucf/assignment/Clothes/Bottom3.png");
            }
        }
        public void bottomsShorts (ActionEvent event){
            girlChoiceBottom.setImage(new Image("/ucf/assignment/Clothes/Bottom3.png")); //skirt
            array.add("/ucf/assignment/Clothes/Bottom3.png");
            if(array.contains("/ucf/assignment/Clothes/Bottom2.png")){
                array.remove("/ucf/assignment/Clothes/Bottom2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Bottom1.png")){
                array.remove("/ucf/assignment/Clothes/Bottom1.png");
            }
        }


        public void topLong (ActionEvent event){
            girlChoiceTop.setImage(new Image("/ucf/assignment/Clothes/Top3.png")); //long
            array.add("/ucf/assignment/Clothes/Top3.png");
            if(array.contains("/ucf/assignment/Clothes/Top2.png")){
                array.remove("/ucf/assignment/Clothes/Top2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Top1.png")){
                array.remove("/ucf/assignment/Clothes/Top1.png");
            }
        }
        public void topMedium (ActionEvent event){
            girlChoiceTop.setImage(new Image("/ucf/assignment/Clothes/Top2.png")); //medium
            array.add("/ucf/assignment/Clothes/Top2.png");
            if(array.contains("/ucf/assignment/Clothes/Top1.png")){
                array.remove("/ucf/assignment/Clothes/Top1.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Bottom3.png")){
                array.remove("/ucf/assignment/Clothes/Bottom3.png");
            }
        }
        public void topShort (ActionEvent event){
            girlChoiceTop.setImage(new Image("/ucf/assignment/Clothes/Top1.png")); //short
            array.add("/ucf/assignment/Clothes/Top1.png");
            if(array.contains("/ucf/assignment/Clothes/Top2.png")){
                array.remove("/ucf/assignment/Clothes/Top2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Top3.png")){
                array.remove("/ucf/assignment/Clothes/Top3.png");
            }
        }

        public void shoesSandal (ActionEvent event){
            girlChoiceShoes.setImage(new Image("/ucf/assignment/Clothes/Shoes1.png")); //sandal
            array.add("/ucf/assignment/Clothes/Shoes1.png");
            if(array.contains("/ucf/assignment/Clothes/Shoes2.png")){
                array.remove("/ucf/assignment/Clothes/Shoes2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Shoes3.png")){
                array.remove("/ucf/assignment/Clothes/Shoes3.png");
            }


        }
        public void shoesOx (ActionEvent event){
            girlChoiceShoes.setImage(new Image("/ucf/assignment/Clothes/Shoes2.png")); //oxford
            array.add("/ucf/assignment/Clothes/Shoes2.png");
            if(array.contains("/ucf/assignment/Clothes/Shoes3.png")){
                array.remove("/ucf/assignment/Clothes/Shoes3.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Shoes1.png")){
                array.remove("/ucf/assignment/Clothes/Shoes1.png");
            }
        }
        public void shoesBoot (ActionEvent event){
                girlChoiceShoes.setImage(new Image("/ucf/assignment/Clothes/Shoes3.png")); //high
            array.add("/ucf/assignment/Clothes/Shoes3.png");
            if(array.contains("/ucf/assignment/Clothes/Shoes2.png")){
                array.remove("/ucf/assignment/Clothes/Shoes2.png");
            }
            if(array.contains("/ucf/assignment/Clothes/Shoes1.png")){
                array.remove("/ucf/assignment/Clothes/Shoes1.png");
            }
        }


        FileChooser fileChooser = new FileChooser(); //instance of the file chooser

        public void saveLook (ActionEvent event) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
            camera();
            try {
                Window stage = selected.getScene().getWindow(); //displaying and opening
                fileChooser.setTitle("Save"); //title
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("png", "*.png")); //filtering to only have relevant files
                File file = fileChooser.showSaveDialog((stage)); //launcing dialogue for saving
                fileChooser.setInitialDirectory((file.getParentFile()));
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpMain.fxml"))); //access the file needed to load FXML; this will be the source of the code
                WritableImage snapshot = stage.getScene().snapshot(null);
                BufferedImage BI = SwingFXUtils.fromFXImage(snapshot, null);
                ImageIO.write(BI, "png", file);
                ;
            }
            catch (Exception ignored){}


        }


    public void goHome(ActionEvent event) throws IOException {
        Stage stage;//set stage
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/ucf/assignment/DressUpConsole.fxml")));//load the main view of fxml
        Scene scene = new Scene(root); // attach scene graph to scene
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("To-do List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        scene.getStylesheets().add("ucf/assignment/Styling/DressUpStyle.css"); //stylesheet on hand
        stage.show(); // display the stage
    }

    public void saveoutOutfit(ActionEvent actionEvent) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(girlChoice!=null && girlChoiceTop!=null && girlChoiceBottom!=null && girlChoiceShoes!=null) {
            sparkle();
            Window stage = saveOutfit.getScene().getWindow(); //displaying and opening
            fileChooser.setTitle("Save"); //title
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt")); //filtering to only have relevant files
            BufferedWriter bw = null; //buffered writer to make easier
            try {
                File file = fileChooser.showSaveDialog((stage)); //launcing dialogue for saving
                fileChooser.setInitialDirectory((file.getParentFile()));
                FileWriter fw = new FileWriter(file);//writing file
                bw = new BufferedWriter(fw);

                for (int i = 0; i <= array.size() - 1; i++) {
                    fw.write(array.get(i) + "\n"); //splitting the columns to store separately
                }
                bw.close(); //closing bufered writer
                fw.close();
            } catch (Exception ignored) {
            }
        }



    }

    public void loadinOutfit(ActionEvent actionEvent) throws FileNotFoundException {
        Window stage = saveOutfit.getScene().getWindow(); //displaying and opening
        fileChooser.setTitle("Open"); //title
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter( "text file", "*.txt")); //filtering to only have relevant files

        try {
            File file = fileChooser.showOpenDialog((stage)); //launcing dialogue for saving
            fileChooser.setInitialDirectory((file.getParentFile()));
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine();
            while (line != null) {
                if (line.startsWith("/") && line.endsWith("g")) {
                    listOfLines.add(line);
                }

                line = bufReader.readLine();

            }
            bufReader.close();

            girlChoice.setImage(new Image (listOfLines.get(0)));
            girlChoiceBottom.setImage(new Image (listOfLines.get(1)));
            girlChoiceTop.setImage(new Image (listOfLines.get(2)));
            girlChoiceShoes.setImage(new Image (listOfLines.get(3)));

        } catch (IOException ignored) {

        }
    }

    public void Random(ActionEvent actionEvent) {

            ArrayList<String> com = new ArrayList<>();
            com.add("/ucf/assignment/Girls/Girl1A.png");
            com.add("/ucf/assignment/Girls/Girl2A.png");
            com.add("/ucf/assignment/Girls/Girl3A.png");

            ArrayList<String> tops = new ArrayList<>();
            tops.add("/ucf/assignment/Clothes/Top1.png");
            tops.add("/ucf/assignment/Clothes/Top2.png");
            tops.add("/ucf/assignment/Clothes/Top3.png");

            ArrayList<String> bottoms = new ArrayList<>();
            bottoms.add("/ucf/assignment/Clothes/Bottom1.png");
            bottoms.add("/ucf/assignment/Clothes/Bottom2.png");
            bottoms.add("/ucf/assignment/Clothes/Bottom3.png");

            ArrayList<String> shoes = new ArrayList<>();
            shoes.add("/ucf/assignment/Clothes/Shoes1.png");
            shoes.add("/ucf/assignment/Clothes/Shoes2.png");
            shoes.add("/ucf/assignment/Clothes/Shoes3.png");
            int randIndex = (int) (Math.random() * (3) + 0);
            int randIndex1 = (int) (Math.random() * (3) +0);
            int randIndex2 = (int) (Math.random() * (3) +0);
            int randIndex3 = (int) (Math.random() * (3) + 0);

            girlChoice.setImage(new Image(com.get(randIndex)));
            girlChoiceShoes.setImage(new Image(shoes.get(randIndex1)));
            girlChoiceBottom.setImage(new Image(bottoms.get(randIndex2)));
            girlChoiceTop.setImage(new Image(tops.get(randIndex3)));
            System.out.printf("%d\n%d\n%d\n%d\n", randIndex,randIndex1,randIndex2,randIndex3);


    }

    public void camera () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream snap = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/Snap.wav";
        snap = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(snap);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }
    public void sparkle () throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream dress = null;
        String clipPath = "src/main/resources/ucf/assignment/Music/DressUpOut.wav";
        dress = AudioSystem.getAudioInputStream(new File(clipPath));
        Clip clip = AudioSystem.getClip();
        clip.open(dress);
        FloatControl gainControl =
                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-25.0f); // Reduce volume by 10 decibels.
        clip.start();
    }
}

