package com.abhishek;

// This interface has to be used by a class and the below methods are defined in the class;
// These methods have to be declared as public
// All the methods must be defined in the corresponding Java class
public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
