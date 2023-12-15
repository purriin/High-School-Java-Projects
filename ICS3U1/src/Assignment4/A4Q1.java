package Assignment4;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-05-04
  * Description: This program will check if the user inputted the correct pin using loops
  * Notes: Uses nested control statements and loops. However, pins such as 0001 or 0000 will be recognized as 1 and 0 and the program will consider it invalid.
  */
public class A4Q1 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        int counter = 0;
        int pin = 1000;
        
        while (counter >= 0) {
           System.out.println("Enter your 4-digit number:");
           pin = input.nextInt();
           
           if (pin == 2020) {
               System.out.println("Access granted." + "\n" + "Number of incorrect attempts: " + counter );
               System.exit(0);
           }
           else if (pin <= 999 || pin > 9999) {
               System.out.println("Invalid entry.");
           }
           else {
               System.out.println("Incorrect pin. Access denied.");
               counter = counter + 1;
           }//end of if
        }//end of loop
    }//end of main
}//end of A4Q1
