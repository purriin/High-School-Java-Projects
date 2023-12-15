package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-15
  * Description: Program will add all the numbers given by the user
  * Notes: Uses for loops.
  */
public class Average {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("How many numbers are you adding?");
        int number = input.nextInt();
        int counter = 1;
        int total = 0;
        
        if (number <= 0) {
            System.out.println("Invaid input.");
            System.exit(0);
        }
                
        while (counter <= number) {
            System.out.println("Enter number " + counter);
            int num = input.nextInt();
            
            System.out.println(" ");
            total = total + num;
            System.out.println("total = " + total);
            counter = counter + 1;
        }
    }//end of main
}//end of Average