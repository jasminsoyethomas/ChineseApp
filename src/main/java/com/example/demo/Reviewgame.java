package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class Reviewgame implements Initializable {

    ArrayList<String> cardDefinitions = new ArrayList<>();
    ArrayList<String> cardVocab = new ArrayList<>();
    @FXML
    VBox vBoxStats;

    @FXML
    Button button1;

    @FXML
    Button button2;

    @FXML
    Button button3;

    @FXML
    Button button0;

    @FXML
    Label labelWord;

    @FXML
    ImageView imageViewPanda;




    CardDeck cardDeck = new CardDeck();
    Card currentCard = Data.currentlyLoadedDeck.get(0);

    int correct = 0;
    int incorrect = 0;


    public void loadData(){
        //Label label0 = (Label) vBoxStats.getChildren().get(index)
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(Data.currentlyLoadedDeck.size());
        Label label0 = (Label) vBoxStats.getChildren().get(0);
        label0.setText("Number of cards left: " + Data.currentlyLoadedDeck.size());
        for (int i = 0; i < Data.currentlyLoadedDeck.size(); i++) {
            cardDefinitions.add(Data.currentlyLoadedDeck.get(i).getDefinition());
            cardVocab.add(Data.currentlyLoadedDeck.get(i).getWord());
        }
        loadQuestion();
    }

        public void showFinalScore(){
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(labelWord.getScene().getWindow());
                VBox diaologVbox = new VBox(20);
                diaologVbox.getChildren().add(new Text("Congratulations! You finished the game!"));
                diaologVbox.getChildren().add(new Text("Percentage Correct: " + (correct/((double)correct + incorrect))* 100));
                diaologVbox.getChildren().add(new Text("Percentage Incorrect: " + (incorrect/((double)correct + incorrect))*100));
                diaologVbox.getChildren().add(new Button("Exit Game"));
                Scene dialogScene = new Scene (diaologVbox, 350, 200);
                dialog.setScene(dialogScene);
                dialog.show();
                Button buttonExit = (Button) diaologVbox.getChildren().get(3);
                buttonExit.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    Platform.exit();
                }
            });
            }

public void wrongAnswer(ActionEvent event){
    final Stage dialog = new Stage();
    dialog.initModality(Modality.APPLICATION_MODAL);
    Node node = (Node) event.getSource();
    dialog.initOwner(node.getScene().getWindow());
    VBox diaologVbox = new VBox(20);
    diaologVbox.getChildren().add(new Text("This is the right answer"));
    diaologVbox.getChildren().add(new Text(currentCard.getDefinition()));
    Scene dialogScene = new Scene (diaologVbox, 250, 100);
    dialog.setScene(dialogScene);
    dialog.show();
}

public void loadQuestion(){
    ArrayList<String> choices = new ArrayList<>();

        currentCard = Data.currentlyLoadedDeck.remove(0);
        choices.add(currentCard.getDefinition());
        for (int i = 0; i < 3; i++){
            int random = (int) (Math.random()*cardDefinitions.size());
            while(choices.contains(cardDefinitions.get(random))){
               random = (int) (Math.random()*cardDefinitions.size());
                System.out.println(random);
                System.out.println(cardDefinitions.get(random));

            }
            choices.add(cardDefinitions.get(random));
        }
    Collections.shuffle(choices);

        button0.setText(choices.get(0));
    button1.setText(choices.get(1));
    button2.setText(choices.get(2));
    button3.setText(choices.get(3));

    labelWord.setText(currentCard.getWord());
    int randomNum = (int) (Math.random()*15);
    imageViewPanda.setImage(new Image(("/images/image"+ randomNum+ ".gif")));


}

public boolean rightOrWrong(Button button){
        if(button.getText().equals(currentCard.getDefinition())){
            return true;
        }
        else{
            return false;
        }

}

public void buttonSelect(ActionEvent event) {
    Button buttonSelected = (Button) event.getSource();
    rightOrWrong(buttonSelected);
    if(rightOrWrong(buttonSelected)){
        System.out.println("correct");
        guessCorrect();
        if(Data.currentlyLoadedDeck.size()==0) {
            showFinalScore();
        }
        else {
            loadQuestion();
        }
    }
    else{
        guessIncorrect();
        wrongAnswer(event);
        if(Data.currentlyLoadedDeck.size()==0) {
            showFinalScore();}
        else {
            loadQuestion();
        }
    }

    //update stats

}

public void guessCorrect(){
        Label numLeft = (Label) vBoxStats.getChildren().get(0);
        numLeft.setText("Number of cards left: " + Data.currentlyLoadedDeck.size());
        Label numCorrect = (Label) vBoxStats.getChildren().get(1);
        correct++;
        numCorrect.setText("Number Correct: " + (correct));
}

public void guessIncorrect(){
    Label numLeft = (Label) vBoxStats.getChildren().get(0);
    numLeft.setText("Number of cards left: " + Data.currentlyLoadedDeck.size());
    Label numCorrect = (Label) vBoxStats.getChildren().get(2);
    incorrect++;
    numCorrect.setText("Number Incorrect: " + (incorrect));

    }







    /*
       Game logic
         PUll a card from Data.currentlyLoadedDeck -> use .remove to store the returned Card Object
     */


}
