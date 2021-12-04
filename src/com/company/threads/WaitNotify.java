package com.company.threads;

public class WaitNotify {

//    private boolean isDinnerReady = true;
//
//
//    public synchronized void waitForDinner() throws InterruptedException {
//        while (isDinnerReady) {
//            wait();
//        }
//        System.out.println("Enjoy your meal");
//    }
//
//
//    public synchronized void prepareDinner() {
//        System.out.println("Dinner is being prepared");
////        isDinnerReady = true;
//        notify();
//    }
//
//    public static void main(String[] args) {
//        WaitNotify waitNotify = new WaitNotify();
//        Thread t1 = new Thread() {
//            public void run() {
//                try {
//                    waitNotify.waitForDinner();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        t1.start();
//
//        Thread t2 = new Thread() {
//            public void run() {
//                waitNotify.prepareDinner();
//            }
//        };
//        t2.start();
//    }

    private int amount = 1000;

    public synchronized void withdraw(int amount) {
        System.out.println("making a withdrawal...");

        // If the available amount is less than the amount to withdraw,
        // then wait for a deposit.
        if (this.amount < amount) {
            System.out.println("Insufficient balance. Waiting for a deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.amount -= amount; // remove the amount from the balance

        System.out.println("withdrawal complete");
    }

    public synchronized void deposit(int amount) {
        System.out.println("Making a deposit...");

        this.amount += amount;
        System.out.println("deposit completed...");
        notify(); // since we have a method waiting for a deposit then we notify
        // to complete the process.
    }

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify();
        new Thread() {
            public void run() {
                waitNotify.withdraw(5000);
            }
        }.start();

        new Thread() {
            public void run() {
                waitNotify.deposit(10000);
            }
        }.start();
    }
}


