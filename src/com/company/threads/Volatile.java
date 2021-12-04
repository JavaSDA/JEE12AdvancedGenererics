package com.company.threads;



class VolatileData { // Create a class with a volatile value.
    private volatile int counter = 0; // you can think of this as a keyword for
    // atomic values without calling the atomic data types directly.

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        ++counter;
    }
}

// The run method here is going to get the old value and
// the updated value when the thread starts executing.
class VolatileThread extends Thread {
    private final VolatileData data;

    public VolatileThread(VolatileData data) {
        this.data = data;
    }

    public void run() {
        int oldValue = data.getCounter();
        System.out.println("[Thread " + Thread.currentThread().getId() + "]: Old value = " + oldValue);

        data.increaseCounter();

        int newValue = data.getCounter();
        System.out.println("[Thread " + Thread.currentThread().getId() + "]: New value = " + newValue);

    }
}

public class Volatile {
    public static void main(String[] args) throws InterruptedException {
        // The volatile keyword is used to modify the value of a variable,
        // by different threads.
        VolatileData volatileData = new VolatileData();
        Thread[] threads = new Thread[2];

        // Loop through and add VolatileThreads to the threads[]
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new VolatileThread(volatileData);
        }

        // Start all threads.
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        // Wait for all threads to join.
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

    }
}
