package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-24
  * Description: This program prompts the user to enter a number, program prints out what numbers are divisible by the user inputted number
  * Notes: Uses arrays.
  */

public class DivisibleNumbers {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        int[] array = new int[50];
        int count = 0;
        Random generator = new Random();
        
        System.out.println("Array Numbers:" + "\n");
        
        for (int counter = 1; counter < 50; counter++) {
            array[count] = generator.nextInt(99);
            System.out.print(array[count] + " ");
            array[count] = array[count] + 1;
            count = count+1;
        }//end of loop
        
        System.out.println("\n" + "\n" + "Please input a number from 1-10.");
        int factor = input.nextInt();
        
        if (factor>10 || factor<=0) {
            System.out.println("Invalid entry.");
            System.exit(0);
        }//end of if
        
        count = 0;
        int divisible;
        
        for (int counter = 1; counter < 50; counter++) {
            divisible = array[count]%factor;
            if(divisible==0) {
                System.out.print(array[count] + " ");
            }
            count = count+1;
        }//end of loop
        
    }//end of main
    
}//end of DivisibleNumbers
