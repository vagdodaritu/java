import java.util.concurrent.*;

public class ThreadPoolRunner {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int id = i;
            pool.submit(() -> {
                System.out.println("Task " + id + " executed by " + Thread.currentThread().getName());
                try { Thread.sleep(30); }
                catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }
        pool.shutdown();
        if (pool.awaitTermination(5, TimeUnit.SECONDS))
            System.out.println("All tasks completed.");
        else System.out.println("Timed out waiting for tasks.");
    }
}