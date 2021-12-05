package com.test;

import com.helloworld.HelloWorld;

public class Test {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }
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
