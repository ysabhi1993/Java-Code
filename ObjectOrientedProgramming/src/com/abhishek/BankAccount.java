package com.abhishek;

public class BankAccount {
    private String accountNo;
    private double balance;
    private String phone;
    private String customerName;
    private String email;
    private Transaction transactionPerformed;

    public BankAccount(){
        this("00000", 0, "9999999999", "No Name", "xxx@xxx.com"); // this line has
        // to be the first line in a constructor
        System.out.println("Default Constructor");
    }

    public BankAccount(String accountNo, String customerName){
        //When 'this' is used the constructor with all the five parameters is used
        this("99999AAA", 9090909d,"00000","First Last","default@email");
    }

    public BankAccount(String accountNo, double balance, String phone, String customerName, String email){
        this.accountNo = accountNo;
        this.balance = balance;
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
    }

    public void printTransactionDetails(Transaction transDetails){
        System.out.println("Printing details");
    }

    //Setters
    public void setAccountNo(String accountNo){
        this.accountNo =  accountNo;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setCustomerName(String firstName, String lastName){
        this.customerName = firstName + lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // Getters
    public String getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public String getPhone() {
        return phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    //Other member functions
    public void deposit(int inAmount){
        this.balance += inAmount;
        System.out.println("Money deposited: " + balance);
    }

    public boolean withdraw(int outAmount){
        if(outAmount > balance){
            System.out.println("Transaction failed");
            return false;
        }
        this.balance -= outAmount;
        System.out.println("Transaction successful");
        return true;
    }
}
