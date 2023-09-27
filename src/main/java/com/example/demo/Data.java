package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Data {
    public static ArrayList<Card> currentlyLoadedDeck = new ArrayList<>();

    public static void loadColorDeck(){
        //add with image
        Card card1 = new Card("红色，hong se", "Red");
        Card card2 = new Card("黑色，hei se", "Black");
        Card card3 = new Card("蓝色，lan se", "Blue");
        Card card4 = new Card("绿色， lu se", "Green");
        Card card5 = new Card("橙色， cheng se", "Orange");
        Card card6 = new Card("紫色， zi se", "Purple");
        Card card7 = new Card("白色， bai se", "White");
        Card card8 = new Card("黄色， huang se", "Yellow");

        currentlyLoadedDeck.add(card1);
        currentlyLoadedDeck.add(card2);
        currentlyLoadedDeck.add(card3);
        currentlyLoadedDeck.add(card4);
        currentlyLoadedDeck.add(card5);
        currentlyLoadedDeck.add(card6);
        currentlyLoadedDeck.add(card7);
        currentlyLoadedDeck.add(card8);


    }

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
