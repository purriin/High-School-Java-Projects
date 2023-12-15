package assignment3;
import java.io.*;
import java.util.*;

/**
  * Name: Shannon Jones
  * Date: 2020-10-29
  * Description: This program processes accounts_data.txt and creates accounts for each person, the user can also make an account
  * Notes: Directory paths must change on different computers
  *         If the last name of a new account starts with a lower case letter, the account will be placed at the end of the list.
  */

public class A3Q1 {
    public static void main (String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        
        ArrayList <String> lines = new ArrayList<String>();
        ArrayList <String> lastNames = new ArrayList<String>();
        ArrayList <String> firstNames = new ArrayList<String>();
        ArrayList <Integer> number = new ArrayList<Integer>();
        ArrayList <Double> balance = new ArrayList<Double>();
        
        ArrayList<Account> accounts = new ArrayList<Account>();
        
        int k = 19; // initial amount of accounts - 1
        
        readText(lines);
        initialAccounts(lines, firstNames, lastNames, number, balance, accounts);
        
        System.out.println("BANK ACCOUNTS");
        
        int loop = 1;
        while (loop == 1) { // will not end unless user prompts for it
            System.out.println("\n" + "What would you like to do?" + "\n" +
                               "'1' - Create a new account" + "\t\t" + "'6' - Print account info" + "\n" +
                               "'2' - Get account balance" + "\t\t" + "'7' - Export listing of all accounts (numerically ordered)" + "\n" +
                               "'3' - Deposit amount" + "\t\t\t" + "'8' - Export listing of all accounts (alphabetically ordered)" + "\n" +
                               "'4' - Withdraw amount" + "\t\t\t" + "'0' - Exit" + "\n" +
                               "'5' - Transfer funds to other account");
            try {
                int option = input.nextInt();

                if (option == 1) {
                    System.out.println();
                    k = newAccount(accounts, k, lastNames, number, firstNames, balance);
                }
                else if (option == 2) {
                    System.out.println();
                    int index = findAccount(accounts, number);

                    if (index == -1) {
                        System.out.println("There is no account under this number. Please try again.");
                    }
                    else {
                        System.out.println("Balance: $" + ((Account)accounts.get(index)).getBalance());
                    }

                }
                else if (option == 3) {
                    System.out.println();
                    depositAmount(accounts, number);
                }
                else if (option == 4) {
                    System.out.println();
                    withdrawAmount(accounts, number);
                }
                else if (option == 5) {
                    System.out.println();
                    transferFunds(accounts, number);
                }
                else if (option == 6) {
                    System.out.println();
                    printInfo(accounts, number);
                }
                else if (option == 7) {
                    System.out.println();
                    exportNumerical(accounts, number, balance, firstNames, lastNames);
                }
                else if (option == 8) {
                    System.out.println();
                    exportAlphabetical(accounts, number, balance, firstNames, lastNames);
                }
                else if (option == 0) {
                    break;
                }
                else {
                    System.out.println("\nInvalid input. Please try again.\n");
                } 
            }
            catch (Exception e){
                System.out.println("\nInvalid input. Please try again.\n");
                input.next();
            }
        } // end of loop
    } // end of main
    
    public static ArrayList readText(ArrayList lines) throws IOException{ // reads the file and stores lines in an array list
        Scanner reader = new Scanner (new File("C:\\JavaFolder\\accounts_data.txt"));
        
        while(reader.hasNext()) { // reads each line and adds it to a String
           lines.add (reader.next());
        } // end of loop
        return lines;
    } // end of readText

    public static void initialAccounts(ArrayList lines, ArrayList firstNames, ArrayList lastNames, ArrayList number, ArrayList balance, ArrayList accounts) { // goes through the lines arraylist and creates accounts based off of them
        String copy = "";
        String convert = "";
        int x = 0;
        
        for (int i = 6; i < lines.size(); i++) {
            copy = (String)lines.get(i);
            for (int j = 0; j < 1; j++) {
                if ((i-2)%4 == 0) { // finds first names, last names, numbers, and balances based off of how the document was organized
                    firstNames.add(copy);
                }
                else if ((i-2)%4 == 1) {
                    lastNames.add(copy);
                }
                else if ((i-2)%4 == 2) {
                    try {
                        number.add (Integer.parseInt(copy)); // converts String into an int
                    }
                    catch (Exception e) {
                    }
                }
                else if ((i-2)%4 == 3) {
                    try {
                        convert = copy;
                        balance.add (Double.parseDouble(convert)); // converts String into a double
                    }
                    catch (Exception e) {
                    }
                } // end of if
            } // end of loop 2
        } // end of loop 1
        
        for (int k = 0; k< 20; k++) { // creates each account
            Account aInitial = new Account();
            accounts.add(aInitial);
            ((Account)accounts.get(k)).setName((String)firstNames.get(k), (String)lastNames.get(k));
            ((Account) accounts.get(k)).setAcctNum((int)number.get(k));
            ((Account) accounts.get(k)).setBalance((double)balance.get(k));
        } // end of loop
    } // end of initialAccounts

