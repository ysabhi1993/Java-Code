package com.abhishek;

import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
	    //4 types of nested classes
        // 1. static nested classes - used to associate a class with its outer class. It can access the static members of the outer
                                    // class. It can access the non-static members of the outer class only after creating an
        //                          // instance of that class;
        // 2. non-static nested class - inner class
        // 3. a local class - an inner class defined inside a scope block (which is usually a method)
        // 4. an anonymous class which is a nested class without a class name


        // Here Gear class is local to Gearbox class
       /* Gearbox mcLaren = new Gearbox(6);
        mcLaren.addGear(1, 2.3);
        mcLaren.addGear(2,4.6);
        mcLaren.addGear(3,6.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed((6000)));
*/

       // defined as a local class and is applicable only for this block
        class ClickListener implements Button.OnClickListener{
            public ClickListener(){
                System.out.println("Attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " Clicked");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();

        // An anonymous class is declared and instantiated at the same time as it doesn't have a name
        // These are used when local class has to be used only once.
        // These are used to attach event handles to buttons. When different events have to be triggered based on buttons
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println("Anonymous class");
            }
        });
        listen();

    }

    public static void listen(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
