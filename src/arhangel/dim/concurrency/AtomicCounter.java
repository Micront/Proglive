package arhangel.dim.concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100_000; j++) {
                        counter.incrementAndGet();
                    }
                }
            });
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Counter=" + counter.get());

    }


}
