package com.company.threads;


// Two ways to create a thread:

// First Way: Extend the thread class and override the run method.
// Java only supports single inheritance. Therefore, it could be a problem if
// you have another you actually want to extend.
//class HelloWorldThread extends Thread {
//    @Override
//    public void run() {
//        System.out.println("Hello World from another thread!");
//        System.out.println("HelloWorld Class thread id: " + Thread.currentThread().getId());
//    }
//}

import java.util.Random;

// Second Way: Implement the runnable interface.
class HelloWorldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World from another thread!");
        System.out.println("HelloWorld Class thread id: " + Thread.currentThread().getId());
    }
}

public class ThreadTest {
    public static void main(String[] args) {
//        new Thread(new HelloWorldRunnable()).start();
//        // lambda
//        new Thread(() -> System.out.println("Hello from another thread implemented using lambda")).start();
        ThreadTest threadTest = new ThreadTest();
        threadTest.start(5);

    }

    // The synchronized keyword on a method
    // causes that thread that called the method to have exclusive access to that method until
    // the thread terminates.
    // This means that for as many times as you call the Thread.currentThread.getName or getId
    // you'll get the same value.
    // because the method has been locked on to that thread until
    // it dies.
    public synchronized void start(int numberOfElements){
        // Create the random object
        Random random = new Random();
        // Create a loop with the constraint in the method parameter which is
        // the number of elements to be generated.
        for (int i=0;i< numberOfElements;i++){
            // The upper limit on integers created.
            int number= random.nextInt(49)+1;
            // output the thread name at the point of generation.
            System.out.println(Thread.currentThread().getName()+ "=" + "-=" +"> number " +
                (i+1)+" is: " + number);

            // also outputting the thread.
            String string = String.format("%s -> number %d is: %d\n",
                    Thread.currentThread().getName(), i+1, number);
            System.out.println(string);
        }
    }



}
