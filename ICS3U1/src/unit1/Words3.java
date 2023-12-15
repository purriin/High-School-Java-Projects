package unit1;
import java.util.*;
/**
  * Name: Shannon Jones
  * Date: 2020-04-21
  * Description:
  * Notes:
  */
public class Words3 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        int counter = 1;
        String sentence = "";
        String words = ("");
        
        while (words != "exit") {
            System.out.println("Enter word " + counter);
            words = input.next();
            if (words.equals("exit")) {
                break;
            }
            else {
                System.out.println(" ");
                sentence = sentence + words + " ";
                System.out.println(sentence);
                System.out.println(" ");
                counter = counter + 1;    
            }//end of if
        }//end of loop
    }//end of main
}//end of Words3
