package com.abhishek;

import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    // This is Java
    // When a shallow copy is created, there will be two objects created. But they will refer to the same objects
    // which means two references will be created
    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Olympian", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);

        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Seat reserved");
        }else{
            System.out.println("Seat cannot be reserved");
        }

//        // reverses a list
//        Collections.reverse(seatCopy);
//        printList(seatCopy);
//
//        // min and max
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//
//        // swap
//        Collections.swap(seatCopy, 2,4);
//        printList(seatCopy);
//
//        // copy
//        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size() + 1);
//        Collections.copy(seatCopy, theatre.seats);  //The destination list has to have elements equal to or greater than the
//                                                    // source.

    }

    public static void printList(List<Theatre.Seat> seats){
        for(Theatre.Seat seat : seats){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=================================================================================");
    }
}
