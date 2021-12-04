package com.company.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callables implements Callable {

    // The call() returns a result (error or actual value) after execution while
    // the run() doesn't.
    public Integer call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        // sleep the thread for a random amount of time.
        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }

    public static void main(String[] args) {
//        Callables callables = new Callables();
//        try {
//            System.out.println(callables.call());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Create an array of future tasks
        // The FutureTask class allows us to hold store values that may not
        // be ready or available at the time the method is called so whenever the value
        // is ready then it is returned to wherever it is being called.
        FutureTask[] randomValuesTasks = new FutureTask[4];

        // Loop through the array and call the call() on each task.
        for (int i = 0; i < randomValuesTasks.length; i++) {
            Callables callables = new Callables();

            randomValuesTasks[i] = new FutureTask(callables);

            Thread thread = new Thread(randomValuesTasks[i]);
            thread.start();
        }

        // Output the values.
        for (int i = 0; i < randomValuesTasks.length; i++) {
            try {
                System.out.println("Future value: " + randomValuesTasks[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
