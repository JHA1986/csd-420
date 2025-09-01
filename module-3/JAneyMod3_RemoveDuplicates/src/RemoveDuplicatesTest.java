/* Jonah Aney 8/31/25 CSD-420 Module 3: Programming Assignment M3

 * Directions:
 * Write a test program that contains a static method that returns a new ArrayList
    *The new ArrayList returned will contain all original values with no duplicates from the original ArrayList.  
    *Fill the Original ArrrayList with 50 random values from 1 to 20.  
    *public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)  
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        
// Create an ArrayList for 50 random values.
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            
// Add each generated value to the ArrayList: A random number between 1-20
            originalList.add(rand.nextInt(20) + 1); 
        }
// Print the original list - this one could have duplicates
        System.out.println("Original List:");
        System.out.println(originalList);

// Remove any duplicates
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        
// Print the list without any duplicates
        System.out.println("\nList without duplicates:");
        System.out.println(uniqueList);
    }

// Generic method to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        
// Using HashSet to remove duplicates
        return new ArrayList<>(new HashSet<>(list));
    }
}
