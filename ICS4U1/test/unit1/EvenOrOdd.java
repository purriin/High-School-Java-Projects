package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-16
  * Description: This program calculates whether a number is odd or even
  * Notes: Uses else if statements.
  */

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a number.");
        int x = input.nextInt();
        
        if (x%2 == 0) {
            System.out.println("This number is even.");
        }
        else {
            System.out.println("This number is odd.");
        }
    }//end of main
}//end of EvenorOdd
