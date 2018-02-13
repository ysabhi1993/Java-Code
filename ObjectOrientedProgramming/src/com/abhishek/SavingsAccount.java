package com.abhishek;

public class SavingsAccount extends BankAccount {   // This class requires a constructor to be defined

    private int numOfTransactions;
    private double interestRates;
    private double minBalance;
    private boolean maxTransLimit;

    public SavingsAccount(){
        this("999999","000000","First Last", "email@email.com", 0,0.0,0,false);
    }

    public SavingsAccount(String accountNo, String phone, String customerName, String email, int numOfTransactions,
                          double interestRates, double minBalance, boolean maxTransLimit) {
        super(accountNo, 0, phone, customerName, email);
        this.numOfTransactions = numOfTransactions;
        this.interestRates = interestRates;
        this.minBalance = minBalance;
        this.maxTransLimit = false;
    }

    public int getNumOfTransactions() {
        return numOfTransactions;
    }

    public void setNumOfTransactions(int numOfTransactions) {
        this.numOfTransactions = numOfTransactions;
    }

    public double getInterestRates() {
        return interestRates;
    }

    public void setInterestRates(double interestRates) {
        this.interestRates = interestRates;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public boolean isMaxTransLimit() {
        return maxTransLimit;
    }

    public void setMaxTransLimit(boolean maxTransLimit) {
        this.maxTransLimit = maxTransLimit;
    }

    @Override
    public boolean withdraw(int outAmount){
        if((maxTransLimit && (outAmount + 80) > minBalance) || (!maxTransLimit && outAmount > minBalance)){
            System.out.println("Not enough balance");
            return false;
        } else if((maxTransLimit && ((outAmount + 80) <= minBalance)) || (!maxTransLimit && (outAmount <= minBalance))) {
            System.out.println("Transaction successful");
            return true;
        }
        else
            return true;
    }


}
