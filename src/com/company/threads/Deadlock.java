package com.company.threads;

public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        // available resources
        final String r1 = "r1";
        final String r2 = "r2";

        // Create a new thread
        // TODO: use this for fp.
        // Thread 1
        Thread t1 = new Thread() {
            // override its run method
            @Override
            public void run() {
                // start with different resources
                synchronized (r1) {
                    System.out.println("Thread 1: locked r1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (r2) {
                        System.out.println("Thread 1: locked r2");
                    }
                }
            }
        };

        // Thread 2
        Thread t2 = new Thread() {
            // override its run method
            @Override
            public void run() {
                // start with a different resource from the previous thread.
                synchronized (r2) {
                    System.out.println("Thread 2: locked r1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (r1) {
                        System.out.println("Thread 2: locked r2");
                    }
                }
            }
        };

        // Start the thread execution
        t1.start();
        t2.start();

        // Wait for the threads to die i.e. join back to the main thread.
        t1.join();
        t2.join();

        System.out.println("Exiting... The code may never reach this line, because threads are unlikely to join.");
    }
}
