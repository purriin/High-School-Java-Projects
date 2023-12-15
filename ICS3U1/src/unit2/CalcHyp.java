package unit2;
import java.util.*;
import java.math.*;
/**
  * Name: Shannon Jones
  * Date: 2020-09-16
  * Description: This program calculates the hypotenuse of a triangle
  * Notes: Methods.
  */
public class CalcHyp {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        String line = ("y");
        
        while(line.equals("y")) {
            System.out.println("Would you like to make a calculation? (y/n)");
            String Line = input.next();
            
            if (Line.equals("y")) {
            }
            else if (Line.equals("n")) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid input.");
                break;
            }//end of if
            
            System.out.println("\n" + "What is the length of side 1?");
            int h = input.nextInt();
            System.out.println("What is the length of side 2?");
            int b = input.nextInt();
            
            double hypo = calc(h, b);
            System.out.println("\n" + hypo + "\n"); 
            
        }//end of loop
    }//end of main
    
    public static double calc(int h, int b) {
        h = h*h;
        b = b*b;
        double hyp = Math.sqrt(b+h);
        return hyp;
        
    }//end of calc
}//end of CalcHyp
