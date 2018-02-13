package com.abhishek;


// heap is an area in the memory that all threads share. This is where instance variables are stored
    // These instance variables are visible to all the threads.
// Each thread has its own thread stack. Local variable are stored in the thread stack.

// When two threads are accessing(writing or updating) the same resources and are interleaving, the process is
// termed thread interference/ race condition

// It is important for multiple threads to share the heap without entering into race conditions. This can be done using
// synchronization
// 1. Methods and statements can be synchronized. If a thread is running a method and other threads need to run that method
//    they have to wait until the current thread exits it.
// 2. Other synchronized methods of a class cannot be executed if one of the synced methods is under execution
public class Main {

    public static void main(String[] args) {
        System.out.println("Main Thread");

        // To run a thread, a new thread has to be instantiated and it has to be started
        // the same instance of a thread needn't be started more than once

        Thread anotherThread = new AnotherThread();
        //anotherThread.start();
        // We don't need to call the run method, the JVM will do that when the thread starts
        // If the run method is called, it runs on the main thread instead on a different thread
        //anotherThread.run();

        // An anonymous class can be used instead of creating a different class but the instance has to be started immediately
        new Thread(){
            public void run(){
                System.out.println("Anonymous class");
            }
        }.start();

        // using the Runnable interface, overriding run abstract method will allow to start a thread
        Thread myRunnable = new Thread(new MyRunnable());
        //myRunnable.start();

        //anotherThread.interrupt();

        // The Runnable interface can be passed as an anonymous class also
        Thread myRunnableDup  = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting Thread through Runnable interface, anonymous class");
                try{
                    // anotherThread runs first, then the MyRunnableDup runs. If a parameter A is passed to .join(), the myRunnableDup
                    // is going to wait for A millis or wait for anotherThread to terminate, whichever comes first and continue execution.
                    anotherThread.join(1000);
                    System.out.println("Another Thread terminated");
                } catch (InterruptedException e){
                    System.out.println("myRunnableDup Terminated");
                }
            }
        });

        //myRunnableDup.start();


        CountDown countDown = new CountDown();

        Thread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");
        Thread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
