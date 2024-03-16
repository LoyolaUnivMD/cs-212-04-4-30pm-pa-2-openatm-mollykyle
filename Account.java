public class Account {
    public String name;
    public double[] pastTransactionsArray;
    public double balance;
    public int currentTransactions;

    //Create constructors
    public Account(String name, double balance, int currentTransactions) {
        this.name = name;
        this.pastTransactionsArray = new double[5];
        this.balance = balance;
        this.currentTransactions = currentTransactions;
    }



    //balance method
    public int getBalance() {
        //output balance
        System.out.print("Your balance is $" + balance);
        //return balance
        return (int) balance;
    }//end of getBalance method



    //withdraw method
    public int withdraw(double amount) {
        //find new balance by subtracting chosen amount
        balance = balance - (amount);
        //output balance
        System.out.println("Your balance is now $" + balance);

        updateTransactions(amount);
        currentTransactions++;

        //return balance
        return (int) balance;
    }//end of withdraw method



    //deposit method
    public int deposit(double amount) {
        //find new balance by adding chosen amount
        balance = balance + (amount);
        //output balance
        System.out.println("Your balance is now $" + balance);

        //update transaction array with amount user chose
        updateTransactions(amount);
        currentTransactions++;

        //return balance
        return (int) balance;
    }//end of deposit method



    //getStats method
    public void getStats() {
        //initiate variables
        double minimum = 1000000000;
        double maximum = 0;
        double total = 0;
        //run through array of past transactions to find minimum
        for (int i = 0; i < pastTransactionsArray.length; i++) {
            //find minimum
            if (pastTransactionsArray[i] < minimum) {
                minimum = pastTransactionsArray[i];
            }
        }//end of for loop to find minimum

        //run through array of past transactions to find maximum
        for (int i = 0; i < pastTransactionsArray.length; i++) {
            //find maximum
            if (pastTransactionsArray[i] > maximum) {
                maximum = pastTransactionsArray[i];
            }
        }//end of for loop to find maximum

        //run through array to find average
        for (int i = 0; i < pastTransactionsArray.length; i++) {
            //add each amount to total
            total += pastTransactionsArray[i];
        }//end of for loop

        //find average of transactions by diving total by array length
        double averageTransactions = total / pastTransactionsArray.length;

        //output stats information
        System.out.println("Minimum of past 5 transactions: " + minimum);
        System.out.println("Maximum of past 5 transactions: " + maximum);
        System.out.println("Average of past 5 transactions: " + averageTransactions);

    }//end getStats method



    //current transactions method
    public void updateTransactions(double amount){
        //if this is fifth transaction reset to zero
        if (currentTransactions == 5){
            currentTransactions = 0;
        }
        //if this is "zero" transaction set amount to index zero
        if (currentTransactions == 0){
            pastTransactionsArray[0] = amount;
        }
        //if this is first transaction set amount to index one
        else if (currentTransactions == 1){
            pastTransactionsArray[1] = amount;
        }
        //if this is second transaction set amount to index two
        else if (currentTransactions == 2){
            pastTransactionsArray[2] = amount;
        }
        //if this is third transaction set amount to index three
        else if (currentTransactions == 3){
            pastTransactionsArray[3] = amount;
        }
        //if this is fourth transaction set amount to index four
        else if (currentTransactions == 4){
            pastTransactionsArray[4] = amount;
        }
    }//end of updateTransactions methods

    public void recentTransactions(){
        System.out.println("Five most recent transactions: ");
        //print out five most recent transactions
        for (int i = 0 ; i < pastTransactionsArray.length; i++){
            System.out.println(pastTransactionsArray[i]);
        }
    }//end of recentTransactions method


}//end of class
