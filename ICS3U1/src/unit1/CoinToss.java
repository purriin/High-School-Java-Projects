package unit1;
import java.util.*;
import java.math.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-29
  * Description: This program will flip a coin a certain number of times based on user input
  * Notes: Uses a random number generator.
  */
public class CoinToss {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("How many times would you like to flip a coin?");
        int flip = input.nextInt();
        if (flip <= 0) {
            System.out.println("Invalid input.");
            System.exit(0);
        }
        Random generator = new Random();
        int randomValue;
        for(int i = 1; i <= flip; i++) {
            randomValue = generator.nextInt(10);
            if (randomValue <= 5) {
                System.out.println("Heads");
            }
            if (randomValue > 5) {
                System.out.println("Tails");
            }//end of if
        }//end of loop
    }//end of main
}//end of CoinToss
