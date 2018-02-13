package com.abhishek;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println("Another Thread: " + currentThread().getName());
        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            System.out.println("Execution interrupted");
            return;
        }

        System.out.println("Thread awake");
    }
}
