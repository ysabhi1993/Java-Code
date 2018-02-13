package com.abhishek;

import java.util.InputMismatchException;
import java.util.Scanner;
// Exceptions are those that disrupt the normal flow of program execution
// Exception and run-time exception are two classes defined. other exceptions are caught as sub-classes to those classes.
public class Main {

    public static void main(String[] args) {
        System.out.println(divide(10, 10));

        int x = getInt();
        int y = getIntEAFP();
        int z = getIntLBYL();
        System.out.println(x + ", " + y + ", " + z);
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an Integer: ");
        String input = s.next();
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        try{
            return s.nextInt();
        } catch(InputMismatchException e){
            return 0;
        }
    }

    private static int divideLBYL(int x, int y){
        if(y == 0) return 0;
        return x / y;
    }

    private static int divideEAFP(int x, int y){
        try{
            return x / y;
        } catch(ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x / y;
    }
}
