package com.abhishek;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    private Customer findCustomer(String custName){

        for(int i = 0; i < this.customers.size(); ++i){
            Customer checkCustomer = this.customers.get(i);
            if(checkCustomer.getName().equals(custName)){
                return checkCustomer;
            }
        }

        return null;
    }

    public boolean newCustomer(String custName, double  initAmount){
        if(findCustomer(custName) == null){
            this.customers.add(new Customer(custName, initAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String custName, double amount){
        Customer existingCustomer = findCustomer(custName);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }
}


