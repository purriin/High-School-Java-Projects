package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-07
  * Description: Program asks user for a number and will print all the numbers between 1 and that number
  * Notes: If a negative number or 0 is entered, the program will exit.
  */
public class EvenNumbers {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Please enter a number that is greater than 0");
        int x = input.nextInt();
        int counter = 1;
        int y = 1;
        
        if (x < 1) {
            System.out.println("Entry invalid.");
            System.exit(0);
        }
        else {
            while (counter <= x) {
                System.out.println(y);
                counter = counter + 1;
                y = y + 1;  
        }
        }
    }//end of main
}//end of EvenNumbers
