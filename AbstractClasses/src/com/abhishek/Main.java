package com.abhishek;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dog dog = new Dog("Husky");
        dog.breathe();
        dog.eat();

        Parrot bird = new Parrot("Some Parrot");
        bird.fly();
        bird.breathe();
        bird.eat();
    }


}
