package com.rakeshv;

public class IntegerCircularBuffer extends GenericCircularBuffer<Integer> {
    public IntegerCircularBuffer() {
        super();
    }

    @Override
    public Integer getResult() {
        int sum = 0;

        Integer tmp;
        while ((tmp = poll()) != null) {
            sum += tmp;
        }

        return sum;
    }
}
