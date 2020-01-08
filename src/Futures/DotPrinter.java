import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DotPrinter implements AutoCloseable {

    private final ScheduledExecutorService timer =
                Executors.newSingleThreadScheduledExecutor();
        
        public void DotPrinter() {
            timer.scheduleAtFixedRate(() -> {
                System.out.println(".");
            }, 1, 1, TimeUnit.SECONDS);
        }

        public void customSleep(int sleepTime) throws InterruptedException {
            TimeUnit.SECONDS.sleep(sleepTime);
        }
        
        public void close() {
            timer.shutdown();
        }
}
