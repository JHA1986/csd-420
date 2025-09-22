/* Jonah Aney 9/21/25 CSD-420 Module 7: Circle Styling

Follow the directions below:

    -Create an external CSS style sheet that defines a class for white fill and black stroke color and an ID for red and green color.
    -Write a JavaFX program that displays four circles and uses the style class and ID. The sample run of the program is shown in the following image. Use the mystyle.css found early in Chapter 31, something like the following code and image: Module 7 Programming Assignment Click for more options .
    -Write test code that ensures your code functions correctly.

 */

package circlestylingfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStylingFX extends Application {
    @Override
    public void start(Stage primaryStage) {
// Create the circles
        Circle circle1 = new Circle(40);
        circle1.getStyleClass().add("plaincircle"); // white fill, black stroke

        Circle circle2 = new Circle(40);
        circle2.getStyleClass().add("plaincircle"); // white fill, black stroke

        Circle circle3 = new Circle(40);
        circle3.setId("redcircle"); // red circle

        Circle circle4 = new Circle(40);
        circle4.setId("greencircle"); // green circle

// Establish the layout with HBox
        HBox hbox = new HBox(10); // spacing of 10
        hbox.getChildren().addAll(circle1, circle2, circle3, circle4);

// Establish the scene
        Scene scene = new Scene(hbox, 400, 150);
        
// Load CSS file with error handling
    try {
        String cssResource = getClass().getResource("mystyle.css").toExternalForm();
        scene.getStylesheets().add(cssResource);
    } catch (NullPointerException e) {
        System.err.println("Warning: mystyle.css not found. Using default styling.");
}

        primaryStage.setTitle("Exercise31_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
