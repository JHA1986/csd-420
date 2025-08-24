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

// Import Java's import/outport package
import java.io.*;

// Create a class to read the file. 
public class ReadDataFile {
    
// The main method to start the program
    public static void main(String[] args) {
        
// Opens and reads the JaneyDataFile.dat file as entire lines intead of seperate characters       
        try (BufferedReader br = new BufferedReader(new FileReader("JaneyDataFile.dat"))) {
            String line; // varaible to hold each line of text as it's read
            
// Prints a header of the file contents
            System.out.println("Contents of JaneyDataFile.dat:");
            
// While loop for reading. Read each line of text from the file until it returns null.
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
// Exception class for error handling
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}    
    

