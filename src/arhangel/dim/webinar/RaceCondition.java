package arhangel.dim.webinar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class RaceCondition {
    static Logger logger = LoggerFactory.getLogger(RaceCondition.class);

    static int counter;

    public static void main(String[] args) throws InterruptedException {
        counter = 0;
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        logger.info("Counter: {}", counter);
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter++;
                //inc();
            }
        }
    }

    static synchronized void inc() {
        counter++;
    }
}
