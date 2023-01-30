package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Card> currentlyLoadedDeck = new ArrayList<>();

   public static void loadFakeDeck() {
       Card card1 = new Card("hi1", "Hello1");
       Card card2 = new Card("hi2", "Hello2");
       Card card3 = new Card("hi3", "Hello3");
       Card card4 = new Card("hi4", "Hello4");

       currentlyLoadedDeck.add(card1);
       currentlyLoadedDeck.add(card2);
       currentlyLoadedDeck.add(card3);
       currentlyLoadedDeck.add(card4);

   }

    public void loadCardDeckDefault(){

    }


}
