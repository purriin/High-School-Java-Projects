package week2;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-30
  * Description: This program creates an array list of with 5 user inputted words and removes words based on letter count
  * Notes: Uses ArrayLists.
  */

public class WordArrayList {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        ArrayList<String> list = new ArrayList<String>();
        
        System.out.println("Please enter 5 words.");
        System.out.println("1:");
        String a = input.next();
        list.add(a);
        System.out.println("2:");
        String b = input.next();
        list.add(b);
        System.out.println("3:");
        String c = input.next();
        list.add(c);
        System.out.println("4:");
        String d = input.next();
        list.add(d);
        System.out.println("5:");
        String e = input.next();
        list.add(e);
        
        System.out.println("\n" + list + "\n \n" + "What is the maximum word length?");
        int count = input.nextInt();
        int remainder;
        String word;
        int arraySize = 5;
        
        for (int i = 0; i < list.size(); i++){
            word = list.get(i);
            remainder = word.length() - count;
            
            if (remainder > 0) {
                list.remove(new String (word));
            }//end of if

            if (list.size() < arraySize) {
                i = i-1;
                arraySize = list.size();
            }//end of if
           
       }//end of for
        
       System.out.println("\n" + list);
        
    }
    
}
