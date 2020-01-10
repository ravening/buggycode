import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountdownlatchDemo
 */
public class CountdownlatchDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            completionService.submit(new Worker(latch));
        }

        for (int i = 0; i < 10; i++) {
            // completionService.take().get();
        }
        latch.await();
        System.out.println("All completed");
        pool.shutdown();
    }

}

class Worker implements Callable<String> {
    CountDownLatch latch;
    Worker(CountDownLatch l) {
        this.latch = l;
        
    }

    @Override
    public String call() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " completed");
        this.latch.countDown();
        return "";
    }
}