package com.company.functions;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface // This annotation tells the compiler and the user that the interface is
    // a Single Abstract Method (SAM) interface.
interface SingleAbstract {
    int add(int x, int y);

    default int min(int x, int y) {
//        return x < y ? x : y;
        return Math.min(x, y); // Return the minimum value entered.
    }

    default String hello() {
        return "Hello";
    }
}

public class Functions implements SingleAbstract {

    // When dealing with the functional programming paradigm,
    // functions are king. You can create an object in a function,
    // pass an object to a function, return objects and functions from a function.

    @Override
    public int add(int x, int y) {
        return x + y;
    }

//    public int min(int x, int y) {
//        return 6;
//    }

    public static void main(String[] args) {
//        Functions functions = new Functions();
//        System.out.println("Min Value: " + functions.min(4, 5));
//        System.out.println("Sum Value: " + functions.add(4, 5));

        // lambda expressions are anonymous functions.ie the functions do not
        // have names.

//        Thread thread = new Thread() {
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };

        // If the lambda expression contains only one line, then we can place the expression
        // in a single line. Also, we don't need to add a return keyword if a value is being returned
        // in such a scenario.

//        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
//
//        thread.start();
//
//        Thread thread1 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println("It worked");
//        });
//        thread1.start();

        // used to contain the value and can return it when needed.
//        Supplier<Double> randomValue = () -> Math.random() * 10;
//        System.out.println(randomValue.get());

        //Function<T,R> Functions take an input type T and return a type R.
//        Function<Integer, Double> half = (value) -> value / 2.0;
//
//        half = half.andThen(value -> 4 * value);
//
//        System.out.println(half.apply(5));
//
//
        // Consumers 'consume' the function and do not return anything.
        // Typically, you will want to use Consumers with functions that
        // return void.


//        Consumer<Integer> showNumber = num -> System.out.println(num);
//        showNumber.accept(9);


        // A consumer to multiply 2 to every member of a list.
//        Consumer<List<Integer>> numbersMult = list -> {
//            for (int i = 0; i < list.size(); i++) {
//                list.set(i, 2 * list.get(i)); // multiply 2 by the element at a given index.
//            }
//            System.out.println(list); // output the list.
//        };
//
//        // create a list to hold numbers.
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//
//        numbersMult.accept(numbers);


//        Predicate<Integer> lessThan = num -> num < 18;
//
////
////        System.out.println(lessThan.test(23));
//
//        checkValue(7, lessThan);

//        String[] words = new String[10];
//        words[5] = "hello";
//        Optional<String> checkNullValue = Optional.ofNullable(words[5]); // place the value likely to
        // produce null inside an optional.
//        if (checkNullValue.isPresent()) {
//            String word = words[5].toLowerCase();
//            System.out.println(word);
//        } else {
//            System.out.println("Word is null");
//        }

//        checkNullValue.ifPresent(word -> System.out.println(word.toLowerCase()));
        List<Integer> numbers = Arrays.asList(23, 44, 88, 93, 24);

        System.out.println(numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(value -> value * 2)
                .sum()
        );

    }

    private static void checkValue(int number, Predicate<Integer> predicate) {
        if (predicate.test(number)) {
            System.out.println("value passed test");
        }
    }

}
