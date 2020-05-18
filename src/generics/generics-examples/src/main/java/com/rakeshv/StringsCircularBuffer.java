package com.rakeshv;

public class StringsCircularBuffer extends  GenericCircularBuffer<String> {

    public StringsCircularBuffer() {
        super();
    }

    public StringsCircularBuffer(int size) {
        super(size);
    }

    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();

        String value;
        while ((value = poll()) != null) {
            sb.append(value).append(" ");
        }

        return sb
                .toString();
    }
}
