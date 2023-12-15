package unit1;
/**
  * Name: Shannon Jones
  * Date: 2020-04-21
  * Description: Creates a multiplication table for up to 12
  * Notes: Uses nested control statements.
  */
public class MultiplicationTable {
    public static void main (String[] args) {
        for(int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.print((i * j) + "\t");
            } // end of loop
        System.out.println();
        } // end of loop 
    }//end of main
}//end of MultiplicationTable
