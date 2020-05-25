package com.rakeshv.demo3;

import java.util.concurrent.CountDownLatch;

public class CountdownLatches {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
    }
}

class Latch implements Runnable {
    private CountDownLatch countDownLatch;

    Latch(CountDownLatch latch) {
        this.countDownLatch = latch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
    }
}
