package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-18
  * Description: calculates the sum of all numbers between 2 numbers
  * Notes: uses methods.
  */

public class SumofIntegers {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Please enter the first (lower) number.");
        int first = input.nextInt();
        System.out.println("Please enter the second (higher) number.");
        int second = input.nextInt();
        
        double sum = sumOfInts (first, second);
        System.out.println("The sum of the integers are: " + sum);
    }//end of main
    
    public static double sumOfInts(double first, double second) {
        
        double sum = 0.0;
        
        for(double i = first; i <= second; i++) {

            sum = sum + first;
            first = first + 1;
        }//end of loop
        
        return sum;
        
    }//end of sumOfInts
    
}//end of SumOfIntegers
