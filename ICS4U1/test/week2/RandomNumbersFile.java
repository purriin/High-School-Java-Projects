package week2;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-13
  * Description: Creates a text file with random numbers
  * Notes: Uses PrintWriter.
  */

public class RandomNumbersFile {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        Random generator = new Random();
        PrintWriter writer = new PrintWriter (new File ("C:\\JavaFolder\\output.txt")); //don't forget to make this a folder on the school computer
        
        System.out.println("How many numbers would you like to print?");
        int numbers = input.nextInt();
        int randomNumber;
        
        for (int i = 0; i < numbers; i++) {
            randomNumber = generator.nextInt(99);
            randomNumber = randomNumber + 1;
            writer.println(randomNumber);
        } // end of loop
        
        writer.close();
        
    } // end of main
} // end of RandomNumbersFile
