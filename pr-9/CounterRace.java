class Counter {
    private int value = 0;
    synchronized void increment() { value++; }
    int getValue() { return value; }
}
public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) counter.increment();
            }, "Worker-" + (i + 1));
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();
        System.out.println("Expected count: 50000");
        System.out.println("Actual count:   " + counter.getValue());
        System.out.println("Synchronized increment prevents lost updates.");
    }
}