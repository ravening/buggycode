import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * BlockingQueueDemo
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);

        class Consumer implements Callable<String> {
        
            public String call() throws InterruptedException {
                int count = 0;
                while (count++ < 50) {
                    queue.take();
                }

                return Thread.currentThread().getName() + " Consumed " + (count -1) + " elements";
            }
        }

        class Producer implements Callable<String> {
        
            public String call() throws InterruptedException {
                int count = 0;
                while(count++ < 50) {
                    queue.put(Integer.toString(count));
                }

                return Thread.currentThread().getName() + " Produced " + (count - 1)  + " elements";
            }
        }

        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            producersAndConsumers.add(new Producer());
        }

        for (int i = 0; i < 2; i++) {
            producersAndConsumers.add(new Consumer());
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);

        futures.forEach(future -> {
                try {
                    System.out.println(future.get());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    executorService.shutdown();
                }
            }
        );
    }
}