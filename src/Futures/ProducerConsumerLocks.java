package src.Futures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerConsumerLocks
 */
public class ProducerConsumerLocks {
    Lock lock;
    Condition isFull;
    Condition isEmpty;
    AtomicInteger count;
    List<Integer> buffer;

    ProducerConsumerLocks() {
        lock = new ReentrantLock();
        isFull = lock.newCondition();
        isEmpty = lock.newCondition();
        buffer = new ArrayList<>(10);
        count = new AtomicInteger(0);
    }

    public static void main(String[] args) throws Exception {
        ProducerConsumerLocks object = new ProducerConsumerLocks();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        try {
            List<Callable> producers = new ArrayList<>();
            List<Callable> consumers = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                producers.add(i, object::producer);
                consumers.add(i, object::consumer);
            }

            List<Callable<String>> producersAndConsumers = new ArrayList<>();
//            producersAndConsumers.addAll((Collection<? extends Callable<String>>) consumers);
//            producersAndConsumers.addAll((Collection<? extends Callable<String>>) producers);

            List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
            futures.forEach(
                future -> {
                    try {
                        future.get();
                    } catch (Exception e) {}
                }
            );
        } catch (Exception e) {

        } finally {
            executorService.shutdown();
        }
    }

    public String producer() {
        while (count.get() < 10) {
            try {
                lock.lock();
                // wait till buffer is not full
                while (isFull()) {
                    isFull.await();
                }

                Random random = new Random();
                buffer.add(random.nextInt(10));
                count.getAndIncrement();
                System.out.println("Thread: " + Thread.currentThread().getName() + " producing " + count);
                isEmpty.signalAll();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }

        return "";
    }

    public String consumer() {
        while (count.get() < 10) {
            try {
                lock.lock();
                while (isEmpty()) {
                    isEmpty.await();
                }

                count.getAndDecrement();
                buffer.remove(buffer.size() - 1);
                System.out.println("Thread: " + Thread.currentThread().getName() + " consuming " + count);
                isFull.signalAll();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }

        return "";
    }

    public boolean isFull() {
        return buffer.size() == 10;
    }

    public boolean isEmpty() {
        return buffer.size() == 0;
    }
}
