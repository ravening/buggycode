package com.example.reflection.models;

import com.example.reflection.models.annotation.Column;
import com.example.reflection.models.annotation.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Person {
    @PrimaryKey
    @Id
    @GeneratedValue
    private long id;

    @Column
    protected String firstName;

    @Column
    String lastName;

    @Column
    private int age;

    @Transient
    public String nickname;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Person of(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }
}
