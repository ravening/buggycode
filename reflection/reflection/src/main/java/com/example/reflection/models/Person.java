package com.example.reflection.models;

import com.example.reflection.models.annotation.Column;
import com.example.reflection.models.annotation.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @PrimaryKey
    private long id;

    @Column
    protected String firstName;

    @Column
    String lastName;

    @Column
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
