package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Reviewgame implements Initializable {

    ArrayList<String> cardDefinitions;
    ArrayList<String> cardVocab;
    @FXML
    VBox vBoxStats;

    CardDeck cardDeck = new CardDeck();


    public void loadData(){
        //Label label0 = (Label) vBoxStats.getChildren().get(index)
    }

    public void initialize(URL location, ResourceBundle resources){
       Data.loadFakeDeck();
        System.out.println(Data.currentlyLoadedDeck.size());
        Label label0 = (Label) vBoxStats.getChildren().get(0);
        label0.setText("Number of cards left: " + Data.currentlyLoadedDeck.size());
        for(int i = 0; i < Data.currentlyLoadedDeck.size(); i++) {
            cardDefinitions.add(Data.currentlyLoadedDeck.get(0).getDefinition());
            cardVocab.add(Data.currentlyLoadedDeck.get(0).getWord());
        }
    }

    /*
       Game logic
         PUll a card from Data.currentlyLoadedDeck -> use .remove to store the returned Card Object
     */


}
