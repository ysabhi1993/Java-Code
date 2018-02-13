package com.abhishek;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Since myPhone is declared as an Interface type, it got instantiated using both deskphone and mobilephone types.
        ITelephone myPhone; // It cannot be instantiated here because the interface does not have methods defined and those
                            // methods are defined in the corresponding class
        myPhone = new DeskPhone(12345);
        myPhone.powerOn();
        myPhone.callPhone(12345);
        myPhone.answer();

        myPhone = new MobilePhone(123456);
        //myPhone.powerOn();
        myPhone.callPhone(123456);
        myPhone.answer();
    }
}
