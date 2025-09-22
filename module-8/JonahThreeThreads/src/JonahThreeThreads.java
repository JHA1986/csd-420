/* Jonah Aney 9/21/25 CSD-420 Module 8: Three Threads:

Follow the directions below:

    Create a class titled [your first="" name="" here=""] ThreeThreads.
        In this class, you are to use three threads to output three types of characters to a text area for display.
            In the first thread, you are to output random letter characters such as a, b, c, d … 
            In the second thread, you are to output random number digits such as 0, 1, 2, 3, 4, 5, 6, 7, 8, 9.
            In the third thread, you are to output random characters such as !, @, #, $, %, &, * 
        Display a minimum of 10,000 for each of the three sets.
    Write test code that ensures all methods function correctly.

 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JonahThreeThreads extends JFrame {
    
// Text area where all characters will be displayed
    private JTextArea textArea;
    
// Number of characters to generate for each thread    
    private static final int COUNT = 10000;
    
// Random generator for letters, digits, and symbols   
    private Random random = new Random();
    
// Constructor: sets up the GUI window
    public JonahThreeThreads() {
        super("Jonah's Three Thread Output");  // Window title
        
// Create a text area with fixed size
        textArea = new JTextArea(30, 80);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));   // fixed-width font
        textArea.setEditable(false);    // user cannot type into it
        
// Add the text area inside a scroll pane so it can scroll
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
// Standard JFrame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // adjusts window to fit components
        setVisible(true);
        
// Start the three worker threads
        startThreads();
    }

// Creates and launches three threads: one for letters, one for digits, one for symbols
    private void startThreads() {
        Thread lettersThread = new Thread(() -> generateLetters());
        Thread digitsThread = new Thread(() -> generateDigits());
        Thread symbolsThread = new Thread(() -> generateSymbols());

// Run them in parallel
        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();
    }
    
// Thread 1: generate random lowercase letters, a–z.
    private void generateLetters() {
        for (int i = 0; i < COUNT; i++) {
            char letter = (char) ('a' + random.nextInt(26));    // pick random letter
            appendToTextArea(String.valueOf(letter));           // send to GUI
        }
    }

// Thread 2: generate random digits, 0–9.
    private void generateDigits() {
        for (int i = 0; i < COUNT; i++) {
            char digit = (char) ('0' + random.nextInt(10));     // pick random digit 
            appendToTextArea(String.valueOf(digit));            // send to GUI
        }
    }

// Thread 3: generate random symbols from a fixed set
    private void generateSymbols() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < COUNT; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];  // pick random symbol
            appendToTextArea(String.valueOf(symbol));               // send to GUI
        }
    }

// Safely appends text to the JTextArea.
// Swing components must be updated on the Event Dispatch Thread (EDT),
// so we use SwingUtilities.invokeLater to ensure thread-safety.
    private void appendToTextArea(String text) {
        SwingUtilities.invokeLater(() -> textArea.append(text));
    }

// Main entry point: ensures GUI creation happens on the EDT
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JonahThreeThreads::new);
    }
}

