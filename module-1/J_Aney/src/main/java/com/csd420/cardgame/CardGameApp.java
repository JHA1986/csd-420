/**
 * Jonah Aney 8/17/25 CSD-420 Module-1: Card Game
 * This is a JavaFX program that displays four random cards from a deck of 52 cards.
 * It includes a refresh button to display four different cards each time it is clicked.
 * 
 * Directions:
 * Write a JavaFX program that displays four images randomly selected from a deck of 52 cards. 
 * The AssignmentCards.zip Click for more options  has card files titled 1.png, 2.png, 3.png, 4.png, …, 52.png. 
 * For this application:

    Store the images in a "cards" sub directory.
    Using these cards, randomly select four cards for display.
    Below the cards, there will be a refresh button that will then display four different cards.
    Use Lambda Expressions.
    You may use a different set of images you either have or decide to make.

 * @author Jonah Aney
 */
package com.csd420.cardgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGameApp extends Application {

    private static final int NUM_CARDS = 52;
    private static final int CARDS_TO_SHOW = 4;
    private final List<Integer> deck = new ArrayList<>();
    private final List<ImageView> cardViews = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
// Initialize deck with cards 1-52
        for (int i = 1; i <= NUM_CARDS; i++) {
            deck.add(i);
        }

// Create layout containers
        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);

// Create 4 ImageViews for displaying cards
        for (int i = 0; i < CARDS_TO_SHOW; i++) {
            ImageView cardView = new ImageView();
            cardView.setFitWidth(120);
            cardView.setPreserveRatio(true);
            cardViews.add(cardView);
            cardBox.getChildren().add(cardView);
        }

// Create refresh button with lambda expression
        Button refreshButton = new Button("Refresh Cards");
        refreshButton.setOnAction(e -> showRandomCards());

// Set up the main layout
        BorderPane root = new BorderPane();
        root.setCenter(cardBox);
        root.setBottom(refreshButton);
        BorderPane.setAlignment(refreshButton, Pos.CENTER);

// Show initial set of cards
        showRandomCards();

// Create and show scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Jonah's Card Randomizer - CSD-420 Module-1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

/**
* Display four random cards using lambda expressions
*/
    private void showRandomCards() {
        Collections.shuffle(deck);
        
// Use lambda expression with streams to display first 4 cards
        deck.stream()
            .limit(CARDS_TO_SHOW)
            .forEach(cardNumber -> {
                int index = deck.subList(0, CARDS_TO_SHOW).indexOf(cardNumber);
                loadCardImage(cardNumber, index);
            });
    }

/**
* Load card image from file system
* @param cardNumber The card number (1-52)
* @param index The position to display the card (0-3)
*/
    private void loadCardImage(int cardNumber, int index) {
        try {
// Look for card images in cards directory
            String imagePath = "../cards/" + cardNumber + ".png";
            File imageFile = new File(imagePath);
            
            if (imageFile.exists()) {
                Image cardImage = new Image(imageFile.toURI().toString());
                cardViews.get(index).setImage(cardImage);
            } else {
                System.out.println("Card image not found: " + imagePath);
// Exception handling for errors
            }
        } catch (Exception e) {
            System.err.println("Error loading card " + cardNumber + ": " + e.getMessage());
        }
    }

/**
* Main method to launch the JavaFX application
*/
    public static void main(String[] args) {
        launch(args);
    }
}