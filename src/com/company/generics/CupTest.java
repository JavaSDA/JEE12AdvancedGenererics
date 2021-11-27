package com.company.generics;

public class CupTest {
    public static void main(String[] args) {
        // parameterization

        Cup<Integer> integerCup = new Cup<>(3);

//        System.out.println(integerCup.getLiquid());

        integerCup.drink();
        Cup<String> stringCup = new Cup<>("Coca-Cola");

//        System.out.println(stringCup.getLiquid());
        stringCup.drink();

    }
}
