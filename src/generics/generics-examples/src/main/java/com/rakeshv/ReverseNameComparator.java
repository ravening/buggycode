package com.rakeshv;

import java.util.Comparator;

public class ReverseNameComparator<T> implements Comparator<T> {
    private final Comparator<T> reverseNameComparator;

    public ReverseNameComparator(Comparator<T> reverseNameComparator) {
        this.reverseNameComparator = reverseNameComparator;
    }

    @Override
    public int compare(T o1, T o2) {
        return -1 *reverseNameComparator.compare(o1, o2);
    }
}
