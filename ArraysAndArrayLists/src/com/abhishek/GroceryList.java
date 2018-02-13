package com.abhishek;

import java.util.ArrayList;

public class GroceryList {

    // ArrayList
    //.addall(collection c) - appends all the contents of the specified collection to 'this' arrayList in the order
        //returned by the specified collection's iterator;
    //.toArray() - returns an array with all the elements in the arrayList in the correct order;
    //.isEmpty() - tests if the arrayList has no components;
    private ArrayList<String> groceryList = new ArrayList<String>();

    //.add(object) - add item at the end of the list
    //.add(position, object)
    public void addItem(String item){
        groceryList.add(item);
    }
    //.get(position) - return the element at the given position
    public void printGroceryList(){
        System.out.println("Printing Grocery List");
        for(int i = 0; i < groceryList.size(); i++){
            System.out.println("Item " + (i+1) + " being printed:" + groceryList.get(i));
        }
    }
    //.remove(position) - remove and element from the given position
    public void removeGroceryListItem(int position){
        String itemToBeRemoved = groceryList.get(position);
        groceryList.remove(itemToBeRemoved);
    }
    //.set(position, item) - replaces the item at 'position'
    public void modifyGroceryList(int position, String item){
        groceryList.set(position,item);
    }
    //.contains(item) - returns true if the item is present in the arrayList
    //.indexOf(item) - searches for the first occurrence of the item using the equals method
    public String searchGroceryList(String item){
        boolean exists = groceryList.contains(item);

        int position = groceryList.indexOf(item);
        if(position >= 0)
            return groceryList.get(position);
        else
            return null;
    }
}
