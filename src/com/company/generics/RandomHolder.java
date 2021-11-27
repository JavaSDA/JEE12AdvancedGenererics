package com.company.generics;

import java.util.ArrayList;
import java.util.List;

public class RandomHolder<T> {
    //  Define platform to hold items.
    private List<T> items = new ArrayList<>();

    // Create the add method to take an item of type T.
    public void add(T item) {
        items.add(item);
    }

    // Create the selectRandom()
    public T selectRandom() {
        return items.get((int) (Math.random() * items.size()));
    }

    public static void main(String[] args) {
        RandomHolder<String> randomHolder = new RandomHolder<>();

        // populate random holder
        for (String word : ("I am a boy").split(" ")) {
            randomHolder.add(word);
        }

        // concatenate random values random values returned as a string
        for (int i = 0; i < 10; i++) {
            System.out.print(randomHolder.selectRandom() + " ");
        }

    }

}
