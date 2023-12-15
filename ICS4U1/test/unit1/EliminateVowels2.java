package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-22
  * Description: This program removes all vowels from any word inputted
  * Notes: Can remove vowels from sentences as well.
  */

public class EliminateVowels2 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        int loop = 1;

        while (loop == 1) {
            System.out.println("Type 'exit' to end the program.");
            System.out.println("Please enter a word." + "\n");
            String word = input.nextLine();
            
            if (word.equalsIgnoreCase("exit")) {
                break;
            }//end of if
            
            int letters = word.length();
            int count = 0;

            for (int counter = 1; counter <= letters; counter++) {
                char character;
                character = word.charAt(count);
                count = count+1;
                
                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                    System.out.print("");
                }
                else {
                    System.out.print(character);
                }//end of if

            }//end of for loop
            
            System.out.println("\n");
            
        }//end of while loop  
        
    }//end of main
    
}//end of EliminateVowels2
