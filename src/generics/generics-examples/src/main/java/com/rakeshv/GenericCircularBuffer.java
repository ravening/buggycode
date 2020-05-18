package com.rakeshv;

public abstract class GenericCircularBuffer<T> {
    protected int writeCursor = 0;
    protected int readCursor = 0;
    protected final T[] buffer;

    @SuppressWarnings("unchecked")
    public GenericCircularBuffer(int size) {
        this.buffer = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public GenericCircularBuffer() {
        this.buffer = (T[]) new Object[10];
    }
    public boolean offer(T value) {
        if (buffer[writeCursor] != null) {
            return false;
        }

        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    public T poll() {
        T value = buffer[readCursor];

        if (value != null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }

        return value;
    }

    public int next(int index) {
        return (index + 1) % buffer.length;
    }

    public abstract T getResult();
}
