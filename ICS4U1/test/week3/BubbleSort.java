package week3;
import java.util.Random;

/**
  * Name: Shannon Jones
  * Date: 2020-10-26
  * Description: Random array is sorted
  * Notes: uses Selection Sorting.
  */

public class BubbleSort {
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
        
        int k = 0;
        boolean exchangeMade = true;
        
        while((k < array.length - 1) && exchangeMade) {
            exchangeMade = false;
            k++;
            for (int j = 0; j < array.length - k; j++) {
                if (array[j] > array[j+1]) {
                    swap (array, j, j+1);
                    exchangeMade = true;
                }
            }
        }
        list = "";
        for (int i = 0; i < 50; i++) {
            list = list + array[i] + ", ";
        }
        System.out.println(list);
        
    } // end of main
    
    public static void swap(int[] array, int x, int y) {
        int temp = array [x];
        array[x] = array[y];
        array[y] = temp;
        
    } // end of swap
    
} // end of BubbleSort

