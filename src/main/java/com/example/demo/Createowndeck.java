package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Createowndeck {

    @FXML
    TextField textFieldDefinition;

    @FXML
    VBox vboxDefinitions;

    @FXML
    TextField textFieldWord;

    @FXML
    VBox vboxWord;

    @FXML
    TextField deckName;

    @FXML
    Button buttonCreateDeck;

    public void addWordToWordBank() {
        String wordTyped = textFieldWord.getText();
        Label newDefinition = new Label(wordTyped);
        String wordTyped2 = textFieldDefinition.getText();
        Label newWord = new Label(wordTyped2);

        vboxWord.getChildren().add(newDefinition);
        vboxDefinitions.getChildren().add(newWord);

        textFieldWord.setText(" ");
        textFieldDefinition.setText(" ");


    }



    public void createDeck(ActionEvent event) {
        CardDeck newDeck = new CardDeck();
        if(vboxDefinitions.getChildren().size() < 4){
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            Node node = (Node) event.getSource();
            dialog.initOwner(node.getScene().getWindow());
            VBox diaologVbox = new VBox(20);
            diaologVbox.getChildren().add(new Text("Enter at least 4 cards"));
            Scene dialogScene = new Scene (diaologVbox, 250, 100);
            dialog.setScene(dialogScene);
            dialog.show();
        }
        else{
            for(int i = 0; i < vboxDefinitions.getChildren().size(); i++) {
                String word = ((Label) vboxWord.getChildren().get(i)).getText();
                String def = ((Label) vboxDefinitions.getChildren().get(i)).getText();
                Card newCard = new Card(word,def);
                newDeck.cardDeck.add(newCard);
            }
            newDeck.saveDeck(deckName.getText());
        }
     loadScreen3();
    }

    public void loadScreen3(){
        CardDeck cardDeck = new CardDeck();
        cardDeck.loadCardDeck((Stage)(buttonCreateDeck.getScene().getWindow()));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reviewgame.fxml"));
        Scene scene;
        try{
            scene = new Scene(fxmlLoader.load(),320,240);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) buttonCreateDeck.getScene().getWindow();
        stage.close();
        stage.setScene(scene);
        stage.show();
    }



}
