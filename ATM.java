//pa2
// Programmers: Molly Kyle
// Course: CS 212
// Due Date: 3/25/24
// Lab Assignment: Code an ATM
// Problem Statement:
// Data In: user's name, choice of action, amount withdrawn or deposited
// Data Out: account number, account statistics, balance, past transactions
// Credits: In class activity 5.1 java atm with objects (used same withdraw, deposit and errorcheck methods)
//https://www.programiz.com/java-programming/for-loop - for loop syntax


import java.util.Objects; //import objects
import java.util.Scanner; //import scanner
public class ATM {//Start of main class

    ////MAIN METHOD
    public static void main(String[] args) {
        //make array of accounts
        Account [] accounts = new Account[5];

        //make scanner object
        Scanner input = new Scanner(System.in);

        //ask for either name or exit
        System.out.println("Please enter your name or 'exit'");
        String name = input.next();


        //while choice is not exit:
        while (!(Objects.equals(name, "exit"))) {
            //initiate variables
            Account currentAccount = null;
            boolean found = false;

            //while not exit check if account is in array
            for (Account account : accounts) { //for loop syntax cite from above
                //if the account is not null and the name is found
                if (account != null && Objects.equals(name, account.name)) {
                    //the account found is the current account
                    currentAccount = account;
                    //found is now true
                    found = true;
                    //break;
                }//end of if statement
            }//end of for loop

            //if name is not found
            if (!found) {
                //run through the accounts array
                for (int i = 0; i < accounts.length; i++) {
                    //if a spot in the account is empty
                    if (accounts[i] == null) {
                        //set the current account using user's name
                        currentAccount = new Account(name, 0, 0);
                        //current account is at current index
                        accounts[i] = currentAccount;
                    }
                }
            }//end of if found loop

            //if the current accounts are all null
            if (currentAccount == null) {
                //output no space
                System.out.println("No space");
            }//end of if


            // get user input
            System.out.println("What would you like to do deposit(1), withdraw(2), get stats(3), view recent transactions (4), or leave (5)?");
            //cast input to but
            String choice = input.next().toLowerCase();

            //error check choice
            while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2") && !Objects.equals(choice, "3") && !Objects.equals(choice, "4") && !Objects.equals(choice, "5")) {
                System.out.println("Invalid Choice");
                //Ask for choice again
                System.out.println("What would you like to do? Pick either deposit(1), withdraw(2), get stats(3), view recent transactions (4), or leave (5)?");
                choice = input.next().toLowerCase();
            }//end of while loop


            //while the userChoice is not "5"
            while (!(Objects.equals(choice, "5"))) {
                //if userChoice == "1"
                if (Objects.equals(choice, "1")) {
                    //ask for amountDepositing
                    System.out.println("How much would you like to deposit?");
                    double amount = input.nextDouble();
                    while (amount < 0) {
                        System.out.println("Invalid option please enter new number ");
                        amount = input.nextDouble();
                    }//end of error check

                    //call withdraw function
                    currentAccount.deposit(amount);
                    currentAccount.updateTransactions(amount);
                }//end of balance

                //else if userChoice == "2"
                else if (Objects.equals(choice, "2")) {
                    //ask for amountWithdrawing
                    System.out.println("How much would you like to withdraw?");
                    double amount = input.nextDouble();
                    while (amount < 0) {
                        System.out.println("Invalid option please enter new number ");
                        amount = input.nextDouble();
                    }//end of error check

                    //call withdraw function
                    currentAccount.withdraw(amount);

                    //call updateTransactions function
                    currentAccount.updateTransactions(amount);
                }//end of withdraw

                //else if userChoice == "3"
                else if (Objects.equals(choice, "3")) {
                    currentAccount.getStats();
                }//end of else if 3

                //else
                else if (Objects.equals(choice, "4")){
                    //call recentTransactions method
                   currentAccount.recentTransactions();
                }//end of if statements
                else {
                    System.out.println("Invalid option");
                }//end of else


                //ask for userChoice again
                System.out.println("What would you like to do deposit(1), withdraw(2), get stats(3), view recent transactions (4), or leave (5)?");
                choice = input.next();
            }//end of while not 5


            //Ask for name or exit again
            System.out.println("Please enter name or 'exit'");
            name = input.next();

        }//end of while

    }//end of main method


}//end of Main class