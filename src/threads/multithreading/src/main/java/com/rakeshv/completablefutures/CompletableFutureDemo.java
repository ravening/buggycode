package main.java.com.rakeshv.completablefutures;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Executing from thread " +
             Thread.currentThread().getName());
        };

        CompletableFuture completableFuture =
            CompletableFuture.runAsync(runnable);
        
        System.out.println("From main");
        completableFuture.join();
    }
}