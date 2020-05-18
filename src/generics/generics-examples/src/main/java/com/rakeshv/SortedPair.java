package com.rakeshv;

public class SortedPair<T extends Comparable<T>> {
    private T first;
    private T second;

    public SortedPair(final T l, final T r) {
        if (l.compareTo(r) < 0) {
            this.first = l;
            this.second = r;
        } else {
            this.first = r;
            this.second = l;
        }
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "SortedPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
