/* Jonah Aney 9/10/25 CSD-420 Module 6: BubbleSort

 * Follow the directions below:
Write a program with the two following generic methods using a bubble sort: Module 6 Programming Assignment Click for more options. The first method sorts the elements using the Comparable interface, and the second uses the Comparator interface.
Bubble_Sort.java Click for more options  is a solution zip file for your review. Ensure you write your own code, only using the attached solution as an example, and document your code.
Write test code that ensures your code functions correctly.
 */

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {

// Bubble sort using Comparable. Generic method where <E> must implement Comparable
// That means we can call compareTo() on elements
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {     // Outer loop runs
            for (int j = 0; j < list.length - 1 - i; j++) {     // Inner loop compares neighbors
                
// compareTo() > 0 means left element is larger then the right element
                if (list[j].compareTo(list[j + 1]) > 0) {
                    
// Swap elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

// Bubble sort using Comparator - allows a custom Comparator to decide the sorting rules
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                
// Use the comparator’s compare() instead of compareTo()                
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    
// Swap elemnts
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

// Helper method to print arrays
    public static <E> void printArray(E[] array) {
        
// Arrays.toString() gives a clean string representation of the array        
        System.out.println(Arrays.toString(array));
    }

// Main method to test the bubble sort methods with Integers and Strings
    public static void main(String[] args) {

// Test with Integer array - Comparable
        Integer[] intArray = {3, 1, 6, 5, 9, 2};
        System.out.println("Original Integer array:");
        printArray(intArray);

        bubbleSort(intArray);   // using Integer.compareTo()
        System.out.println("Sorted with Comparable:");
        printArray(intArray);

// Test with String array - Comparable
        String[] stringArray = {"Squares", "Circle", "Triangle", "X"};
        System.out.println("\nOriginal String array:");
        printArray(stringArray);

        bubbleSort(stringArray);    // uses String.compareTo() sorts in alphabetic order
        System.out.println("Sorted with Comparable:");
        printArray(stringArray);

// Test with Integer array - Comparator - descending order
        Integer[] intArray2 = {3, 1, 6, 5, 9, 2};
        System.out.println("\nOriginal Integer array:");
        printArray(intArray2);

        bubbleSort(intArray2, Comparator.reverseOrder()); // using Comparator
        System.out.println("Sorted with Comparator (Descending):");
        printArray(intArray2);

// Test with String array - Comparator - by length
        String[] stringArray2 = {"Squares", "Circle", "Triangle", "X"};
        System.out.println("\nOriginal String array:");
        printArray(stringArray2);

        bubbleSort(stringArray2, Comparator.comparingInt(String::length));
        System.out.println("Sorted with Comparator (By Length):");
        printArray(stringArray2);
    }
}