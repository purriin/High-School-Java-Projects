package unit1;

/**
  * Name: Shannon Jones
  * Date: 2020-04-06
  * Description: This program will print all numbers in reverse
  * Notes: This uses while loops.
  */
public class Numbers {
    public static void main (String[] args) {
       int counter = 1;
       int x = 1;
       
       while (counter <= 100) {
           System.out.println(x);
           counter = counter+1;
           x = x+1;
       }         
    }//end of main
}//end of Numbers
