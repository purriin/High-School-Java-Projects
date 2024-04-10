package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-22
  * Description: This program removes all vowels from any word inputted
  * Notes: Can remove vowels from sentences as well.
  */

public class EliminateVowels {
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
            
            word = word.replaceAll("a", "");
            word = word.replaceAll("e", "");
            word = word.replaceAll("i", "");
            word = word.replaceAll("o", "");
            word = word.replaceAll("u", "");
            
            System.out.println(word + "\n");
            
        }//end of loop
        
    }//end of main
    
}//end of EliminateVowels
