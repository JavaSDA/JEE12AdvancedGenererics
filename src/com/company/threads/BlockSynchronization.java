package com.company.threads;

public class BlockSynchronization {
    public static void main(String[] args) {
        final Pair pair = new Pair(0, 0);
        new Thread(new DummyPairIncrementer(pair)).start();
        new Thread(new DummyPairIncrementer(pair)).start();
    }
}

class Pair {
    private Integer left;
    private Integer right;

    public Pair(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }

    // method synchronization
//    public synchronized void incrementLeft() {
//        left++;
//    }

    //    public synchronized void incrementRight() {
//        right++;
//    }

    // block synchronization
    public void incrementLeft() {
        System.out.println("Out of synchronized block");
        synchronized (this) {
            left++;
            System.out.println("In synchronized block: incrementLeft");
        }
        System.out.println("Out of synchronized block");
        System.out.println();
    }

    public void incrementRight() {
        System.out.println("Out of synchronized block");
        synchronized (this) {
            right++;
            System.out.println("In synchronized block: incrementRight");
        }
        System.out.println("Out of synchronized block");
        System.out.println();
    }



}

class DummyPairIncrementer implements Runnable {
    private final Pair pair;

    public DummyPairIncrementer(final Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            pair.incrementLeft();
            pair.incrementRight();
        }

        System.out.println("Pair Left: " + pair.getLeft() + ", Pair Right: " + pair.getRight());
    }
}
