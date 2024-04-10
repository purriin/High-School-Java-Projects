package assignment1;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-09-25
  * Description: Simulates shuffling and dealing cards
  * Notes: Will continuously run until the user says to exit, shuffle function will switch the values around in the array
  *         The deck goes in order from left to right in the printed array.
  */

public class A1Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        String[] value = new String[13]; // Value and suit arrays are used to assign values to the playingCards array
        String[] suit = new String[4];
        String[] playingCards = new String[52];
        
        orderDeck(value, suit, playingCards); // goes to the orderDeck method to assign all the values
        
        int loop = 1;
        
        while (loop == 1) { //a continuous loop that can only be ended if the user says to exit or inputs something invalid
            System.out.println("What would you like to do?" + "\n" + "'List' - Prints out all 52 cards in the deck.");
            System.out.println("'Shuffle' - Shuffles the cards in the deck.");
            System.out.println("'Order' - Orders the deck back to normal." + "\n" + "'Deal' - Deals cards to each hand.");
            System.out.println("'Exit' - Shut down the program.");
            String option = input.nextLine();
        
            if (option.equalsIgnoreCase("list")) // goes to the printDeck method to print the deck
            {
                System.out.println("");//just to space out the text
                printDeck (playingCards);
            }
            
            else if (option.equalsIgnoreCase("shuffle")) // goes to the shuffleDeck method to shuffle the deck
            {
                System.out.println("");//just to space out the text
                shuffleDeck (playingCards);
            }
        
            else if (option.equalsIgnoreCase("deal")) // goes to the dealDeck method to deal the cards
            {
                System.out.println("");//just to space out the text
                dealDeck (playingCards);
            }
            
            else if (option.equalsIgnoreCase("order")) /* goes to the orderDeck method to revert the deck back to original order
                                                        * I just added this method so it was easier to test out the other methods in the program
                                                        */ 
            {
                System.out.println("");//just to space out the text
                orderDeck (value, suit, playingCards);
            }
            
            else if (option.equalsIgnoreCase("exit")) { //ends the program
                break;
            }
            
            else // for any invalid inputs
            {
                System.out.println("");//just to space out the text
                System.out.println("Invalid entry.");
                break;
            }//end of if
        
        }//end of loop
              
    }//end of main
    
    public static void printDeck(String playingCards[]) {
        int counter = 0;
        
        for (int i = 0; i<13; i++) { //prints out all 52 cards
            
            for (int j = 0; j<4; j++) {
                System.out.print(playingCards[counter] + "\t \t");
                counter = counter + 1;
            }//end of loop 1
            
            System.out.println("");//just to space out the text (They are arranged in a table so it's easier to read)
            
        }//end of loop 2

        System.out.println("");
        
    }//end of printDeck
    
    public static void shuffleDeck(String playingCards[]) {
        Random generator = new Random();
        int randomValue;
        int randomNum;
        
        String copy;//used to switch 2 values in the two loops below

         for (int i = 0; i<52; i++) { //shuffles deck (card suits)
            randomValue = generator.nextInt(52);
            randomNum = generator.nextInt(52);
            
            if (!playingCards[randomValue].equals(playingCards[randomNum])) // switches values in the playingCards array
            {
                copy = playingCards[randomValue];
                playingCards[randomValue] = playingCards[randomNum];  
                playingCards[randomNum] = copy;
            }
            
            else if (playingCards[randomValue].equals(playingCards[randomNum])) {//cannot swtich values that equal the same value
                i=i-1;
            }//end of if
            
         }//end of loop
        
         System.out.println("The deck has been shuffled." + "\n");
        
    }//end of shuffleDeck
    
    public static void dealDeck(String playingCards[]) {
        Scanner input = new Scanner (System.in);
         
        System.out.println("How many hands are there?");
        int hands = input.nextInt();
        System.out.println("How many cards are in each hand?");
        int cards = input.nextInt();
        
        if (hands < 0 || cards < 0 || hands*cards > 52) //checks to see if the number entered is valid
        {
            System.out.println("Invalid entry.");
            System.exit(0);
        }//end of if
        
        int x = 0; // used to print out each card
        int sum = 0;
        
        System.out.println("");
        
        for (int i = 1; i <= hands; i++) {
            System.out.println("Hand #" + i + ":");
            
            for (int j = 0; j < cards; j++) {
                System.out.println(playingCards[x]);
                
                if (playingCards[x].substring(0, 3).equals("Ace")) { // these if statements find the values of each card in order to calculate the sum
                    sum = sum + 11;
                }
                else if (playingCards[x].substring(0, 4).equals("King")) {
                    sum = sum + 10;
                }
                else if (playingCards[x].substring(0, 4).equals("Jack")) {
                    sum = sum + 10;
                }
                else if (playingCards[x].substring(0, 5).equals("Queen")) {
                    sum = sum + 10;
                }
                else if (playingCards[x].substring(0, 2).equals("10")) {
                    sum = sum + 10;
                }
                else if (playingCards[x].substring(0, 1).equals("9")) {
                    sum = sum + 9;
                }
                else if (playingCards[x].substring(0, 1).equals("8")) {
                    sum = sum + 8;
                }
                else if (playingCards[x].substring(0, 1).equals("7")) {
                    sum = sum + 7;
                }
                else if (playingCards[x].substring(0, 1).equals("6")) {
                    sum = sum + 6;
                }
                else if (playingCards[x].substring(0, 1).equals("5")) {
                    sum = sum + 5;
                }
                else if (playingCards[x].substring(0, 1).equals("4")) {
                    sum = sum + 4;
                }
                else if (playingCards[x].substring(0, 1).equals("3")) {
                    sum = sum + 3;
                }
                else if (playingCards[x].substring(0, 1).equals("2")) {
                    sum = sum + 2;
                }
                
                x = x+1;
                
            }//end of loop 2
            
            System.out.println("Total: " + sum + "\n");
            sum = 0;
                    
        }//end of loop 1
        
    }//end of dealDeck
    
    public static void orderDeck(String value[], String suit[], String playingCards[]) {//goes back to original order
        value[0] = "Ace";
        value[1] = "2";
        value[2] = "3";
        value[3] = "4";
        value[4] = "5";
        value[5] = "6";
        value[6] = "7";
        value[7] = "8";
        value[8] = "9";
        value[9] = "10";
        value[10] = "Jack";
        value[11] = "Queen";
        value[12] = "King";

        suit[0] = "hearts";
        suit[1] = "spades";
        suit[2] = "diamonds";
        suit[3] = "clubs";

        int counter = 0;
        
        for (int i = 0; i < 13; i++) { // I just used a loop to assign each value to the array just so that I don't have to manually type out all 52 cards
            for (int j = 0; j < 4; j++) {
                playingCards[counter] = (value[i] + " of " + suit[j]);
                counter = counter + 1;
            }//end of loop 2
        }//end of loop 1

    }//end of orderDeck
    
}//end of A1Q1
