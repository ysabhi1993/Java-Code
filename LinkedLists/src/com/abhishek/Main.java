package com.abhishek;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Customer customer = new Customer("Name", 10.33);
        Customer anotherCustomer;

        anotherCustomer = customer; // This works like a pointer. anotherCustomer acts as a reference to customer.
        anotherCustomer.setBalance(22.3);

        System.out.println(customer.getBalance());  // prints 22.3
    }
}
