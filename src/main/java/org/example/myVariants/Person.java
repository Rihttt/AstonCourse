package org.example.myVariants;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
       return 123;
    }


}
