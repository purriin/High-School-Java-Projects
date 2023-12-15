package ISU;
import java.util.*;
import java.math.*;
/**
  * Name: Shannon Jones
  * Date: 2020-06-03
  * Description: This program will calculate basic compound interest on loans or investments
  * Notes: Decimal places are not rounded to two decimal places.
  */
public class InterestCalc {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("\t" + "INTEREST CALCULATOR");
        String line = ("y");
        while(!line.equals("exit")) {
            System.out.println("\n" + "Input anything to continue. Input 'exit' to end the program.");
            String exit = input.next();
            if (exit.equals("exit")) {
                System.exit(0);
            }
            else {
            }//end of if
            
            System.out.println("\n" + "Input the principal amount:");
            double P = input.nextDouble();
            
            if (P<=0) { //Looks for any invalid inputs
                System.out.println("Invalid input.");
                System.exit(0);
            }
            else {
            }//end of if
            
            System.out.println("Input the interest rate as a percentage:");
            double i = input.nextDouble();
            
            if (i<=0) { //Looks for any invalid inputs
                System.out.println("Invalid input.");
                System.exit(0);
            }
            else {
            }//end of if
        
            double r = i/100; //converts interest rate to decimal
        
            System.out.println("Input the number of years:");
            double n = input.nextDouble();
            
            if (n<=0) { //Looks for any invalid inputs
                System.out.println("Invalid input.");
                System.exit(0);
            }
            else {
            }//end of if
            
            System.out.println("\n" + "Years:" + "\t" + "Future Value:");
        
            int counter = 1;
                
            while (counter <= n) {
                double A = compoundInterest(P, r, n, counter); //goes to the compoundInterest method
                System.out.println(counter + "\t" + A); //outputs the information
                counter = counter + 1;      
            }//end of loop 2
            
        }//end of loop 1 
        
    }//end of main

    public static double compoundInterest(double P, double r, double n, double counter) { //this method calculates the counpound interest
        double A = P*(Math.pow((1+r),counter));  
        return A; //returns value to the main method
    }//end of compundInterest
    
}//end of InterestCalc
