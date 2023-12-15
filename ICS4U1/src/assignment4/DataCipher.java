package assignment4;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-11-09
  * Description: this class will create a DataCipher object in FinalProject
  * Notes: N/A.
  */

public class DataCipher { // defines instance variables
    private int caesarCipherShift;
    
    String [] capital = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] lower = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    // Array of letters so it is easier to compare chars
    // way better than using if statements to find specific chars
    
    public DataCipher() { // constructor method 1
        caesarCipherShift = 0;
    }
    
    public DataCipher(int a) { // constructor method 2
        caesarCipherShift = a;
    }
    
    public String encrypt(String message) {
        String encoded = "";
        
        for (int i = 0; i < message.length(); i++) {
            String character = "" + message.charAt(i); // takes in char
            int index = search(capital, lower, character); // determines whether it is capital, lower or misc
            
            if (index <= 25 && index >= 0) { // if it is lower case, this if statement is used
                index = index + caesarCipherShift;
                
                while (index > 25) { // just incase the shift is way way higher than length of the array
                    index = index - 26;
                }
                
                encoded = encoded + lower[index];
            }
            else if (index > 25) { // if it is upper case, this if statement is used
                index = index - 26;
                index = index + caesarCipherShift;
                
                while (index > 25) { // just incase the shift is way way higher than length of the array
                    index = index - 26;
                }
                
                encoded = encoded + capital[index];
            }
            else if (index == -30) { // if it is misc, this if statement is used
                encoded = encoded + message.charAt(i);
            }
        } // end of loop
        return encoded;
    } // end of encrypt
    
    public String decrypt(String code) {
        String decoded = "";
        for (int i = 0; i < code.length(); i++) { // same algorithm as the encrypt method except caesarCipherShift is subtracted
            String character = "" + code.charAt(i);
            int index = search(capital, lower, character);
            
            if (index <= 25 && index >= 0) {
                index = index - caesarCipherShift;
                while (index < 0) {
                    index = index + 26;
                } // end of loop
                decoded = decoded + lower[index];
            }
            else if (index > 25) {
                index = index - 26;
                index = index - caesarCipherShift;
                while (index < 0) {
                    index = index + 26;
                } // end of loop
                decoded = decoded + capital[index];
            }
            else if (index == -30) {
                decoded = decoded + code.charAt(i);
            }
        } // end of loop
        return decoded;
    } // end of decrypt
    
    public String encryptFile(String inFile) throws IOException{
        System.out.println("Where would you like the file to be outputted? (Ex. 'C:\\\\' or 'C:\\\\FolderName\\\\')");
        Scanner input = new Scanner (System.in);
        String output = input.nextLine();
        output = output + "encoded.txt";
        PrintWriter writer= new PrintWriter(new File(output));
        System.out.println("Please wait. Depending on the file size, this may take a few seconds.");
        String encrypted = encrypt(inFile); // uses encrypt method to encrypt the whole string
        writer.println(encrypted);
        writer.close();
        return encrypted;
    } // end of encryptFile
    
    public String decryptFile(String inFile) throws IOException{
        System.out.println("Where would you like the file to be outputted? (Ex. 'C:\\\\' or 'C:\\\\FolderName\\\\')");
        Scanner input = new Scanner (System.in);
        String output = input.nextLine();
        output = output + "decoded.txt";
        PrintWriter writer= new PrintWriter(new File(output));
        System.out.println("Please wait. Depending on the file size, this may take a few seconds.");
        String decrypted = decrypt(inFile); // uses decrypt method to decrypt the whole string
        writer.println(decrypted);
        writer.close();
        return decrypted;
    } // end of decryptFile
    
    public int search (String [] capital, String[] lower, String searchValue) { // compares char to lowercase letters
        int left = 0;
        int right = capital.length - 1;
        while (left <= right) { // compares char to lower case letters
            int midpoint = (left+right)/2;
            int result = ((Comparable)lower[midpoint]).compareTo(searchValue);
            if (result == 0) {
                return midpoint;
            }
            else if (result<0) {
                left = midpoint + 1;
            }
            else {
                right = midpoint - 1;
            }
        } // end of binary search
        
        left = 0;
        right = capital.length - 1;
        while (left <= right) { // compares char to upper case letters
            int midpoint = (left+right)/2;
            int result = ((Comparable)capital[midpoint]).compareTo(searchValue);
            if (result == 0) {
                midpoint = midpoint + 26;
                return midpoint;
            }
            else if (result<0) {
                left = midpoint + 1;
            }
            else {
                right = midpoint - 1;
            }
        } // end of binary search
        return -30; // if misc, index is -30
    } // end of search   
    
} // end of DataCipher

