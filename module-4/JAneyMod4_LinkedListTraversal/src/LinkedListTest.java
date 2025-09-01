/* Jonah Aney 8/30/25 CSD-420 Module 4: Programming Assignment M4

 * Directions:
 * Write a test program that stores 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method. 

    -Test your program storing first 50,000 and then 500,000 integers.
    -After completing this program and having tested both values, in your comments, explain the results and discuss the time taken using both values and their difference with the get(index) approach. (see at bottom below code)
    -Write test code that ensures the code functions correctly.
 */

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTest {

    public static void main(String[] args) {
        
// Run test for both 50,000 and 500,000 elements
        int[] sizes = {50000, 500000};

        for (int size : sizes) {
            System.out.println("Testing LinkedList with " + size + " elements.");

// Create LinkedList and fill it
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                list.add(i);
            }
            
// Test for correctness
            if (list.size() != size) {
                System.out.println("❌ Error: LinkedList does not contain the expected number of elements.");
                return;
            }

// Traverse the list using the iterator
            long startTime = System.currentTimeMillis();
            Iterator<Integer> iter = list.iterator();
            int iteratorCount = 0;
            while (iter.hasNext()) {
                iter.next();
                iteratorCount++;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Iterator traversal time: " + (endTime - startTime) + " ms");

// Confirm the iterator visited all elements
            if (iteratorCount != size) {
                System.out.println("❌ Error: Iterator did not traverse all elements.");
            }

// Traverse the list using the get(index)
            startTime = System.currentTimeMillis();
            int getCount = 0;
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
                getCount++;
            }
            endTime = System.currentTimeMillis();
            System.out.println("get(index) traversal time: " + (endTime - startTime) + " ms\n");

// Confirm the get(index) visited all elements
            if (getCount != size) {
                System.out.println("❌ Error: get(index) did not traverse all elements.");
            }
        }
    }
}

/**
 * Results:
 * 
 * When working with 50,000 elements, the Iterator traversal finished in just a few milliseconds while the get(index) traversal was much slower. The traversal took over 1000 milliseconds.

 * When the program tested with 500,000 elements, the Iterator traversal remained consistent taking about 6-7 milliseconds, but the get(index) traversal became very, very slow. 
 * It took over 100,000 milliseconds to finish during each run.
 * 
 * Observations:
 *  
 * In working with this assignment, it shows that the Iterator is faster than using the get(index). Since the get(index) needs to go back to the beginning of the list to find each element, 
 * it will take more time to finish as opposed to the Iterator, which can move linearly through the nodes. Having two different element set sizes to test really showed how the size of the data can affect the performance time with get(index).
 * As the test size increases, the time increase could be staggering.
 */