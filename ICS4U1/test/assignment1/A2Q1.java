package assignment1;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-14
  * Description: This program scans scarlet.txt and provides the user with a txt file of the frequency of each letter in the file
  * Notes: The locations for each file must change if you are using a different computer.
  */

public class A2Q1 {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        ArrayList <String> scarletLines = new ArrayList<String>();
        String [] letters = new String [26]; // useful for printing in the 3rd method
        letters[0] = "A";
        letters[1] = "B";
        letters[2] = "C";
        letters[3] = "D";
        letters[4] = "E";
        letters[5] = "F";
        letters[6] = "G";
        letters[7] = "H";
        letters[8] = "I";
        letters[9] = "J";
        letters[10] = "K";
        letters[11] = "L";
        letters[12] = "M";
        letters[13] = "N";
        letters[14] = "O";
        letters[15] = "P";
        letters[16] = "Q";
        letters[17] = "R";
        letters[18] = "S";
        letters[19] = "T";
        letters[20] = "U";
        letters[21] = "V";
        letters[22] = "W";
        letters[23] = "X";
        letters[24] = "Y";
        letters[25] = "Z";
        readText(scarletLines);
        int [] frequency = frequencies(scarletLines);
        boolean correctInput = false;
        
        while(!correctInput) { // loops until user gives the correct input
            try {
                System.out.println("Would you like to output the frequencies of scarlet.txt? (y/n) ");
                String option = input.nextLine();
                
                if (option.equalsIgnoreCase("y")) {
                    outputFrequencies(scarletLines, frequency, letters);
                    correctInput = true;
                }
                else if (option.equalsIgnoreCase("n")){
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid entry. Please try again.");
                } // end of if
            }
            catch (Exception e) {
                input.nextLine();
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop

    } // end of main
    
    public static ArrayList readText (ArrayList scarletLines) throws IOException{
        Scanner reader = new Scanner (new File("C:\\JavaFolder\\scarlet.txt"));
        
        while(reader.hasNext()) { // reads each line and adds it to a String
            scarletLines.add (reader.nextLine());
        }
        
        return scarletLines;
    } // end of readText
    
    public static int[] frequencies (ArrayList scarletLines) {
        int [] frequency = new int [26];
        String line;
        String condition;
        
        for (int i = 0; i < scarletLines.size(); i++) {
            line = (String)scarletLines.get(i);
            for (int j = 0; j < line.length(); j++) {
                condition = "" + line.charAt(j);
                if (condition.equalsIgnoreCase("a")) { // these else if statements find out which letter in present in each specific index
                    frequency[0] = frequency [0] + 1; // adds one to the frequency array (specific index for each letter)
                }
                else if (condition.equalsIgnoreCase("b")) {
                    frequency[1] = frequency [1] + 1;
                }
                else if (condition.equalsIgnoreCase("c")) {
                    frequency[2] = frequency [2] + 1;
                }
                else if (condition.equalsIgnoreCase("d")) {
                    frequency[3] = frequency [3] + 1;
                }
                else if (condition.equalsIgnoreCase("e")) {
                    frequency[4] = frequency [4] + 1;
                }
                else if (condition.equalsIgnoreCase("f")) {
                    frequency[5] = frequency [5] + 1;
                }
                else if (condition.equalsIgnoreCase("g")) {
                    frequency[6] = frequency [6] + 1;
                }
                else if (condition.equalsIgnoreCase("h")) {
                    frequency[7] = frequency [7] + 1;
                }
                else if (condition.equalsIgnoreCase("i")) {
                    frequency[8] = frequency [8] + 1;
                }
                else if (condition.equalsIgnoreCase("j")) {
                    frequency[9] = frequency [9] + 1;
                }
                else if (condition.equalsIgnoreCase("k")) {
                    frequency[10] = frequency [10] + 1;
                }
                else if (condition.equalsIgnoreCase("l")) {
                    frequency[11] = frequency [11] + 1;
                }
                else if (condition.equalsIgnoreCase("m")) {
                    frequency[12] = frequency [12] + 1;
                }
                else if (condition.equalsIgnoreCase("n")) {
                    frequency[13] = frequency [13] + 1;
                }
                else if (condition.equalsIgnoreCase("o")) {
                    frequency[14] = frequency [14] + 1;
                }
                else if (condition.equalsIgnoreCase("p")) {
                    frequency[15] = frequency [15] + 1;
                }
                else if (condition.equalsIgnoreCase("q")) {
                    frequency[16] = frequency [16] + 1;
                }
                else if (condition.equalsIgnoreCase("r")) {
                    frequency[17] = frequency [17] + 1;
                }
                else if (condition.equalsIgnoreCase("s")) {
                    frequency[18] = frequency [18] + 1;
                }
                else if (condition.equalsIgnoreCase("t")) {
                    frequency[19] = frequency [19] + 1;
                }
                else if (condition.equalsIgnoreCase("u")) {
                    frequency[20] = frequency [20] + 1;
                }
                else if (condition.equalsIgnoreCase("v")) {
                    frequency[21] = frequency [21] + 1;
                }
                else if (condition.equalsIgnoreCase("w")) {
                    frequency[22] = frequency [22] + 1;
                }
                else if (condition.equalsIgnoreCase("x")) {
                    frequency[23] = frequency [23] + 1;
                }
                else if (condition.equalsIgnoreCase("y")) {
                    frequency[24] = frequency [24] + 1;
                }
                else if (condition.equalsIgnoreCase("z")) {
                    frequency[25] = frequency [25] + 1;
                } // end of if
            }
        } // end of loop

        return frequency;
    } // end of frequencies

    public static void outputFrequencies(ArrayList scarletLines, int[] frequency, String[] letters) throws IOException{
        PrintWriter writer = new PrintWriter(new File ("C:\\JavaFolder\\frequencies.txt"));
        int initial = 0;
        int [] max = new int [26];
        int [] index = new int [26];
        String order = "";

        for (int i = 0; i < 26; i++) {  // this loop ranks the frequencies from highest to lowest and adds them to a String
            for (int j = 0; j < 26; j++) {
                if (frequency[j] > max [i]) {
                    max [i] = frequency [j];
                    index [i] = j;
                    
                }//end of if
            }//end of loop 2
            frequency[index[i]] = 0;
            order = (order + letters[index[i]] + ": " + max[i] + "\t");
        }//end of loop 1
        writer.println (order);
        
        writer.println ("\n" + "Top 5 Letters:");
        writer.println(letters[index[0]] + " = " + max[0]); // for some reason, on the school computer "\n" doesn't work in when using writer.println
        writer.println(letters[index[1]] + " = " + max[1]); // (it works at home but not at school) So I separated all the lines instead just in case
        writer.println (letters[index[2]] + " = " + max[2]);
        writer.println(letters[index[3]] + " = " + max[3]);
        writer.println(letters[index[4]] + " = " + max[4]);
        
        writer.println();
        
        writer.println ("\n" + "Bottom 5 Letters:");
        writer.println(letters[index[21]] + " = " + max[21]);
        writer.println(letters[index[22]] + " = " + max[22]);
        writer.println (letters[index[23]] + " = " + max[23]);
        writer.println(letters[index[24]] + " = " + max[24]);
        writer.println(letters[index[25]] + " = " + max[25]);
        writer.close();
        
    } // end of outputFrequencies
    
} // end of A2Q1
