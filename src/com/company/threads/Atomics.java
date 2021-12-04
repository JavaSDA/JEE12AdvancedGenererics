package com.company.threads;

import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {
    // We use atomic integer to reduce the risk of
    // possibly overwriting a variable or value while using threads,
    // in order to maintain consistent results.
    AtomicInteger count;
    public Counter() {
        count = new AtomicInteger();
    }

    public void run() {
        // increment the counter
        for (int i = 0; i < 1000; i++) {
            count.addAndGet(1);
        }
    }
}

public class Atomics {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(counter, "First Thread");
        Thread t2 = new Thread(counter, "Second Thread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The value is: " + counter.count);
    }
}
