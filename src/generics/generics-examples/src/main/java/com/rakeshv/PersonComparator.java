package com.rakeshv;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonComparator<T> {
    public static void main(String[] args) {
        Person person = new Person(33, "D");
        Person person1 = new Person(30, "Z");
        Person person2 = new Person(62, "C");
        Person person3 = new Person(56, "A");
        Person person4 = new Person(33, "B");

        List<Person> personList = Arrays.asList(person, person1, person2, person3, person4);

        Person youngest = youngestPerson(personList, new AgeComparator());
        System.out.println("Youngest person is " + youngest);
        System.out.println("======");

        Person senior = seniorPerson(personList, new ReverseAgeComparator<>(new AgeComparator()));
        Collections.sort(personList, new AgeComparator());
        System.out.println("Senior most person is " + senior);
        System.out.println("======");

        for (Person person5 : personList) {
            System.out.println(person5);
        }

        System.out.println("======");
        Collections.sort(personList, new ReverseAgeComparator<>(new AgeComparator()));
        for (Person person5 : personList) {
            System.out.println(person5);
        }

        personList = Arrays.asList(person, person1, person2, person3, person4);

        Collections.sort(personList, new PersonNameComparator());

        System.out.println("======");
        for (Person person5 : personList) {
            System.out.println(person5);
        }

        Collections.sort(personList, new ReverseNameComparator<>(new PersonNameComparator()));

        System.out.println("======");
        for (Person person5 : personList) {
            System.out.println(person5);
        }
    }

    public static <T> T youngestPerson(List<T> personList, Comparator<T> comparator) {
        if (personList == null || personList.isEmpty()) {
            System.out.println("Pass the person list");
        }

        T lowestFound = personList.get(0);

        for (int i = 1; i < personList.size(); i++) {
            final T person = personList.get(i);
            if (comparator.compare(person, lowestFound) < 0) {
                lowestFound = person;
            }
        }

        return lowestFound;
    }

    public static <T> T seniorPerson(List<T> personList, Comparator<T> comparator) {
        if (personList == null || personList.isEmpty()) {
            System.out.println("Pass the person list");
        }

        T senior = personList.get(0);

        for (int i = 1; i < personList.size(); i++) {
            T person = personList.get(i);
            if (comparator.compare(senior, person) > 0) {
                senior = person;
            }
        }

        return senior;
    }
}
