import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ExecutorCompletionServiceDemo
 */
public class ExecutorCompletionServiceDemo {

    public static void main(String[] args) throws Exception {
        DotPrinter dp = new DotPrinter();

        // Plain old executor service which waits for all the tasks to be completed
        ExecutorService pool = Executors.newCachedThreadPool();
        Collection<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int sleepTime = 5 - i % 5;
            int order = i;
            futures.add(pool.submit(() -> {
                TimeUnit.SECONDS.sleep(sleepTime);
                return order;
            }));
        }

        futures.forEach(future -> {
            try {
                System.out.println(" Job done is " + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Executorservice is completed.");
        Thread.sleep(4000);
        System.out.println("Starting ExecutionCompletionService");

        // ExecutorCompletionService uses a blocking queue which returns the tasks
        // as and when they are completed instead of waiting for all the tasks to be completed
        CompletionService<Integer> service = new ExecutorCompletionService<>(pool);
        for (int i = 0; i < 10; i++) {
            int sleepTime = 5 - i % 5;
            int order = i;
            service.submit(() -> {
                // TimeUnit.SECONDS.sleep(sleepTime);
                dp.customSleep(sleepTime);
                return order;
            });
        }

        for (int i =0; i < 10; i++) {
            System.out.println("Job done from " + service.take().get());
        }

        System.out.println("ExecutionCompletionService completed");
        Thread.sleep(5000);

        System.out.println("Starting CountingCompletionExecutionService");

        // Problem with ExecutorCompletionService is, it doesn't keep track of how many
        // tasks are submitted. So we extend that class to CountinCompletionService
        // which keeps track of numbers of tasks submitted
        CountingCompletionService<Integer> countingCompletionService = 
                new CountingCompletionService<>(pool);
        
        for (int i = 0; i < 10; i++) {
            int sleepTime = 5 - i % 5;
            int order = i;
            countingCompletionService.submit(() -> {
                dp.customSleep(sleepTime);
                return order;
            });
        }

        System.out.println("Total number of submitted tasks are " + countingCompletionService.getNumberOfSubmittedTasks());
        for (int i = 0; i < countingCompletionService.getNumberOfSubmittedTasks(); i++) {
            System.out.println("Job done from " + countingCompletionService.take().get());
            System.out.println("Number of pending tasks are " + (countingCompletionService.getNumberOfSubmittedTasks() -
                                                                countingCompletionService.getNumberOfCompletedTasks()));
            System.out.println("Number of completed tasks are " + countingCompletionService.getNumberOfCompletedTasks());
        }

        dp.close();
        pool.shutdown();
    }

    
}