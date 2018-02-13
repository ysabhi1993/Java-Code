package com.abhishek;

public class Car {
    // public is an access modifier - all the other classes can access it without restrictions
    // member variables or fields

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model){
        String uncapModel = model.toLowerCase();
        if(uncapModel.equals("carrera") || uncapModel.equals("commadore"))
            this.model = model;
        else
            this.model = "Unknown";
    }

    public String getModel(){
        return this.model;
    }


}
