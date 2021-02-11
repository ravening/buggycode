package com.example.reflection.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    protected String firstName;
    String lastName;
    private int age;
    public int publicAge;

    private void dummyFunction() {
        this.publicAge = 21;
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Person of(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }
}
