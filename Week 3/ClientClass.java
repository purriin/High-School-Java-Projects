package week3;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-27
  * Description: Uses Student class
  * Notes: Modularity.
  */

public class ClientClass {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Create a student");
        Student s1;
        s1 = new Student();
        s1.setName("");

        int loop = 1;
        while (loop == 1) {
            
            System.out.println("'Name' - Add name to student." + "\t\t\t\t" + "'GetName' - Prints out name.");
            System.out.println("'Test' - Add test mark to student." + "\t\t\t" + "'GetTest' - Prints out marks.");
            System.out.println("'Average' - Prints average of student's marks." + "\t\t" + "'HighMark' - Prints out the highest mark.");
            System.out.println("'Info' - Prints out all of the student's information.");
            String option = input.nextLine();

            if (option.equalsIgnoreCase("name")) {
                System.out.println();
                name(s1);
            }
            else if (option.equalsIgnoreCase("getname")) {
                System.out.println();
                getName(s1);
            }
            else if (option.equalsIgnoreCase("test")) {
                System.out.println();
                test(s1);
            }
            else if (option.equalsIgnoreCase("gettest")) {
                System.out.println();
                getTest(s1);
            }
            else if (option.equalsIgnoreCase("average")) {
                System.out.println();
                average(s1);
            }
            else if (option.equalsIgnoreCase("highmark")) {
                System.out.println();
                highMark(s1);
            }
            else if (option.equalsIgnoreCase("info")) {
                System.out.println();
                info(s1);
            }
            else {
                System.out.println();
                System.out.println("Invalid entry.");
                System.exit(0);
            } // end of if
        } // end of loop
    } // end of main

    public static Student name(Student s1) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Please enter a name for this student.");
        String name = input.nextLine();
        s1.setName(name);
        System.out.println();
        return s1;
    } // end of name

    public static void getName(Student s1) {
        System.out.println("Name: " + s1.getName());
        System.out.println();
    } // end of getName

    public static Student test(Student s1) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Which test is being recorded?");
        int num = input.nextInt();
        System.out.println("What is the mark for this test?");
        int mark = input.nextInt();
        s1.setScore(num, mark);
        System.out.println();
        return s1;
    } // end of test

    public static void getTest(Student s1) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("Which test are you looking for?");
        int num = input.nextInt();
        System.out.println("Test: " + s1.getScore(num));
        System.out.println();
    } // end of getTest

    public static void average(Student s1) {
        System.out.println("Average: " + s1.getAverage());
        System.out.println();
    } // end of average

    public static void highMark(Student s1) {
        System.out.println("Highest Mark: " + s1.getHighScore());
        System.out.println();
    } // end of highMark

    public static void info(Student s1) {
        System.out.println(s1.toString());
        System.out.println();
    } // end of info
    
} // end of ClientClass
