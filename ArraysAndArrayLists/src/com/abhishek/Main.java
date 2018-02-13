package com.abhishek;

import java.util.Scanner;

public class Main {

    //METHODS FOR SCANNER CLASS
    //.next() - returns the next token from the scanner;
    //.nextLine() - moves the scanner position to the next line and returns the value of a string
    //.nextByte(), .nextShort(), .nextInt(), .nextLong(), .nextFloat(), .nextDouble();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        int [] intArray = new int[10];
        char [] intArray2 = {'a','n'};// this kind of initialization can be done only during declaring an array.
        String[] stringArray = getStrings(0);
        System.out.println(intArray.length + " " + intArray2.length + "\n" + stringArray.length);

        for(int i = 0; i < intArray.length; i++){
            intArray[i] = i * 9;
        }

        System.out.println(intArray.length);

        printArray(intArray);
        printArray(stringArray);

    }

    public static String[] getStrings(int number){
        System.out.println("Enter " + number + "Strings");
        String[] tempStringArray = new String[number];

        for(int i = 0; i < number; i++){
            tempStringArray[i] = scanner.next();
        }

        return tempStringArray;
    }

    public static void printArray(String [] array){
        for(int i =0 ; i < array.length; i++){
            System.out.println("Array Element " + i + " is: " + array[i]);
        }
    }

    public static void printArray(int [] array){
        for(int i =0 ; i < array.length; i++){
            System.out.println("Array Element " + i + " is: " + array[i]);
        }
    }

    // is a resizable array and handles the resizing by itself automatically

}
