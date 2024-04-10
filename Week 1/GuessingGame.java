package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-17
  * Description: This program is a guessing game where the program generates a number and the user tries to guess what the number is
  * Notes: Uses loops and number generators.
  */

public class GuessingGame {
    public static void main(String[] args) {
        int randomValue;
        Random generator = new Random();
        randomValue = generator.nextInt(99);
        randomValue = randomValue + 1; //adds 1 so the number will never be 0
        
        Scanner input = new Scanner (System.in);
        int counter = 0;
        String condition = "y";//condition starts as y to start the loop
        
        while(condition.equals("y")) {
            System.out.println("Would you like to play guess the number? (y/n)");
            condition = input.next();
            
            if (condition.equals("y")) {
                counter = counter+1;
                System.out.println("Please enter a number from 1 to 100.");
                int guess = input.nextInt();
        
                if (randomValue>guess && guess>0 && guess<=100){
                    System.out.println("Try again. Your guess was less than the actual value!");
                }
                else if (randomValue<guess && guess>0 && guess<=100) {
                    System.out.println("Try again. Your guess was more than the actual value!");
                }
                else if (randomValue==guess && guess>0 && guess<=100) {
                    System.out.println("Good job! You guessed correctly!");
                    System.out.println("Number of Attempts: " + counter);
                    
                    System.out.println("\n" +"Would you like to start over? (y/n)");
                    String restart = input.next();
                    
                     if (restart.equals("y")) {
                         randomValue = generator.nextInt(99);
                         randomValue = randomValue + 1;
                         counter = 0;
                     }//generates a new number and then goes back to the start of the loop
                     else if (restart.equals("n")) {
                         break;
                     }
                     else {
                         System.out.println("Invalid entry.");
                         break;
                     }//end of if 3
                }
                
                else {
                    System.out.println("Invalid entry.");
                }
            }//end of if 2
            
            else if (condition.equals("n")){
                System.out.println("Number of Attempts: " + counter);
                break;
            }// end of if 1
            
        }//end of loop
        
    }//end of main
    
}//end of GuessingGame
