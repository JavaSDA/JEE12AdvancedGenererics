package com.company.generics;

// Limiting parameter types.
// Using the extends key word we can set a constraint on
// the types of Classes that can be used on our Generic class.

// T - type
// E - Element
// ? - Wildcard

// <? extends Number> - all subclasses of number. N.B.: when you use this, you may be creating a readonly value.
// <?> - for any value (Read only as well).
// assess the type


// <? super Boolean> - all super types of T.  - (Most Important).

public class NumberBox <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        NumberBox<? super Number> doubleBox = new NumberBox<>();
        doubleBox.setValue(4);
        System.out.println("double box value: " + doubleBox.getValue());
    }
}
