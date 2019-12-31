import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLocks
 */
public class ReadWriteLocks {

    ReadWriteLock readWriteLock;
    Lock readLock;
    Lock writeLock;

    HashMap<Integer, Integer> map;
    ReadWriteLocks() {
        readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        ReadWriteLocks readWriteLocks = new ReadWriteLocks();
        Runnable read = () -> readWriteLocks.read();
        Runnable write = () -> readWriteLocks.write();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(write);
        executorService.submit(read);
    }

    public void write() {
        try {
            writeLock.lock();
            map.put(1, 1);
        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }
    }

    public void read() {
        try {
            readLock.lock();
            map.get(1);
        } catch(Exception e) {

        } finally {
            readLock.unlock();
        }
    }
}