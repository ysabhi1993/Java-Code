package com.abhishek;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0,0.0);
        this.gears.add(neutral);
    }

    public void operateClutch(boolean in){
        this.clutchIsIn = in;
    }

    public void addGear(int number, double gearRatio){
        if(number > 0 && number < maxGears){
            this.gears.add(new Gear(number, gearRatio));
        }
    }

    public void changeGear(int newGear){
        if(newGear >= 0 && newGear < this.gears.size() && clutchIsIn){
            this.currGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else{
            System.out.println("Grind!");
            this.currGear = 0;
        }
    }

    public double wheelSpeed(int revs){
        if(clutchIsIn){
            System.out.println("Screen");
            return 0.0;
        }
        return revs * gears.get(currGear).getRatio();
    }

    // Instances of the gear class have access to all the members of the outer gearbox class
    // Even the inner classes have to be hidden from the user
    private class Gear{
        private int gearNo;
        private double ratio;

        public Gear(int gearNo, double ratio) {
            this.gearNo = gearNo;   // refers to the variable belonging to the class Gear
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }
    }


}
