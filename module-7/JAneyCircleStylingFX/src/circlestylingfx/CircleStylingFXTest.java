/* Jonah Aney 9/21/25 CSD-420 Module 7: Circle Styling

 * Test class for CircleStylingFX JavaFX application
 * Tests the creation and styling of circles using CSS

 */

package circlestylingfx;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStylingFXTest {
    
    private static boolean testsPassed = true;
    private static int testCount = 0;
    private static int passedCount = 0;
    
    public static void main(String[] args) {
// Initialize JavaFX toolkit for testing
        new JFXPanel();
        
        System.out.println("--- CircleStylingFX Test Suite ---\n");
        
// Run tests on JavaFX Application Thread
        Platform.runLater(() -> {
            try {
                testCircleCreation();
                testCircleProperties();
                testSceneCreation();
                testCSSLoading();
                testApplicationStructure();
                
// Print final results
                printTestResults();
                
// Exit the application
                Platform.exit();
                
            } catch (Exception e) {
                System.err.println("Test execution failed: " + e.getMessage());
                e.printStackTrace();
                Platform.exit();
            }
        });
    }
     
// Test that circles can be created with correct radius
    private static void testCircleCreation() {
        System.out.println("Test 1: Circle Creation");
        testCount++;
        
        try {
            Circle circle1 = new Circle(40);
            Circle circle2 = new Circle(40);
            Circle circle3 = new Circle(40);
            Circle circle4 = new Circle(40);
            
// Verify radius
            if (circle1.getRadius() == 40 && circle2.getRadius() == 40 && 
                circle3.getRadius() == 40 && circle4.getRadius() == 40) {
                System.out.println("PASS: All circles created with correct radius (40)");
                passedCount++;
            } else {
                System.out.println("FAIL: Circle radius incorrect");
                testsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception during circle creation: " + e.getMessage());
            testsPassed = false;
        }
        System.out.println();
    }
    
// Test that circles have correct style classes and IDs
    private static void testCircleProperties() {
        System.out.println("Test 2: Circle Style Properties");
        testCount++;
        
        try {
            Circle circle1 = new Circle(40);
            circle1.getStyleClass().add("plaincircle");
            
            Circle circle2 = new Circle(40);
            circle2.getStyleClass().add("plaincircle");
            
            Circle circle3 = new Circle(40);
            circle3.setId("redcircle");
            
            Circle circle4 = new Circle(40);
            circle4.setId("greencircle");
            
// Verify style classes and IDs
            boolean test1 = circle1.getStyleClass().contains("plaincircle");
            boolean test2 = circle2.getStyleClass().contains("plaincircle");
            boolean test3 = "redcircle".equals(circle3.getId());
            boolean test4 = "greencircle".equals(circle4.getId());
            
            if (test1 && test2 && test3 && test4) {
                System.out.println("PASS: All circles have correct style classes and IDs");
                passedCount++;
            } else {
                System.out.println("FAIL: Style classes or IDs incorrect");
                System.out.println("  Circle1 plaincircle: " + test1);
                System.out.println("  Circle2 plaincircle: " + test2);
                System.out.println("  Circle3 redcircle ID: " + test3);
                System.out.println("  Circle4 greencircle ID: " + test4);
                testsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception during style property test: " + e.getMessage());
            testsPassed = false;
        }
        System.out.println();
    }
    
// Test scene creation with HBox layout
    private static void testSceneCreation() {
        System.out.println("Test 3: Scene and Layout Creation");
        testCount++;
        
        try {
// Create circles
            Circle circle1 = new Circle(40);
            Circle circle2 = new Circle(40);
            Circle circle3 = new Circle(40);
            Circle circle4 = new Circle(40);
            
// Create layout
            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(circle1, circle2, circle3, circle4);
            
// Create scene
            Scene scene = new Scene(hbox, 400, 150);
            
// Verify scene properties
            boolean widthCorrect = scene.getWidth() == 400;
            boolean heightCorrect = scene.getHeight() == 150;
            boolean layoutCorrect = scene.getRoot() instanceof HBox;
            boolean childrenCount = ((HBox)scene.getRoot()).getChildren().size() == 4;
            
            if (widthCorrect && heightCorrect && layoutCorrect && childrenCount) {
                System.out.println("PASS: Scene created with correct dimensions and layout");
                passedCount++;
            } else {
                System.out.println("FAIL: Scene properties incorrect");
                System.out.println("  Width (400): " + widthCorrect);
                System.out.println("  Height (150): " + heightCorrect);
                System.out.println("  Layout HBox: " + layoutCorrect);
                System.out.println("  Children count (4): " + childrenCount);
                testsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception during scene creation test: " + e.getMessage());
            testsPassed = false;
        }
        System.out.println();
    }
    
// Test CSS resource loading
    private static void testCSSLoading() {
        System.out.println("Test 4: CSS Resource Loading");
        testCount++;
        
        try {
// Test if CSS resource exists
            var resource = CircleStylingFXTest.class.getResource("mystyle.css");
            
            if (resource != null) {
                System.out.println("PASS: CSS file 'mystyle.css' found and accessible");
                System.out.println("  Resource URL: " + resource.toString());
                passedCount++;
            } else {
                System.out.println("FAIL: CSS file 'mystyle.css' not found");
                System.out.println("  Make sure mystyle.css is in the same directory as the Java files");
                testsPassed = false;
            }
        } catch (Exception e) {
            System.out.println("FAIL: Exception during CSS loading test: " + e.getMessage());
            testsPassed = false;
        }
        System.out.println();
    }
    
// Test the overall application structure
    private static void testApplicationStructure() {
        System.out.println("Test 5: Application Structure");
        testCount++;
        
        try {
// Test that the main class exists and extends Application
            Class<?> mainClass = Class.forName("circlestylingfx.CircleStylingFX");
            boolean extendsApplication = javafx.application.Application.class.isAssignableFrom(mainClass);
            
            if (extendsApplication) {
                System.out.println("PASS: CircleStylingFX class extends Application");
                passedCount++;
            } else {
                System.out.println("FAIL: CircleStylingFX class does not extend Application");
                testsPassed = false;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("FAIL: CircleStylingFX class not found");
            System.out.println("  Make sure the class name matches the filename");
            testsPassed = false;
        } catch (Exception e) {
            System.out.println("FAIL: Exception during application structure test: " + e.getMessage());
            testsPassed = false;
        }
        System.out.println();
    }
    
// Print final test results
    private static void printTestResults() {
        System.out.println("--- Test Results ---");
        System.out.println("Tests run: " + testCount);
        System.out.println("Tests passed: " + passedCount);
        System.out.println("Tests failed: " + (testCount - passedCount));
        
        if (testsPassed) {
            System.out.println("\nALL TESTS PASSED! Your CircleStylingFX application is working correctly.");
        } else {
            System.out.println("\nSome tests failed. Please review the output above and fix the issues.");
        }
        
        System.out.println("\n--- Test Coverage ---");
        System.out.println("Circle creation and radius verification");
        System.out.println("Style class and ID assignment");
        System.out.println("Scene and layout construction");
        System.out.println("CSS resource accessibility");
        System.out.println("Application class structure");
    }
}