package com.company;

public class Main {

    public static void main(String[] args) {

        // Exercises:

        // Task 1: 25 mins.
        // Create a class called RandomHolder and add generics such that it
        // can hold any type of data entered into it.
        // Add an addItem() that allows the user to add items to the object.
        // the addItem() takes in one item at a time.
        // Add a method called selectRandom(), that returns a random object/value,
        // contained in the object at runtime.


        // Create a Map<String,Integer>. Get words from a file.
        // Count the words as you read them in, and for each word in the file,
        // record in the use the integer the word count associated with that word,
        // that is the number of times that word appeared in the text in the file.

        // 30 mins.
        // You have a text file with content in it. Create a program that will open that
        // text file, and read each line as a String. Then place each String in a linkedList,
        // and at the end of the file read, print the linkedList in reverse order on your console.


        // 10 mins.
        // Replicate the last activity with a character buffer CharBuffer.

    }


    // Principles of a good module.
    // 1. Strong Encapsulation - You should be able to properly expose
    // only needed interactions with the user or method that called the module.

    // 2. Stable Abstraction - You should be able to create an interface
    // for public use, that enables changes made, to be easily viewed by the
    // public.

    // 3. Dependencies - You need to be able to declare or define the
    // dependencies for your application. Modules can depend on other modules
    // as well.
}
