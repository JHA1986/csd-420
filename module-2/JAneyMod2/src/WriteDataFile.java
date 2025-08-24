/* Jonah Aney 8/23/25 CSD-420 Module 2: Assignment M2

 * Directions:
 *  Write a program that stores:
        An array of five random integers.
        An array of five random double values.
    Write the data in a file titled [yourname] datafile.dat.
    If there is no file, the file will be created.
    If there is a file, the data will be appended.
    Write a second program that will read the file and display the data.
    Test the code to ensure the code functions correctly.
 */

// Import java's import/outport package and the random class from the utilies package
import java.io.*;
import java.util.Random;

// Create a class to write a file as part of the main method to start the program
public class WriteDataFile { public static void main(String[] args) {
        Random rand = new Random();
        
// Create two arrays for integers and doubles
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

// Fill arrays with random values
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100);   // For random intergers 0-99
            doubleArray[i] = rand.nextDouble() * 100; // For random doubles 0-100
        }

// Write data to file (append mode = true). Opens the JAneyDataFile.dat file in append mode
        try (PrintWriter out = new PrintWriter(new FileWriter("JAneyDataFile.dat", true))) { // Using true to append, not overwtite
            out.println("Integers:"); 
            
// Loop through the array for intergers
            for (int num : intArray) {
                out.print(num + " ");
            }
            out.println();

            out.println("Doubles:");
            
// Loop through the array for doubles
            for (double num : doubleArray) {
                out.print(num + " ");
            }
            out.println();
            out.println("------"); // Dash lines separation for clarity

            System.out.println("Data written to JAneyDataFile.dat");
            
// Exception class for error handling
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
    

