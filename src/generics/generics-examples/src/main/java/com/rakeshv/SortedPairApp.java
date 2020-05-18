package com.rakeshv;

public class SortedPairApp {
    public static void main(String[] args) {
        SortedPair<Integer> sortedPair = new SortedPair<>(1, 2);
        System.out.println(sortedPair);

        sortedPair = new SortedPair<>(5, 1);
        System.out.println(sortedPair);

    }
}
