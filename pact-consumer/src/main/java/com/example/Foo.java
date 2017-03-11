package com.example;

public class Foo {

    private int value;

    public Foo() {
    }

    public Foo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foo foo = (Foo) o;

        if (value != foo.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
