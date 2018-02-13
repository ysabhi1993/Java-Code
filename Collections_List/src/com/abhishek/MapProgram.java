package com.abhishek;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<Character, Integer> mapped = new HashMap<>();
        mapped.put('A', 65);
        mapped.put('B', 66);
        mapped.put('C', 67);
        mapped.put('D', 68);
        mapped.put('E', 69);
        mapped.put('F', 70);
        mapped.put('G', 71);
        mapped.put('H', 72);

        // A null is returned by the .put method if a new key, value is added to the map
        // otherwise the value of the previous key is returned

        System.out.println(mapped.get('D'));
        mapped.put('D', 99);
        System.out.println(mapped.get('D'));

        if(mapped.containsKey('D')) System.out.println("True");
        else System.out.println("False");

        mapped.remove("D"); // to remove the key,value pair with key 'D'
        mapped.remove("D", 99); // to remove the key only if it is mapped to 99
        mapped.replace('A', 99); // replaces the value of 'A'.
        mapped.replace('A', 99, 65); //replaces only if the value of 'A' is 99

        for(Character key : mapped.keySet()){   // keySet() returns a set of all keys
            System.out.println(mapped.get(key));
        }
    }

    // To make a class immutable which means any instance of that class cannot be edited,
    // all the variables have to be defined final and avoid allowing references to be made to other instances when
    // new instances are created
    // Dont allow subclasses to overwrite methods
    // This will be useful when a class has to be used as a key. Making it immutable will be necessary
}
