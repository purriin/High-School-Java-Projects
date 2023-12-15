package week2;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-13
  * Description: Reads a text file with numbers and generates the sum and count
  * Notes: Uses Scanner to read file.
  */

public class TextFileReader {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner (new File("C:\\JavaFolder\\output.txt")); // use the RandomNumbersFile before this program
        
        int count = 0;
        int sum = 0;
        int number;
        String concat = "";
        
        while(reader.hasNext()) {
            number = reader.nextInt();
            sum = sum + number;
            concat = concat + number + "\n";
            count++;
        } // end of loop

        System.out.println(concat);
        System.out.println("There are " + count + " numbers in the file.");
        System.out.println("Sum: " + sum);
    } // end of main
    
} // end of TextFileReader
