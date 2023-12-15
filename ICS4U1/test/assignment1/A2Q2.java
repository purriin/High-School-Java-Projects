package assignment1;
import java.util.*;
import java.io.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-14
  * Description: This program scans raw_marks.txt, calculates averages, and creates a report card for each student.
  * Notes: The locations for each file must change if you are using a different computer.
  */

public class A2Q2 {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        ArrayList <String> lines = new ArrayList<String>();
        ArrayList <Double> marks = new ArrayList<Double>();
        ArrayList <String> names = new ArrayList<String>();
        ArrayList <Integer> averageS = new ArrayList<Integer>();
        ArrayList <Integer> averageC = new ArrayList<Integer>();
        
        readText(lines);
        findMarks(lines, marks);
        findNames(lines, names);
        studentAverage(marks, averageS);
        classAverage(marks, averageC);
        outputReport(marks, names, averageS, averageC);
        
    } // end of main

    public static ArrayList readText(ArrayList lines) throws IOException {
        Scanner reader = new Scanner (new File("C:\\JavaFolder\\raw_marks.txt"));
        
        while(reader.hasNext()) { // reads each line and adds it to a String
           lines.add (reader.next());
        }
        return lines;
    } // end of readText
    
    public static ArrayList findMarks(ArrayList lines, ArrayList marks) {
        String copy = "";
        String condition = "";
        String previous = "";
        String convert = "";
        int x = 0;
        for (int i = 1; i < lines.size(); i++) {
            copy = (String)lines.get(i);
            for (int j = 0; j <= copy.length(); j++) {
                if (j == copy.length()) { // if statement used to determine whether it is at the end of a line
                    condition = " "; // there is always a number at the end so this change tells the program to find this number
                }
                else if (j < copy.length()) {
                    condition = "" + copy.charAt(j);
                } 
                // only if the previous char was a number will the next if statement execute
                if (previous.equals("1") || previous.equals("2") || previous.equals("3") || previous.equals("4") || previous.equals("5") || previous.equals("6") || previous.equals("7") || previous.equals("8") || previous.equals("9") || previous.equals("0")) { 
                    x = x + 1; // calculates how long a number is (Whether its 2 digits or 3)
                    if (!condition.equals("1") && !condition.equals("2") && !condition.equals("3") && !condition.equals("4") && !condition.equals("5") && !condition.equals("6") && !condition.equals("7") && !condition.equals("8") && !condition.equals("9") && !condition.equals("0") && x > 1) {
                        // if the current char is not a number, and x > 0, the program will find the number
                        convert = copy.substring((j - x), j); // x is used to find how long the number is (Since one student has 3 digits in their marks)
                        marks.add (Integer.parseInt(convert)); // converts String into an int
                        x = 0;
                    }
                    
                } // end of if
                previous = condition; // set equal to condition at the end so at the start of the loop, it contains the previous char
            }
        } // end of loop
        return marks;
    } // end of FindMarks
    
    public static ArrayList findNames(ArrayList lines, ArrayList names) {
        String copy;
        String condition = "";
        String previous = "";
        String title;
        int x = -1;   
        
        for (int i = 1; i < lines.size(); i++) {
            copy = (String)lines.get(i); // separates each line in the array list
            for (int j = 0; j < copy.length(); j++) {
                condition = "" + copy.charAt(j);
                if (!previous.equals("1") && !previous.equals("2") && !previous.equals("3") && !previous.equals("4") && !previous.equals("5") && !previous.equals("6") && !previous.equals("7") && !previous.equals("8") && !previous.equals("9") && !previous.equals("0") && !previous.equals(" ") && !previous.equals("\t")) { 
                    x = x + 1; // for each letter in the name, 1 is added to x. This is so that each name can be properly separated from the rest of the string
                    if (condition.equals("\t") || condition.equals(" ")  && x > 1) { // once the program finds the end of the name, this if statement occurs 
                        title = copy.substring((j-x), j); // name is separated and placed in this variable
                        names.add (title);
                        x = 0;
                    } // end of if
                } // end of if
                previous = condition; // set equal to condition at the end so at the start of the loop, it contains the previous char
            }
        } // end of loop
        return names;
    } // end of findNames

    public static ArrayList studentAverage(ArrayList marks, ArrayList averageS) {
        int index = 0;
        int copy;
        double sum = 0;
        int average;
        for (int i = 0; i < 20; i++) { // calculates each student average
            for (int j = 0; j < 4; j++) {
                copy = (int)marks.get(index);
                sum = sum + copy;
                index = index + 1;
            }
            average =(int) (sum/4);
            averageS.add(average);
            sum = 0;
        }
        
        return averageS;
    } // end of studentAverage

    public static ArrayList classAverage(ArrayList marks, ArrayList<Integer> averageC) {
        int index = 0;
        int copy;
        double sum = 0;
        int average;
        int next = 1;
        for (int i = 0; i < 4; i++) { // calculates the class subject average
            for (int j = 0; j < 20; j++) {
                copy = (int)marks.get(index);
                sum = sum + copy;
                index = index + 4;
            }
            average =(int) (sum/20);
            averageC.add(average);
            sum = 0;
            index = next;
            next = next + 1;
        }
        return averageC;
    } // end of classAverage

    public static void outputReport(ArrayList marks, ArrayList names, ArrayList averageS, ArrayList averageC) throws IOException{
        int lastName = 1;
        int firstName = 0;
        int index = 0;
        int averageIndex = 0;
        String fileName = "";
        
        for (int i = 0; i < 20; i++) { //loops for all 20 students
            fileName = "C:\\JavaFolder\\" + names.get(lastName) + ".txt";
            PrintWriter writer = new PrintWriter(new File (fileName));
            
            writer.println("Student Name: " + names.get(lastName) + ", " + names.get(firstName));
            lastName = lastName + 2;
            firstName = firstName + 2;
            writer.println("Average Mark: " + averageS.get(i) + "\n");
            writer.println("Course:" + "\t\t" + "Final Mark:" + "\t\t" + "Course Average:");
            writer.println("======" + "\t\t" + "==========" + "\t\t" + "==============");
            writer.println("Math:" + "\t\t" + marks.get(index) + "\t\t\t" + averageC.get(averageIndex));
            writer.println("English:" + "\t" + marks.get(index + 1) + "\t\t\t" + averageC.get(averageIndex + 1));
            writer.println("Science:" + "\t" + marks.get(index + 2) + "\t\t\t" + averageC.get(averageIndex + 2));
            writer.println("Art:" + "\t\t" + marks.get(index + 3) + "\t\t\t" + averageC.get(averageIndex + 3));
            index = index + 4;
            writer.close();
        }//end of loop
        
        System.out.println("The report cards have been outputted successfully.");
        
    } // end of outputReport

} // end of A2Q2
