package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-21
  * Description: Program uses user input and calculates the sum and average with each number and will exit with -1
  * Notes: Uses loops.
  */
public class Average2 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        int sum = 0;
        int counter = 1;
        while(value != -1) {
            System.out.println("Enter a positive integer or ‘-1’ to quit:");
            value = input.nextInt();
            if (value == -1) {
                break; 
            }
            else {
                sum = sum + value;
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + (sum/counter));
                counter = counter + 1;
            } // end if
        } // end of loop
    }//end of main
}//end of Average2
