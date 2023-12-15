package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-07
  * Description: This program will ask the user for 5 words and place them together with a space in between them
  * Notes: This program uses while loops.
  */
public class Words {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("How many words would you like to print out?");
        int words = input.nextInt();
        int counter = 1;
        String sentence = "";
        while (counter <= words) {
            System.out.println("Enter word " + counter);
            String word = input.next();
            System.out.println(" ");
            sentence = sentence + word + " ";
            System.out.println(sentence);
            counter = counter + 1;
        }
    }//end of main
}//end of Words
