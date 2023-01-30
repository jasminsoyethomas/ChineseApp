package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

    public void addWordToWordBank() {
        String wordTyped = textFieldWord.getText();
        Label newDefinition = new Label(wordTyped);
        String wordTyped2 = textFieldDefinition.getText();
        Label newWord = new Label(wordTyped2);

        vboxWord.getChildren().add(newDefinition);
        vboxDefinitions.getChildren().add(newWord);


    }



    public void createDeck() {
        CardDeck newDeck = new CardDeck();
        for(int i = 0; i < vboxDefinitions.getChildren().size(); i++) {
            String word = ((Label) vboxWord.getChildren().get(i)).getText();
            String def = ((Label) vboxDefinitions.getChildren().get(i)).getText();
            Card newCard = new Card(word,def);
            newDeck.cardDeck.add(newCard);
        }
        newDeck.saveDeck(deckName.getText());
    }



}
