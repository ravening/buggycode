package com.rakeshv;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().equalsIgnoreCase(o2.getName())) return 0;
        return o1.getName().compareTo(o2.getName()) < 0 ? -1 : 1;
    }
}
