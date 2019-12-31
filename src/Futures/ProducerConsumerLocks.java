import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProducerConsumerLocks
 */
public class ProducerConsumerLocks {
    Lock lock;
    Condition notFull;
    Condition notEmpty;
    AtomicInteger count;
    ArrayList<Integer> buffer;
    ProducerConsumerLocks() {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        buffer = new ArrayList<>(10);
        count = new AtomicInteger(0);
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumerLocks object = new ProducerConsumerLocks();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
        Runnable producer = () -> object.producer();
        Runnable consumer = () -> object.consumer();
        
            executorService.submit(producer);
            executorService.submit(consumer);
        } catch (Exception e) {}
    }

    public void producer() {
        while (true) {
            try {
                // lock.lock();

                // wait till buffer is not full
                while (isFull()) {
                    notFull.await();
                }

                try {
                    // Thread.sleep(2000);
                } catch (Exception e) {}
                Random random = new Random();
                buffer.add(random.nextInt(10));
                count.getAndIncrement();
                System.out.println("Thread: " + Thread.currentThread().getName() + " producing " + count);
                notEmpty.signal();
            } catch (Exception e) {
            } finally {
                // lock.unlock();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                // lock.lock();
                while (isEmpty()) {
                    notEmpty.await();
                }
                try {
                // Thread.sleep(6000);
                } catch (Exception e) {}
                count.decrementAndGet();
                buffer.remove(count.get());
                System.out.println("Thread: " + Thread.currentThread().getName() + " consuming " + count);
                notFull.signal();
            } catch (Exception e) {
            } finally {
                // lock.unlock();
            }
        }
    }

    public boolean isFull() {
        return count.get() == 10;
    }

    public boolean isEmpty() {
        return count.get() == 0;
    }
}