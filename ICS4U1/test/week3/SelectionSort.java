package week3;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-26
  * Description: Random array is sorted
  * Notes: uses Selection Sorting.
  */

public class SelectionSort {
    public static void main (String[] args) {
        Random generator = new Random ();
        int [] array = new int [50];
        for (int i = 0; i < 50; i++) {
            array [i] = (generator.nextInt(50) + 1);
        }
        
        String list = "";
        for (int i = 0; i < 50; i++) {
            list = list + array[i] + ", ";
        }
        System.out.println(list);
        
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findMinimum(array, i);
            if (minIndex != 1) {
                swap(array, i, minIndex);
            }
        }

        list = "";
        for (int i = 0; i < 50; i++) {
            list = list + array[i] + ", ";
        }
        System.out.println(list);
        
    } // end of main

    public static int findMinimum(int[] array, int first) {
        int minIndex = first;
        
        for (int i = first + 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    } // end of findMinimum

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        
    } // end of swap
    
} // end of SelectionSort
