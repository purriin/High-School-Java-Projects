package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-15
  * Description: This program uses user input to output a numbers multiplications table
  * Notes: uses for loops.
  */
public class Multiplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Input a number that is between 1 and 12.");
        int x = input.nextInt();
        int y = 1;
        
        if (x <= 0 || x > 12) {
            System.out.println("Invalid number.");
            System.exit(0);
        }
        
        for(int i = 1; i <= 12; i++) {
            System.out.println(x + " * " + y + " = " + (x*y));
            y = y+1;
        }
    }//end of main
}//end of Multiplication