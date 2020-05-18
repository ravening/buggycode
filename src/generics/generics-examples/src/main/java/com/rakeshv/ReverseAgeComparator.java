package com.rakeshv;

import java.util.Comparator;

public class ReverseAgeComparator<T> implements Comparator<T> {
    private final Comparator<T> reverseCompator;

    public ReverseAgeComparator(Comparator<T> reverseCompator) {
        this.reverseCompator = reverseCompator;
    }

    @Override
    public int compare(T o1, T o2) {
        return -1 * reverseCompator.compare(o1, o2);
    }
}
