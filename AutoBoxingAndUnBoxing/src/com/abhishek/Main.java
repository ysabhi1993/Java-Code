package com.abhishek;

import java.lang.reflect.Array;
import java.util.ArrayList;

class IntClass{
    private  int intValue;

    public IntClass(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }


}

public class Main {
    //It is not possible to declare an arrayList with its contents as a primitive type. Define a class like below

    public static void main(String[] args) {
        ArrayList<IntClass> newIntArrayList= new ArrayList<IntClass>();
        newIntArrayList.add(new IntClass(10));

    //Instead of defining a wrapper like IntClass, primitive wrapper classes can be used
        // int - Integer
        // short - Short
        // byte - Byte
        // long - Long
        // float - Float
        // double - Double
        // char - Character
        // boolean - Boolean

        //Converting a primitive type into a wrapper class is called autoboxing and the reverse is call unboxing
        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        Integer a = new Integer(10);    // Manual boxing
        Integer b = 20; // Autoboxing; At compile time it gets converted to Integer.valueOf(b);
        int c = b; // Unboxing; c.intValue();
        newArrayList.add(a);

    //Atomic Wrapper classes
        //
        for(int i = 0; i < 10; ++i){
            newArrayList.add(Integer.valueOf(i));

        }

        for(int i = 0; i < 10; ++i){
            System.out.println(newArrayList.get(i).intValue());
        }

    }
}
