package assignment1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-28
  * Description: This program creates an array with random numbers and gives the user options as to what they can do with the array
  * Notes: If you choose to create a new array, it only changes the numbers
  * (In order to change how many columns and rows there are you must restart the program).
  */

public class A1Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        Random generator = new Random();
        
        System.out.println("CREATE A 2D ARRAY" + "\n");

        System.out.println("How many rows should be in the array?"); //The createArray method does not work if everything isn't established first in main
        int x = input.nextInt();
        System.out.println("How many columns should be in the array?");
        int y = input.nextInt();
        
        if (x < 0 || y < 0) //checks to see if the number entered is valid
        {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        
        System.out.println("");
        int[] [] array = new int[x] [y];
        
        int randomValue;
        
        for (int i = 0; i<x; i++){ //generates and prints the array
            for (int j = 0; j<y; j++){
                randomValue = generator.nextInt(100);
                array[i] [j] = randomValue + 1;
                System.out.print(array[i] [j] + "\t");
            }//end of loop 2
            System.out.println("");
        }//end of loop 1
        System.out.println("");

        int loop = 1;
        
        while (loop == 1) { //a continuous loop that can only be ended if the user says to exit or inputs something invalid
            
            System.out.println("What would you like to do?" + "\n" + "'New' - Changes the numbers in the array" + "\t \t" + "'Sum' - Prints the sum of the entire array.");
            System.out.println("'Average' - Prints the average of the entire array." + "\t" + "'Maximum' - Prints the highest number in the array.");
            System.out.println("'Minimum' - Prints the lowest number in the array." + "\t" + "'Row' - Prints the sum of a row in the array.");
            System.out.println("'Column' - Prints the sum of a column in the array."  + "\t" + "'Instances' - Prints the number of instances a given number is found in the array.");
            System.out.println("'Print' - Prints the current array." + "'Exit' - Shut down the program.");
            String option = input.next();
            
            if (option.equalsIgnoreCase("new")) 
            {
                System.out.println("");//just to space out the text
                array = createArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("sum")) 
            {
                System.out.println("");//just to space out the text
                sumOfArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("average")) 
            {
                System.out.println("");//just to space out the text
                averageOfArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("maximum") || option.equalsIgnoreCase("max")) 
            {
                System.out.println("");//just to space out the text
                maxOfArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("minimum") || option.equalsIgnoreCase("min")) 
            {
                System.out.println("");//just to space out the text
                minOfArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("row")) 
            {
                System.out.println("");//just to space out the text
                sumOfRow(array, y, x);
            }
            
            else if (option.equalsIgnoreCase("column")) 
            {
                System.out.println("");//just to space out the text
                sumOfColumn(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("instances")) 
            {
                System.out.println("");//just to space out the text
                instancesInArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("print")) 
            {
                System.out.println("");//just to space out the text
                printArray(array, x, y);
            }
            
            else if (option.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            
            else 
            {
                System.out.println("");//just to space out the text
                System.out.println("Invalid entry.");
                System.exit(0);
            }//end of if
            
        }//end of loop
        
    }//end of main

    public static int[] [] createArray(int array[] [], int x, int y) { //creates array, I just added this method to make it easier to test every method
        Scanner input = new Scanner (System.in);
        Random generator = new Random();

        int randomValue;
        
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                randomValue = generator.nextInt(100); 
                randomValue = randomValue + 1; // so the number is never 0
                array[i] [j] = randomValue;
                System.out.print(array[i] [j] + "\t");
            }//end of loop 2
            System.out.println("");
        }//end of loop 1
        
        System.out.println("");
        return array;
        
    }//end of createArray
    
    public static void sumOfArray(int array[] [], int x, int y) { //calculates the sum
        int sum = 0;
        
        for (int i = 0; i<x; i++) {
            for (int j = 0; j<y; j++) {
                sum = array [i] [j] + sum;
            }//end of loop 2
        }//end of loop 1
        System.out.println("Sum: " + sum + "\n");

    }//end of sumOfArray
    
    public static void averageOfArray(int array[] [], int x, int y) { //calculates the average
        double sum = 0;
        double total = x*y;//the number of numbers in the array
        
        for (int i = 0; i<x; i++) {
            for (int j = 0; j<y; j++) {
                sum = array [i] [j] + sum;
            }//end of loop 2
        }//end of loop 1
        
        double average = sum/total;
        System.out.println("Average: " + average + "\n");

    }//end of averageOfArray
    
    public static void maxOfArray(int array[] [], int x, int y) { // calculates the maximum
        
        int max = 0;
        
        for (int i = 0; i < x; i++) { // goes through each number, if number is bigger than the previous largest number, it becomes equal to max
            for (int j = 0; j < y; j++) {
                if (array[i] [j] > max) {
                    max = array[i] [j];
                }//end of if
            }//end of loop 2
        }//end of loop 1
        
        System.out.println("Maximum Value: " + max + "\n");

    }//end of maxOfArray
    
    public static void minOfArray(int array[] [], int x, int y) { //calculates the minimum
        int min = 101;
        
        for (int i = 0; i < x; i++) { // goes through each number, if number is less than the previous smallest number, it becomes equal to min
            for (int j = 0; j < y; j++) {
                if (array[i] [j] < min) {
                    min = array[i] [j];
                }//end of if
            }//end of loop 2
        }//end of loop 1
        
        System.out.println("Minimum Value: " + min + "\n");

    }//end of minOfArray
    
    public static void sumOfRow(int array[] [], int y, int x) { //calculates the sum of a row
        Scanner input = new Scanner (System.in);
        
        System.out.println("What row would you like to add up?");
        int row = input.nextInt();
        
        if (row < 0 || row > x) //checks to see if the number entered is valid
        {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        
        row = row-1;
        int sum = 0;
        
        for (int i =  0; i < y; i++) {
            sum = array [row] [i] + sum;
        }//end of loop
        
        System.out.println("Sum: " + sum + "\n");

    }//end of sumOfRow
    
    public static void sumOfColumn(int array[] [], int x, int y) { // calculates the sum of a column
        Scanner input = new Scanner (System.in);
        
        System.out.println("What column would you like to add up?");
        int column = input.nextInt();
        
        if (column < 0 || column > y) //checks to see if the number entered is valid
        {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        
        column = column-1;
        int sum = 0;
        
        for (int i =  0; i < x; i++) {
            sum = array [i] [column] + sum;
        }//end of loop
        
        System.out.println("Sum: " + sum + "\n");
        
    }//end of sumOfColumn
    
    public static void instancesInArray(int array[] [], int x, int y) { // finds how many instances of a number there are in the array
        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a number.");
        int number = input.nextInt();
        
        if (number < 0) //checks to see if the number entered is valid
        {
            System.out.println("Invalid entry.");
            System.exit(0);
        }
        
        int instances = 0;
        
        for (int i = 0; i < x; i++) { // goes through each number and finds if its equal to int instances
            for (int j = 0; j < y; j++) {
                if (array[i] [j] == number) {
                    instances = instances + 1;
                }//end of if
            }//end of loop 2
        }//end of loop 1
        
        System.out.println("\n" + "This number appears " + instances + " time(s)." + "\n"); 

    }//end of instancesInArray

    public static void printArray(int[][] array, int x, int y) { //reprints the array
        
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                System.out.print(array[i] [j] + "\t");
            }//end of loop 2
            System.out.println("");
        }//end of loop 1
        
        System.out.println("");
        
    }//end of printArray
    
}//end of A1Q2
