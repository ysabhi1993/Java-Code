package com.abhishek;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transaction;

    public Customer(String name, Double initAmount) {
        this.name = name;
        this.transaction = new ArrayList<Double>();
        this.transaction.add(initAmount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public void setTransaction(ArrayList<Double> transaction) {
        this.transaction = transaction;
    }

    public void addTransaction(Double amount){
        this.transaction.add(amount);

    }
}
