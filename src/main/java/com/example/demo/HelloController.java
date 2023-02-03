package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Button buttonCreateOwnDeck;

    @FXML
   ImageView titleImage;

    @FXML
    private Button buttonUseExistingDeck;



    public void loadScreen2(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createowndeck.fxml"));
        Scene scene;
        try{
            scene = new Scene(fxmlLoader.load(), 620, 540);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) buttonCreateOwnDeck.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
    }

    public void loadScreen3(){
        CardDeck cardDeck = new CardDeck();
        cardDeck.loadCardDeck((Stage)(buttonUseExistingDeck.getScene().getWindow()));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reviewgame.fxml"));
        Scene scene;
        try{
            scene = new Scene(fxmlLoader.load(), 620, 540);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) buttonUseExistingDeck.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleImage.setImage(new Image("/images/amazing.jpg"));
    }
}



