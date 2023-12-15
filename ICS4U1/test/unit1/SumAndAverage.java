package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-18
  * Description: calculates the average of all numbers between 1 and an upperbound number
  * Notes: uses methods.
  */

public class SumAndAverage {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Please enter the upperbound number.");
        int upperbound = input.nextInt();
        int lowerbound = 1;
       
        if (upperbound <= 0) {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        
        double sum = sumOfInts(upperbound, lowerbound);
        
        double average = averageOfInts(sum, upperbound);
        
        System.out.println("The average is: " + average);
    }//end of main
    
    public static double sumOfInts(double upperbound, double lowerbound) {
        
        double sum = 0.0;//must establish variable before the loop so that the sum can be returned
        double counter = 2;
        
        for(int i = 2; i <= upperbound; i++) {//I know theres a formula that can add all the numbers but I thought a loop would be easier
            sum = lowerbound + counter;
            counter = counter+1;//counter increases by 1 so that every number between lowerbound and upperbound can be added
            lowerbound = sum;//lowerbound made equal to sum so that more numbers can be added
        }//end of loop
        
        return sum;
        
    }//end of sumofInts
    
    public static double averageOfInts(double sum, double upperbound) {
        double average = sum/upperbound;
        return average;

    }//end of averageOfInts
        
}//end of SumAndAverage
