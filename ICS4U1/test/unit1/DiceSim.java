package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-17
  * Description: This program will simulate the rolling of dice and will produce 2 numbers from 1 to 6
  * Notes: Uses while loops and number generators.
  */

public class DiceSim {
    public static void main(String[] args) {
        

        Scanner input = new Scanner (System.in);
        String condition = "y";
        
        while (condition.equals("y")){ //program will continue until user says "n" or something invalid
        System.out.println("Would you like to roll the dice? (y/n)");
        condition = input.nextLine();
        
        if (condition.equals("y")) {
        Random generator = new Random();
        int dice = 2;
        int randomValue;
        
        for(int i = 1; i <= dice; i++) { //loops twice to give 2 numbers
            randomValue = generator.nextInt(5);
            randomValue = randomValue + 1; // add 1 so value cannot be 0
            System.out.println(randomValue);
        }//end of for loop
        
        }
        
        else if (condition.equals("n")) {
            break;
        }
        
        else {
            System.out.println("Invalid entry.");
            break;
        }//end of if
        
    }//end of while loop
        
    }//end of main
    
}//end of DiceSim