package com.abhishek;

public class CountDown {
    private int i;

    // Synchronized keyword tells the method to run on the same thread until the method is completely executed
    // Similarly statements can also be synchronized using locks. When a statement is locked only one thread can use it.
    public /*synchronized*/ void doCountDown() {
        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + " i: " + i);
            }
        }
    }
}
// Synchronization can be called on static methods. In this case the lock is owned by the class object.
// Those static methods are reentrant - any method called by the same thread belonging to the same class can be executed.

// Critical section refer to the code that's referencing a shared resource. Only one thread should access a critical section
// at a time. If that is conformed, then the code is Thread Safe. All the critical sections have to be synchronized
class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown threadCountDown){
        this.threadCountDown = threadCountDown;
    }
    @Override
    public void run(){
        threadCountDown.doCountDown();
    }
}
