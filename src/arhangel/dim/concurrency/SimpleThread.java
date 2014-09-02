package arhangel.dim.concurrency;

public class SimpleThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("MyThread: " + i);

                // пауза на 500 мсек
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            String[] numbers = {"one", "two", "three"};
            for (int i = 0; i < numbers.length; i++) {
                System.out.println("MyTask: " + numbers[i]);

                // пауза
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {

        Thread t1 = new MyThread();

        Runnable task = new MyTask();
        Thread t2 = new Thread(task);


        // Start tasks in new threads
        t1.start();

        // waiting for t1
        //t1.join();


        t2.start();


        // In current thread
        //t1.run();


    }



}
