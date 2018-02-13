package com.abhishek;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    private Branch findBranch(String custName){

        for(int i = 0; i < this.branches.size(); ++i){
            Branch checkBranch = this.branches.get(i);
            if(checkBranch.getName().equals(custName)){
                return checkBranch ;
            }
        }

        return null;
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String custName, Double InitialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(custName, InitialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String custName, Double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(custName, amount);
        }
        return false;

    }
}
