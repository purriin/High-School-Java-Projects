package week2;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-18
  * Description: calculates whether or not the numbers inputted is a magic square
  * Notes: uses 2D arrays.
  */

public class MagicSquare {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        
        int[][] square = new int[4][4];
        
        System.out.println("Please enter 16 numbers.");
        
        int i;
        int j;
        int [] sum = new int [10];
        
        for (i = 0; i < square.length; i++) {
            for (j = 0; j < square[i].length; j++) {
                System.out.println(i + " ," + j);
                square[i][j] = input.nextInt();
            }//end of loop 2
            
        }//end of loop 1
        
        sum[0] = square[0][0]+square[0][1]+square[0][2]+square[0][3];
        sum[1] = square[1][0]+square[1][1]+square[1][2]+square[1][3];
        sum[2] = square[2][0]+square[2][1]+square[2][2]+square[2][3];
        sum[3] = square[3][0]+square[3][1]+square[3][2]+square[3][3];
        
        sum[4] = square[0][0]+square[1][0]+square[2][0]+square[3][0];
        sum[5] = square[0][1]+square[1][1]+square[2][1]+square[3][1];
        sum[6] = square[0][2]+square[1][2]+square[2][2]+square[3][2];
        sum[7] = square[0][3]+square[1][3]+square[2][3]+square[3][3];
        
        sum[8] = square[0][0]+square[1][1]+square[2][2]+square[3][3];
        sum[9] = square[0][3]+square[1][2]+square[2][1]+square[3][0];
        
        if (sum[0] == sum[1] && sum[0] == sum[2] && sum[0] == sum[3] && sum[0] == sum[4] && sum[0] == sum[5] && sum[0] == sum[6] && sum[0] == sum[7] && sum[0] == sum[8] && sum[0] == sum[9]) {
            System.out.println("\n" + "This is a magic square.");
        }
        else {
            System.out.println("This is not a magic square.");
            System.exit(0);
        }//end of if
        
        for (i = 0; i < square.length; i++) {
            for (j = 0; j < square[i].length; j++) {
               System.out.print(square[i][j] + "\t");
            }//end of loop 2
            System.out.println ("");
        }//end of loop 1
        
    }//end of main
    
}//end of MagicSquare
