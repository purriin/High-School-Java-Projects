package assignment3;

/**
  * Name: Shannon Jones
  * Date: 2020-10-29
  * Description: this class will create an Account object in A3Q1
  * Notes: N/A.
  */

public class Account { // defines instance variables
    private String firstName;
    private String lastName;
    private int number;
    private double balance;
    
    public Account() { // constructor class 1
        firstName = "";
        lastName = "";
        number = 0;
        balance = 0;
    } // end of constructor class 1
    
    public Account (String f, String l, int i, double a) { // constructor class 2
        firstName = f;
        lastName = l;
        number = i;
        balance = a;
    } // end of constructor class 2
    
    void setName(String first, String last) {
        firstName = first;
        lastName = last;
    } // end of setName
    
    String getName() { 
        String fullName = lastName + ", " + firstName;
        return fullName;
    } // end of getName
    
    void setAcctNum(int num) {
        number = num;
    } // end of setAcctNum
    
    int getAcctNum() {
        return number;
    } // end of getAcctNum
    
    void setBalance(double amount) {
        balance = amount;
    } // end of setBalance
    
    double getBalance() {
        return balance;
    } // end of getBalance
    
    void deposit(double amount) {
        balance = balance + amount;
    } // end of deposit
    
    void withdraw(double amount) {
        balance = balance - amount;
    } // end of withdraw
    
    void transfer(double amount, Account other) {
        balance = balance - amount;
        other.deposit(amount);
    } // end of transfer
    
    public String toString () {
        String str;
        str = "Account Holder Name:" + "\t" + lastName + ", " + firstName + "\n" +
              "Account Number: " + "\t" + number + "\n" +
              "Balance: " + "\t\t" + "$" + balance + "\n";
        return str;
    } // end of toString
    
} // end of Account class


