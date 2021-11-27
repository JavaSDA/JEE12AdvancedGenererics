package com.company.generics;

public class PairGenerator {
    public static void main(String[] args) {
        final Pair<Integer, String> firstPair = generatePair(1, "firstValue");
        final Pair<Double, String> secondPair = generatePair(2.0, "secondPair");

        System.out.println("Key: " + firstPair.getKey() + ", Value: " + firstPair.getValue());
        System.out.println("Key: " + secondPair.getKey() + ", Value: " + secondPair.getValue());
    }

    // Format for defining generic methods.
    public static <K, V> Pair<K, V> generatePair(K key, V value) {
        Pair<K, V> pair = new Pair<>();
        pair.setKey(key);
        pair.setValue(value);
        return pair;
    }

}
