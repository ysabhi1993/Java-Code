package com.abhishek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

// ExecutorService interface makes use of thread pools(limits the number of threads)

// To avoid deadlocks, all the threads must avail locks on objects in the same order

import static com.abhishek.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

	    MyProducer myProducer = new MyProducer(buffer, ThreadColor.ANSI_BLUE, bufferLock);
	    MyConsumer myConsumer1 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN, bufferLock);
	    MyConsumer myConsumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

	    executorService.execute(myProducer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RED + "printed from Callable class");
                return "This is the callable result";
            }
        });

        try{
            System.out.println(future.get());
        } catch(ExecutionException e){
            System.out.println("Something went wrong");
        } catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for(String num : nums){
            try {
                System.out.println(color + "Adding number " + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                }finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e){
                System.out.println("Thread Interrupted");
            }
        }

        System.out.println(color + "Adding EOF");
        bufferLock.lock();
        try{
        buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    // Drawbacks of using synchronized code:
    // 1. A thread waiting for a resource to be unlocked cannot be interrupted until they get access to the resource
    // 2. Synchronized blocks have to be in the same method
    // 3. If Multiple threads are waiting for a resource, the jvm will choose which thread gets the resource next


    public void run(){
        while(true) {
            if (bufferLock.tryLock()) { // checks if the lock is available(true if available) ;
                try {
                    if (buffer.isEmpty()) {
                        //bufferLock.unlock();
                        continue;
                    }
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        //bufferLock.unlock();
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            }
        }
    }
}
