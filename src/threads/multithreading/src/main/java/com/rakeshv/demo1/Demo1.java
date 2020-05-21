package com.rakeshv.demo1;

public class Demo1 {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }
}

class Runner extends Thread {
    @Override
    public void run() {
        System.out.println("From thread " + Thread.currentThread().getName());
    }
}
