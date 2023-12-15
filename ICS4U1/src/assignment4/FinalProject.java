package assignment4;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-11-09
  * Description: This program will encrypt and decrypt messages and files
  * Notes: For files like scarlet.txt, this program will take a few seconds to process it.
  */

public class FinalProject {
    public static void main (String[] args) throws IOException{
        Scanner input = new Scanner (System.in);
        
        int loop = 1;
        while (loop == 1) { // will not end unless user prompts for it
            System.out.println("\n" + "What would you like to do?" + "\n" +
                               "'1' - Encrypt message" + "\t\t" + "'3' - Encrypt file" + "\n" +
                               "'2' - Decrypt message" + "\t\t" + "'4' - Decrypt file" + "\n" +
                               "'0' - Exit" + "\n");
           try { // main menu
                int option = input.nextInt();

                if (option == 1) {
                    System.out.println();
                    encryptMessage();
                }
                else if (option == 2) {
                    System.out.println();
                    decryptMessage();
                }
                else if (option == 3) {
                    System.out.println();
                    encryptFile();
                }
                else if (option == 4) {
                    System.out.println();
                    decryptFile();
                }
                else if (option == 0) {
                    break;
                }
                else {
                    System.out.println("\nInvalid input. Please try again.\n");
                } 
           }
           catch (Exception e) { // if an error is made in one of the methods, it goes back to the main method
               System.out.println("Invalid entry.");
               input.next();
           }
        } // end of loop
        
    } // end of main

    public static void encryptMessage() {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the message.");
        String message = input.nextLine();
        System.out.println("What is the Caesar cipher shift?");
        try {// just in case a non integer input is inputted
            int shift = input.nextInt();
            DataCipher cipher = new DataCipher (shift);
            System.out.println(cipher.encrypt("\n" + message));
        }
        catch (Exception e) {
            System.out.println("Invalid entry. Inputted value was not an integer.");
        }
    } // end of encryptMessage

    public static void decryptMessage() {
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the message.");
        String message = input.nextLine();
        System.out.println("What is the Caesar cipher shift?");
        try { // just in case a non integer input is inputted
            int shift = input.nextInt();
            DataCipher cipher = new DataCipher (shift);
            System.out.println(cipher.decrypt("\n" + message));
        }
        catch (Exception e) {
            System.out.println("Invalid entry. Inputted value was not an integer.");
        }
    } // end of decryptMessage

    public static void encryptFile() throws IOException{
        Scanner input = new Scanner (System.in);
        
        ArrayList <String> lines = new ArrayList <String> ();
        System.out.println("Please enter the file path for the file you want to encrypt.");
        String fileName = input.nextLine();
        Scanner reader = new Scanner (new File (fileName));
        System.out.println("What is the Caesar cipher shift?");
        int shift = input.nextInt();
        DataCipher cipher = new DataCipher (shift);

        while (reader.hasNext()) { // reads the file and puts the lines into a ArrayList
            lines.add(reader.nextLine());
        } // end of loop

        String encrypted = "";
        for (int i = 0; i < lines.size(); i++) {
            encrypted = encrypted + lines.get(i) + "\n";
        } // end of loop

        cipher.encryptFile(encrypted);
        System.out.println("Successfully encrypted.");

    } // end of encryptFile

    public static void decryptFile() throws IOException{
        Scanner input = new Scanner (System.in);
        
        ArrayList <String> lines = new ArrayList <String> ();
        System.out.println("Please enter the file path for the file you want to decrypt.");
        String fileName = input.nextLine();
        Scanner reader = new Scanner (new File (fileName));
        System.out.println("What is the Caesar cipher shift?");
        int shift = input.nextInt();
        DataCipher cipher = new DataCipher (shift);

        while (reader.hasNext()) { // reads the file and puts the lines into a ArrayList
            lines.add(reader.nextLine());
        } // end of loop

        String decrypted = "";
        for (int i = 0; i < lines.size(); i++) {
            decrypted = decrypted + lines.get(i) + "\n";
        } // end of loop

        decrypted = cipher.decryptFile(decrypted);
        System.out.println("Successfully decrypted.");

    } // end of decryptFile
    
} // end of FinalProject
