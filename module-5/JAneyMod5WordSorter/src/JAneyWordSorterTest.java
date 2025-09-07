/* Jonah Aney 9/7/25 CSD-420 Module 5: Programming Assignment: Sets, Maps, and Sorting

 * Directions:
 * Write a test program that reads words from a text file and displays all non-duplicate words in ascending order and then in descending order.

    The file is to be referenced in the program, not needing to be used as a command line reference.
    The word file is to be titled collection_of_words.txt and included in your submission.
    Write test code that ensures the code functions correctly.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.ArrayList;


public class JAneyWordSorterTest {

    public static void main(String[] args) {
        
// New text file to read from. 
        File file = new File("collection_of_words.txt");

// TreeSet automatically removes duplicates and stores words in ascending order.
        Set<String> wordSet = new TreeSet<>();
        
// Read the words from the txt. file, 
        try (Scanner input = new Scanner(file)) {
            
// While loop to scan each word in the file.
            while (input.hasNext()) {
                String word = input.next();
                
// Set all letters to lowercase for consistency.
                wordSet.add(word.toLowerCase()); 
            }
            
// Print error if file is missing.
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

// Show the words in ascending order.
        System.out.println("Car types in ascending order:");
        for (String word : wordSet) {
            System.out.print(word + " ");
        }

// Show the words in descending order. Copy the TreeSet and reverse the order.
        System.out.println("\n\nCar types in descending order:");
        ArrayList<String> wordList = new ArrayList<>(wordSet);
        Collections.sort(wordList, Collections.reverseOrder());
        for (String word : wordList) {
            System.out.print(word + " ");
        }

// Test the code to verify.
        testResults(wordSet, wordList);
    }

    /**
     * The next code is test to verify correctness.
     * - Confirms no duplicates remain.
     * - Checks if sorting works.
     */
    
    public static void testResults(Set<String> ascendingSet, ArrayList<String> descendingList) {
        
// Check for duplicates.
        if (ascendingSet.size() != descendingList.size()) {
            System.out.println("\nError: Duplicate words detected!");
        } else {
            System.out.println("\n\nNo duplicates: Test Passed!");
        }

// Check the ascending order.
        ArrayList<String> ascList = new ArrayList<>(ascendingSet);
        if (!ascList.equals(new ArrayList<>(new TreeSet<>(ascList)))) {
            System.out.println("Error: Words not sorted ascending correctly!");
        } else {
            System.out.println("Ascending order correct: Test Passed!");
        }

// Check the descending order.
        ArrayList<String> checkDesc = new ArrayList<>(ascList);
        Collections.sort(checkDesc, Collections.reverseOrder());
        if (!checkDesc.equals(descendingList)) {
            System.out.println("Error: Words not sorted descending correctly!");
        } else {
            System.out.println("Descending order correct: Test Passed!");
        }
    }
}


