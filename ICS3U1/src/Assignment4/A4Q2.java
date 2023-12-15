package Assignment4;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-05-04
  * Description: This program will roll 2 dice and adds the total, system will exit on user request
  * Notes: Uses a number generator and loops.
  */
public class A4Q2 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        Random generator = new Random();
        String roll = "y";
        int counter = 1;
        
        while(counter >= 1) {
            System.out.println("Enter ‘y’ to roll dice. Type ‘n’ to quit.");
            roll = input.nextLine();
            
            if(roll.equals("y")) {
                int dice1 = generator.nextInt(6);
                int dice2 = generator.nextInt(6);
                
                dice1 = dice1 + 1;
                dice2 = dice2 + 1;
                
                System.out.println("Roll #" + counter + "\n" + "Dice #1 = " + dice1 + "\n" + "Dice #2 = " + dice2 + "\n" + "Total = "+ (dice1+dice2) + "\n");
                counter = counter + 1;
            }
            else if (roll.equals("n")) {
                System.out.println("Program exiting...");
                System.exit(0);
            }
            else {
                System.out.println("Invalid input. Please try again." + "\n");
            }//end of if
        }//end of loop
    }//end of main
}//end of A4Q2
