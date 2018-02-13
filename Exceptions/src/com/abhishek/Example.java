package com.abhishek;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        }catch(NoSuchElementException | ArithmeticException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division");
        }
    }

    public static int divide(){
        int x, y;
//        try{
            x = getInt();
            y = getInt();
            System.out.println("x: " + x + ", y: " + y);
            return x / y;
//        } catch(NoSuchElementException e){
//            throw new NoSuchElementException("No suitable input");
//        } catch (ArithmeticException e){
//            throw new ArithmeticException("attempt to divide by 0");
//        }
    }

    public static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("enter a number");
        while(true){
            try {
                return s.nextInt();
            }catch(InputMismatchException e){
                s.nextLine();
                System.out.println("Enter digit");
            }
        }
    }
}
