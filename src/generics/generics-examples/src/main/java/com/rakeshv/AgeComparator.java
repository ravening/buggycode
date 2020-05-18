package com.rakeshv;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() == o2.getAge()) {
            return 0;
        }
        return o1.getAge() < o2.getAge() ? -1 : 1;
    }
}
