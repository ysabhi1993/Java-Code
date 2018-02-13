package com.abhishek;

public abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " Bird class");
    }

    @Override
    public void breathe() {
        System.out.println("Bird Breathe");
    }

    @Override
    public void fly() {
        System.out.println(getName() + "is flapping");
    }
}
