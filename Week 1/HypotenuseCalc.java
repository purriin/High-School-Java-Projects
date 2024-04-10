package unit1;
import java.util.*;
import java.math.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-21
  * Description: This program calculates the hypotenuse of a user inputted triangle
  * Notes: Uses the math class.
  */

public class HypotenuseCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter side A.");
        int a = input.nextInt();
        System.out.println("Please enter side B.");
        int b = input.nextInt();
        
        if (a<=0 || b<=0) {
            System.out.println("Invalid entry.");
            System.exit(0);
        }//end of if
        
        double h = hypotenuse (a, b);
        System.out.println("\n" + "Side A = " + a + "\n" + "Side B = " + b + "\n" + "Hypotenuse = " + h);
        
    }//end of main
    
    public static double hypotenuse(double a, double b) {
        double h = Math.sqrt((Math.pow(a, 2))+(Math.pow(b, 2)));
        return h;
    }//end of hypotenuse
    
}//end of HypotenuseCalc
