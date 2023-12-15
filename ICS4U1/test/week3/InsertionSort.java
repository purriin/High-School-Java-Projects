package week3;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-26
  * Description: Random array is sorted
  * Notes: uses Selection Sorting.
  */

public class InsertionSort {
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
        
        int itemToInsert;
        int index;
        boolean stillLooking;
        
        for (int k = 1; k < array.length; k++) {
            itemToInsert = array[k];
            index = k - 1;
            stillLooking = true;
            
            while ((index >= 0) && stillLooking) {
                if (itemToInsert<array[index]) {
                    array[index+1] = array[index];
                    index--;
                }
                else {
                    stillLooking = false;
                }
                array[index + 1] = itemToInsert;
            }
            
        }
        
        list = "";
        for (int i = 0; i < 50; i++) {
            list = list + array[i] + ", ";
        }
        System.out.println(list);
        
    } // end of main
    
} // end of BubbleSort
