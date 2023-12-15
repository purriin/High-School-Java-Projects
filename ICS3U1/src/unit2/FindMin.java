package unit2;
import java.util.*;
import java.math.*;
/**
  * Name: Shannon Jones
  * Date: 2020-05-25
  * Description: takes the 3 integer values as parameters and returns the smallest value out of the three
  * Notes: Methods.
  */
public class FindMin {
    public static void main(String[] args) {
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
            
            System.out.println("\n" + "Input the first number.");
            int x = input.nextInt();
            System.out.println("Input the second number.");
            int y = input.nextInt();
            System.out.println("Input the third number.");
            int z = input.nextInt();
            
            double min = calc(x, y, z);
            System.out.println("\n" + min + "\n"); 
            
        }//end of loop
    }//end of main
    
    public static double calc(int x, int y, int z) {
        double min = 0;
        if (x > y && x > z) {
            min = x;
            return min;
        }
        else if (y > x && y > z) {
            min = y;
            return min;
        }
        else if (z > x && z > y) {
            min = z;
            return min;
        }
        else {
            System.out.println("Invalid input. Try inputting all different numbers!");
            return min;
        }//end of if
        
    }//end of calc
}//end of FindMin
