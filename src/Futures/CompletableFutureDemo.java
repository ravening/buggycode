package Futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * CompletableFutureDemo
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        try {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
                System.out.println("Hello world from the thread " + Thread.currentThread().getName());
            };
    
            Supplier<String> supplier = () -> {
                return "Hello world from the supplier " + Thread.currentThread().getName();
            };

            CompletableFuture<String> supply = CompletableFuture.supplyAsync(supplier, service);
            CompletableFuture<Void> future = CompletableFuture.runAsync(runnable, service);
        
            supply.join();
            future.join();
            System.out.println(supply.get());
        } catch (Exception e) {

        }
       
    }
}