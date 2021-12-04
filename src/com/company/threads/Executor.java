package com.company.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Executor service working...");
//            }
//        });
//
//        executorService.shutdown();
//    }

        public static void main(String[] args) {
            // Create a fixed thread pool of 2 threads.
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            List<Callable<String>> tasks = Arrays.asList(
                    // List of callable tasks that return results when done.
                    () -> {
                        System.out.println("Thread: " + Thread.currentThread().getName());
                        System.out.println("I'm shopping");
                        Thread.sleep(5000);
                        System.out.println("Thread: " + Thread.currentThread().getName() + ". Shopping done!");
                        return "Shopping done!";
                    },
                    () -> {
                        System.out.println("Thread: " + Thread.currentThread().getName());
                        System.out.println("Washing dishes");
                        Thread.sleep(2000);
                        System.out.println("Thread: " + Thread.currentThread().getName() + ". Dishes washed");
                        return "dishes washed";
                    },
                    () -> {
                        System.out.println("Thread: " + Thread.currentThread().getName());
                        System.out.println("Cleaning the room");
                        Thread.sleep(1000);
                        System.out.println("Thread: " + Thread.currentThread().getName() + ". Room cleaned");
                        return "Room cleaned";
                    }
            );
            try {
                // return the result of the first successful task.
                String firstResult = executorService.invokeAny(tasks);
                System.out.println("FIRST RESULT: " + firstResult);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            executorService.shutdown();
        }
}
