package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-16
  * Description: This program places 3 numbers from smallest to largest
  * Notes: Uses else if statements.
  */

public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Please enter the first number.");
        int firstNumber = input.nextInt();
        System.out.println("Please enter the second number.");
        int secondNumber = input.nextInt();
        System.out.println("Please enter the third number.");
        int thirdNumber = input.nextInt();
        
        if (firstNumber<=secondNumber && secondNumber<=thirdNumber) {
            System.out.println(firstNumber + " , " + secondNumber + " , " + thirdNumber);
        }
        
        else if (firstNumber<secondNumber && firstNumber<=thirdNumber && secondNumber>thirdNumber) {
            System.out.println(firstNumber + " , " + thirdNumber + " , " + secondNumber);
        }
        
        else if (firstNumber>secondNumber && secondNumber<thirdNumber && firstNumber<=thirdNumber) {
            System.out.println(secondNumber + " , " + firstNumber + " , " + thirdNumber);
        }
        
        else if (firstNumber>secondNumber && secondNumber<thirdNumber && firstNumber>thirdNumber) {
            System.out.println(secondNumber + " , " + thirdNumber + " , " + firstNumber);
        }
        
        else if (firstNumber<secondNumber && secondNumber>thirdNumber && firstNumber>thirdNumber) {
            System.out.println(thirdNumber + " , " + firstNumber + " , " + secondNumber);
        }
        
        else if (firstNumber>secondNumber && secondNumber>thirdNumber && firstNumber>thirdNumber) {
            System.out.println(thirdNumber + " , " + secondNumber + " , " + firstNumber);
        }
        
    }//end of main
}//end of LargestNumber
