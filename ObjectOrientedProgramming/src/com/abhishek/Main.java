package com.abhishek;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();

        porsche.setModel("Carrera");
        holden.setModel("Commadore");

        BankAccount myAccount = new SavingsAccount();
        Address myAddress = new Address("Miyapur","Hyderabad","Telangana", "India");
        Transaction myTransaction = new Transaction("At Bank",0, 1000,"10:30 AM", "Miyapur",myAddress);

        System.out.println(myTransaction.getBranchAddress().getCity());


    }
}
