package week2;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-10
  * Description: Creates an array list with 50 random numbers, takes in a user inputted number, and divides 
  *                inputted number by each number in the array list
  * Notes: uses Exception Handling.
  */

public class ExceptionHandlingActivity {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        Random generator = new Random ();
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Double> quotientList = new ArrayList<Double>();
        
        for (int i = 0; i < 50; i++) {
            list.add(generator.nextInt(10));
        }
        System.out.println(list);
        
        int x = 0;
        boolean correctInput = false;
        
        while(!correctInput) {
            try {
                System.out.println("Please enter an integer between 1 and 10. ");
                x = input.nextInt();
                
                if(x < 1 || x > 10) {
                    System.out.println("Invalid entry. Please try again.");
                }
                else {
                    correctInput = true;
                } // end of if
            }
            
            catch (Exception e) {
                input.nextLine(); 
                System.out.println("Invalid entry. Please try again.");
            }
            
        } // end of loop
        
        double quotient = 0.0;
        
        for(int i = 0; i < list.size(); i++) {
            try {
                quotient = x/list.get(i); // division of user num by number in Array List
                quotientList.add(quotient);
            }
            catch (Exception e) {
                System.out.println("Index " + i + ": Division by 0.  Result will not be added to results lists.");
            }
        } // end of loop
        
        System.out.println(quotientList);
        
    } // end of main
    
} // end of ExceptionHandlingActivity
