package com.abhishek;

import java.util.Random;

// A Thread cannot be suspended between atomic operations(they cannot be stopped during execution):
// 1. Reading and writing reference variables
// 2. A thread cannot be suspended while reading and writing primitive variables except for long and double
// 3. While reading and writing variables that are volatile


public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read(){
        while(empty){
            try{
                wait();
            } catch (InterruptedException e){

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while(!empty){
            try{
                wait();
            } catch(InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    public void run(){
        Random random = new Random();
        String messages[] = {"Hello1",
                            "Hello2",
                            "Hello3",
                            "Hello4"};

        for(int i = 0; i < messages.length; i++){
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable{
    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    public void run(){
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read()){
            System.out.println(latestMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e){

            }
        }
    }
}
