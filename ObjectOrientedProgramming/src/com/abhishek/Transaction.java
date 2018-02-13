package com.abhishek;

public class Transaction {
    private String typeOfTransaction;
    private double depAmount;
    private double withdrawAmount;
    private String timeOfTransaction;
    private String transactionBranch;
    private Address branchAddress;

    public Transaction(String typeOfTransaction, double depAmount, double withdrawAmount,
                       String timeOfTransaction, String transactionBranch, Address branchAddress) {
        this.typeOfTransaction = typeOfTransaction;
        this.depAmount = depAmount;
        this.withdrawAmount = withdrawAmount;
        this.timeOfTransaction = timeOfTransaction;
        this.transactionBranch = transactionBranch;
        this.branchAddress = branchAddress;
    }

    public void transDetails(String typeOfTransaction, String timeOfTransaction, String transactionBranch, Address branchAddress){
        System.out.println("Transaction done ");
    }

    public String isTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public double getDepAmount() {
        return depAmount;
    }

    public void setDepAmount(double depAmount) {
        this.depAmount = depAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getTimeOfTransaction() {
        return timeOfTransaction;
    }

    public void setTimeOfTransaction(String timeOfTransaction) {
        this.timeOfTransaction = timeOfTransaction;
    }

    public String getTransactionBranch() {
        return transactionBranch;
    }

    public void setTransactionBranch(String transactionBranch) {
        this.transactionBranch = transactionBranch;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = branchAddress;
    }
}
