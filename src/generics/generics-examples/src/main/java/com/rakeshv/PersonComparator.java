package com.rakeshv;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonComparator {
    public static void main(String[] args) {
        Person person = new Person(33, "D");
        Person person1 = new Person(30, "Z");
        Person person2 = new Person(62, "C");
        Person person3 = new Person(56, "A");
        Person person4 = new Person(33, "B");

        List<Person> personList = Arrays.asList(person, person1, person2, person3, person4);

        Collections.sort(personList, new AgeComparator());

        for (Person person5 : personList) {
            System.out.println(person5);
        }

        personList = Arrays.asList(person, person1, person2, person3, person4);

        Collections.sort(personList, new PersonNameComparator());

        System.out.println("======");
        for (Person person5 : personList) {
            System.out.println(person5);
        }
    }
}
