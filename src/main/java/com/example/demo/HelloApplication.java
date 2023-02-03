package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*
        CardDeck cardDeck = new CardDeck();
        Card hello = new Card("Hello","hi");
        cardDeck.addCard(hello);
        cardDeck.saveDeck();


        CardDeck deck2 = new CardDeck();
        deck2.loadCardDeck();
        System.out.println(deck2.cardDeck.size());
    */
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 540);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}