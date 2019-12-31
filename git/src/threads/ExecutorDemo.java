package threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ExecutorDemo
 */
public class ExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println("Hello world from " + Thread.currentThread().getName());
        //executor.submit(runnable);

        
        Callable<String> callable = () -> {
            Lock lock = new ReentrantLock(true);
            try {
                lock.lock();
                return "hello from callable " + Thread.currentThread().getName();
            } finally {
                lock.unlock();
            }
             };
        Future<String> future = executor.submit(callable);

        //while (!future.isDone()) {}
        //System.out.println(future.get());
        executor.shutdown();

        ExecutorService fService = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(fService.submit(callable))
            ;
        }

        System.out.println("array size is " + arrayList.size());
        for (int i = 0 ;i< arrayList.size(); i++) {
            while (!arrayList.get(i).isDone()) {}
            System.out.println(arrayList.get(i).get());
        }
        fService.shutdown();
    }
}