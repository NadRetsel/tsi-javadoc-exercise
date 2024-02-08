package Javadoc_Exercise;

import java.util.Arrays;

/** An un-instantiable (effectively static) class of utility functions for use in various projects.
 * @author Louis Doherty @ The Software Institute
 * @since JDK 21.0.2
 * @version Feb 2024
 */
public class Utils {

    private Utils(){}

    /** A function to determine whether a given number is prime or not in O(n) time.
     * <b>Please note negative numbers cannot be prime.</b>
     * @param toCheck The number to determine the primeness of.
     * @return True if toCheck is prime, false otherwise.
     */
    public static boolean isPrime(int toCheck) {
        if(toCheck < 2) {
            return false;
        }

        for(int i = 2; i < toCheck/2; i++) {
            if(toCheck%i == 0) {
                return false;
            }
        }

        return true;
    }

    /** A function to reverse a String in O(n) time.
     * @param toReverse The String to be reversed.
     * @return Reversed input.
     */
    public static String reverse(String toReverse) {
        StringBuilder returnString = new StringBuilder();

        for(int i = toReverse.length()-1; i >= 0; i--) {
            returnString.append(toReverse.charAt(i));
        }

        return returnString.toString();
    }

    /** A function to binary search an int array in O(log n) time.
     * @param arr The array to search through.
     * @param desiredElement The element to find in the array.
     * @return Index of the element in the array.
     */
    public static int binarySearch(int[] arr, int desiredElement) {
        int startIndex = 0;
        int endIndex = arr.length-1;
        int middle;

        while(true) {
            middle = startIndex+((endIndex-startIndex)/2);

            if(arr[middle] == desiredElement) {
                return middle;
            } else if(startIndex == endIndex) {
                return -1;
            } else {
                if(arr[middle] < desiredElement) {
                    startIndex = middle+1;
                } else {
                    endIndex = middle-1;
                }
            }
        }
    }

    /** An in-place implementation of bubble sort, an O(n^2) sorting algorithm. Sorts into ascending order.
     * @param toSort An array of integer values to be sorted.
     * @return The sorted array.
     */
    //https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/
    //Implementation
    public static int[] BubbleSort(int[] toSort)
    {
        boolean sorted = false;
        while(!sorted)
        {
            sorted = true;
            for(int i = 0; i < toSort.length-1; ++i)
            {
                if(toSort[i] <= toSort[i+1]) continue;

                int temp = toSort[i];
                toSort[i] = toSort[i+1];
                toSort[i+1] = temp;

                sorted = false;
            }
        }

        return toSort;
    }


    /** A function to determine the nth element of the fibonnaci-sequence.
     * @param toFind The number in the sequence we want to find (e.g. the 5th element - not the index).
     * @return The number at that position in the sequence.
     */
    //https://en.wikipedia.org/wiki/Fibonacci_sequence
    //Implementation
    public static int FindFibonacci(int toFind)
    {
        /*
        if(toFind <= 1) return toFind;

        return( FindFibonacci(toFind-1) + FindFibonacci(toFind-2));
        */


        if(toFind < 1) return -1;
        if(toFind == 1) return 0;
        if(toFind == 2) return 1;

        int previous_by_one = 1;
        int previous_by_two = 0;
        int current = previous_by_one + previous_by_two;
        for(int i = 3; i < toFind; ++i)
        {
            previous_by_two = previous_by_one;
            previous_by_one = current;
            current = previous_by_one + previous_by_two;
        }


        return current;

    }

    public static void main(String[] args)
    {
        int[] toSort = {1,4,7,23,6,9,4,2,56,8,3,5,8,3};
        System.out.println(Arrays.toString(BubbleSort((toSort))));

        for(int i = 0; i < 100; ++i) System.out.println(FindFibonacci(i));
    }
}
