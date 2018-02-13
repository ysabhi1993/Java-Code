package com.abhishek;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Queensland");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Southern Australia");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);

        //placesToVisit.add(1, "Alice Springs");
        addInOrder(placesToVisit,"Alice Strings");
        addInOrder(placesToVisit, "Darwin");
        //printList(placesToVisit);

       // placesToVisit.remove(4);
        //printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> inputLinkedList){
        Iterator<String> i = inputLinkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now Visiting " + i.next());
        }
        System.out.println("======================End===================");
    }

    private static boolean addInOrder(LinkedList<String> inputLinkedList, String newCity){
        ListIterator<String> stringListIterator = inputLinkedList.listIterator();   //The iterator points to the first element


        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            // returns 0 if the object string is equal to the argument string
            // returns a negative number if the string object preceded the argument string
            // returns a positive number if the string object follows the argument string
            if(comparison == 0){
                System.out.println("New City " + newCity + " is already included");
            }
            else if (comparison > 0){
                //the argument comes later
                stringListIterator.previous();  //List Iterator enables to move back in the list
                stringListIterator.add(newCity);
                System.out.println("New City: " + newCity + " added");
                return true;
            }

        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities");
        }
        else{
            System.out.println("Now Visiting " + listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if(listIterator.hasNext()){
                        System.out.println("Visiting the next city " + listIterator.next());
                    }else{
                        System.out.println("We are at the end of the list");
                    }
                    break;
                case 2:
                    if(listIterator.hasPrevious()){
                        System.out.println("Visiting previous city " + listIterator.previous());
                    }else{
                        System.out.println("We are at the start of the list");
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions");
        System.out.println("0 - to quit \n" +
                "1 - go to next city" +
                "2 - go to previous city" +
                "3 - print menu");
    }

}