    public static int newAccount(ArrayList accounts, int k, ArrayList lastNames, ArrayList number, ArrayList firstNames, ArrayList balance) { // makes a new account based on user input
        Scanner input = new Scanner (System.in);
        Account aNew = new Account();
        accounts.add(aNew);
        k = k + 1;
        int condition = 0;
        
        System.out.println("What is your first name?");
        String first = input.nextLine();
        System.out.println("What is your last name?");
        String last = input.nextLine();
        System.out.println("Please enter a 6-digit account number.");
        boolean correctInput = false;
        int numberNew = 0;
        while (!correctInput) {
            try { // just in case user types in a char instead
                numberNew = input.nextInt();
                String copy = "" + numberNew;
                
                for (int i = 0; i < number.size(); i++) { // looks for if card number is already in use by another user
                    if (numberNew == (int)number.get(i)) {
                        condition = 1;
                    }
                } // end of loop
                
                if (condition == 1) {
                    System.out.println("Account number already in use. Please try again.");
                    condition = 0;
                }
                else 
                {
                    if (copy.length() != 6) {
                        System.out.println("Invalid entry. Please try again.");
                    }
                    else {
                        correctInput = true;
                    }
                } // end of if
            }
            catch (Exception e){
                System.out.println("Invalid entry. Please try again.");
                input.nextLine();
            }
        } // end of loop
        
        System.out.println("Please enter your account balance.");
        double bal = 0;
        correctInput = false;
        while (!correctInput) {
            try {
                bal = input.nextDouble();
                if (bal < 0) {
                    System.out.println("Invalid entry. Please try again.");
                }
                else {
                    correctInput = true;
                }
            }
            catch (Exception e){
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop
        ((Account)accounts.get(k)).setName(first, last);
        ((Account)accounts.get(k)).setAcctNum(numberNew);
        ((Account)accounts.get(k)).setBalance(bal);
        
        lastNames.add(last);
        firstNames.add(first);
        balance.add(bal);
        number.add(numberNew);
        
        return k;
    } // end of newAccount

    public static void depositAmount(ArrayList accounts, ArrayList number) {
        Scanner input = new Scanner (System.in);
        int index = findAccount(accounts, number);
        
        boolean correctInput = false;
        if (index == -1) {
            correctInput = true;
        }
        while (!correctInput) {
            try { // try catch statement just in case user types in an invalid entry
                System.out.println("Please enter the amount you are depositing.");
                double depositAmount = input.nextDouble();
                if (depositAmount <= 0) { // cannot deposit nothing or a negative number
                    System.out.println("Invalid deposit amount.");
                    break;
                }
                else {
                    ((Account)accounts.get(index)).deposit(depositAmount);
                    correctInput = true;
                } // end of if
            }
            catch (Exception e){
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop
    } // end of depositAmount

    public static void withdrawAmount(ArrayList accounts, ArrayList number) {
        Scanner input= new Scanner (System.in);
        int index = findAccount(accounts, number);
        
        boolean correctInput = false;
        if (index == -1) {
            correctInput = true;
        }
        while (!correctInput) {
            try { // try catch statement just in case user types in an invalid entry
                System.out.println("Please enter the amount you are withdrawing.");
                double withdrawAmount = input.nextDouble();
                if (withdrawAmount <= 0) { // cannot withdraw nothing or a negative number
                    System.out.println("Invalid withdraw amount.");
                    break;
                }
                else {
                    ((Account)accounts.get(index)).withdraw(withdrawAmount);
                    correctInput = true;
                } // end of if
            }
            catch (Exception e){
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop
    } // end of withdrawAmount

    public static void transferFunds(ArrayList accounts, ArrayList number) { // transfers funds from one account to another
        Scanner input= new Scanner (System.in);
        boolean correctInput = false;
        int index2 = 0;
        
        System.out.println("YOUR ACCOUNT");
        int index = findAccount(accounts, number);
        
        if (index > -1) {
            System.out.println("OTHER ACCOUNT");
            index2 = findAccount(accounts, number);
        }
        else if (index == -1) {
            correctInput = true;
        }
        
        if (index2 == -1) {
            correctInput = true;
        }
        
        while (!correctInput) {
            try { // try catch statement just in case user types in an invalid entry
                System.out.println("Please enter the amount you are transfering.");
                double transferAmount = input.nextDouble();
                if (transferAmount <= 0) { // cannot withdraw nothing or a negative number
                    System.out.println("Invalid withdraw amount.");
                    break;
                }
                else {
                    ((Account)accounts.get(index)).transfer(transferAmount, (Account)accounts.get(index2));
                    correctInput = true;
                } // end of if
            }
            catch (Exception e){
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop
    } // end of transferFunds

    public static void printInfo(ArrayList accounts, ArrayList number) { // prints info of an account
        int index = findAccount(accounts, number);
        System.out.println(((Account)accounts.get(index)).toString());
    } // end of printInfo

    public static void exportNumerical(ArrayList accounts, ArrayList number, ArrayList balance, ArrayList firstNames, ArrayList lastNames) throws IOException{
        PrintWriter writer = new PrintWriter (new File("C:\\JavaFolder\\Numerical.txt")); // directory path must change
        int[] accountNumbers = new int[number.size()];
        for (int i = 0; i < number.size(); i++) {
            accountNumbers[i] = (int)number.get(i);
        } // end of loop
        int k = 0;
        boolean exchangeMade = true;
        
        while ((k<number.size() - 1) && exchangeMade) { // Bubble sort to sort accounts numerically by account name
            exchangeMade = false;
            k++;
            for (int j = 0; j < number.size() - k; j++) {
                if (accountNumbers[j] > accountNumbers[j+1]) {
                    swap(accountNumbers, j, j+1);
                    exchangeMade = true;
                }
            }
        } // end of loop
        
        for (int i = 0; i < number.size(); i++) {
            int index = findAccount2(accounts, number, accountNumbers[i]);
            writer.println("Account Holder Name:" + "\t" + lastNames.get(index) + ", " + firstNames.get(index) + "\n" +
                           "Account Number: " + "\t" + number.get(index) + "\n" +
                           "Balance: " + "\t\t" + "$" + balance.get(index) + "\n\n" + "==========================" + "\n");
        } // end of loop
        writer.close();
        System.out.println("Export successful.\n");
    } // end of exportNumerical

    public static void exportAlphabetical(ArrayList accounts, ArrayList number, ArrayList balance, ArrayList firstNames, ArrayList lastNames) throws IOException{
        PrintWriter writer = new PrintWriter (new File("C:\\JavaFolder\\Alphabetical.txt")); // directory path must change
        String[] accountNames = new String[number.size()];
        for (int i = 0; i < lastNames.size(); i++) {
            accountNames[i] = (String)lastNames.get(i);
        } // end of loop
        int k = 0;
        boolean exchangeMade = true;
        
        while ((k<number.size() - 1) && exchangeMade) { // Bubble sort to sort accounts alphabetically by last name
            exchangeMade = false;
            k++;
            for (int j = 0; j < number.size() - k; j++) {
                int result =((Comparable)accountNames[j]).compareTo((Comparable)accountNames[j+1]);
                if (result > 0) {
                    swap2(accountNames, j, j+1);
                    exchangeMade = true;
                }
            }
        } // end of loop
        
        for (int i = 0; i < lastNames.size(); i++) {
            int index = findAccount3(accounts, lastNames, accountNames[i]);
            writer.println("Account Holder Name:" + "\t" + ((Account)accounts.get(index)).getName()  + "\n" +
                           "Account Number: " + "\t" + ((Account)accounts.get(index)).getAcctNum()  + "\n" +
                           "Balance: " + "\t\t" + "$" + ((Account)accounts.get(index)).getBalance() + "\n\n" + "==========================" + "\n");
        } // end of loop
        writer.close();
        System.out.println("Export successful.\n");
    } // end of exportAlphabetical
    
    public static int findAccount(ArrayList accounts, ArrayList number) { // prompts user to enter an account number to find account
        Scanner input= new Scanner (System.in);
        System.out.println("Please enter the account number.");
        boolean correctInput = false;
        int index = -1;
        while (!correctInput) {
            try {
                int searchValue = input.nextInt();
                String copy = "" + searchValue;
                if (copy.length() == 6) {
                    for (int i = 0; i < accounts.size(); i++) {
                        if ((int)number.get(i) == searchValue) {
                            index = i;
                            return index;
                        }
                    } // end of loop
                    if (index == -1) {
                        System.out.println("\nAccount was not found.\n");
                        break;
                    }
                }
                else {
                    System.out.println("Invalid entry. Please try again.");
                } // end of if
            }
            catch (Exception e) {
                System.out.println("Invalid entry. Please try again.");
            }
        } // end of loop
        return -1;
    } // end of findAccount

    public static void swap(int[] accountNumbers, int j, int i) { // swaps 2 values in the accountNumbers array to sort numerically
        int temp = accountNumbers[j];
        accountNumbers[j] = accountNumbers[i];
        accountNumbers[i] = temp;
    } // end of swap
    
    public static int findAccount2(ArrayList accounts, ArrayList number, int searchValue) { // does not need user to enter a card number, used to find each account to export accounts numerically
        int index = -1;
        String copy = "" + searchValue;
        for (int i = 0; i < accounts.size(); i++) {
            if ((int)number.get(i) == searchValue) {
                index = i;
                return index;
            }
        } // end of loop
        if (index == -1) {
            System.out.println("\nAccount was not found.\n");
        }
        return -1;
    } // end of findAccount2

    public static void swap2(String[] accountNames, int j, int i) { // sorts accountNames alphabetically
        String temp = accountNames[j];
        accountNames[j] = accountNames[i];
        accountNames[i] = temp;
    } // end of swap2

    public static int findAccount3(ArrayList accounts, ArrayList lastNames, String searchValue) { // does not need user to enter a card number, used to find each account to export accounts alphabetically
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (((String)lastNames.get(i)).equals(searchValue)) {
                index = i;
                return index;
            }
        } // end of loop
        if (index == -1) {
            System.out.println("\nAccount was not found.\n");
        }
        return -1;
    } // end of findAccount3
    
} // end of A3Q1