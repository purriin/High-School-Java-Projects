package week2;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-30
  * Description: This program creates an array list of 50 random numbers, it will remove any numbers divisble by user inputted number
  * Notes: Uses ArrayLists.
  */

public class RandomArrayList {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        Random generator = new Random ();

        ArrayList<Integer> list = new ArrayList<Integer>();
        int randomValue;
        
        for (int i = 0; i<50; i++){
            randomValue = generator.nextInt(99);
            list.add(randomValue + 1);
        }
        
        int loop = 1;
        while (loop == 1) {

           System.out.println(list);  

            System.out.println ("Please enter a number from 1-10." + "\n" + "Enter 0 to end the program.");
            int factor = input.nextInt();
            
            if (factor == 0) {
                break;
            }
            
            int remainder;
            int arraySize = 50;

            for (int i = 0; i < list.size(); i++){
                remainder = list.get(i) % factor;
                if (remainder == 0) {
                    remainder = list.get(i);
                    list.remove(new Integer(remainder));
                }//end of if

                if (list.size() < arraySize) {
                    i = i-1;
                    arraySize = list.size();
                }//end of if
            }//end of for

            System.out.println("");

            System.out.println(list + "\n");
            
        }//end of loop
        
    }// end of main
    
}// end of RandomArrayList