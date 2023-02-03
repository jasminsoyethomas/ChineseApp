package com.example.demo;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class CardDeck implements Serializable {
    public ArrayList<Card> cardDeck = new ArrayList<>();
    public void addCard(Card card) {
        cardDeck.add(card);
    }

    public void saveDeck(String name) {
        String filename = System.getProperty("user.home")+"/Desktop/" + name + ".txt";
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Method for serialization of object
        try {
            out.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Object has been serialized");
    }

    public void loadCardDeck(Stage stage) {
        // Deserialization
        CardDeck deckLoaded;
        FileChooser fileChooser = new FileChooser();
        File fileSelected = fileChooser.showOpenDialog(stage);
        try {
            // Reading the object from a file
            String filename = System.getProperty("user.home")+"/Desktop/amazing.txt";
            FileInputStream file = new FileInputStream(fileSelected);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            deckLoaded = (CardDeck) in.readObject();
            cardDeck = deckLoaded.cardDeck; //deck2.cardDeck = deckLoaded.
            Data.currentlyLoadedDeck = deckLoaded.cardDeck;;
            in.close();
            file.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}