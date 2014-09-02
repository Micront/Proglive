package arhangel.dim.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThreads {

    static class Task extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println("in thread");

                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    // interrupt(); // set flag!

                    // close thread's resources
                    e.printStackTrace();
                    System.out.println("Catch an exception!");

                }

            }
        }
    }

    static class Task2 extends Thread {
        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // stop Task
        Thread t = new Task();
        t.start();

        // Другой способ поспать
        TimeUnit.SECONDS.sleep(1);

        t.interrupt();

        // запускаем другой поток
        Thread t2 = new Task2();
        t2.interrupt();
    }


}
