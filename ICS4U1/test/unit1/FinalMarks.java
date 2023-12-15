package unit1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-24
  * Description: This program prints out user's highest and lowest marks
  * Notes: Uses arrays.
  */

public class FinalMarks {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String[] subject = new String [4];
        int[] mark = new int [4];
        
        System.out.println("Please enter your first course.");
        subject[0] = input.next();
        
        System.out.println("Please enter your final mark for your first course.");
        mark[0] = input.nextInt();
        
        System.out.println("Please enter your second course.");
        subject[1] = input.next();
        
        System.out.println("Please enter your final mark for your second course.");
        mark[1] = input.nextInt();
        
        System.out.println("Please enter your third course.");
        subject[2] = input.next();
        
        System.out.println("Please enter your final mark for your third course.");
        mark[2] = input.nextInt();
        
        System.out.println("Please enter your fourth course.");
        subject[3] = input.next();
        
        System.out.println("Please enter your final mark for your fourth course.");
        mark[3] = input.nextInt();
        
        System.out.println("");
        
        if (mark[0]>mark[1] && mark[0]>mark[2] && mark[0]>mark[3]) {
            System.out.println("Your highest mark was in " + subject[0] + " (" + mark[0] + "%)");
        }
        else if (mark[1]>mark[0] && mark[1]>mark[2] && mark[1]>mark[3]) {
            System.out.println("Your highest mark was in " + subject[1] + " (" + mark[1] + "%)");
        }
        else if (mark[2]>mark[0] && mark[2]>mark[1] && mark[2]>mark[3]) {
            System.out.println("Your highest mark was in " + subject[2] + " (" + mark[2] + "%)");
        }
        else if (mark[3]>mark[0] && mark[3]>mark[2] && mark[3]>mark[1]) {
            System.out.println("Your highest mark was in " + subject[3] + " (" + mark[3] + "%)");
        }//end of if
        
        if (mark[0]<mark[1] && mark[0]<mark[2] && mark[0]<mark[3]) {
            System.out.println("Your lowest mark was in " + subject[0] + " (" + mark[0] + "%)");
        }
        else if (mark[1]<mark[0] && mark[1]<mark[2] && mark[1]<mark[3]) {
            System.out.println("Your lowest mark was in " + subject[1] + " (" + mark[1] + "%)");
        }
        else if (mark[2]<mark[0] && mark[2]<mark[1] && mark[2]<mark[3]) {
            System.out.println("Your lowest mark was in " + subject[2] + " (" + mark[2] + "%)");
        }
        else if (mark[3]<mark[0] && mark[3]<mark[2] && mark[3]<mark[1]) {
            System.out.println("Your lowest mark was in " + subject[3] + " (" + mark[3] + "%)");
        }//end of if
        
        if (mark[0]==mark[1] || mark[0]==mark[2] || mark[0]==mark[3] || mark[1]==mark[2] || mark[1]==mark[3] || mark[2]==mark[3]) {
            System.out.println("Multiple courses have the same mark!");
        }//end of if
        
    }//end of main
    
}//end of FindMarks
