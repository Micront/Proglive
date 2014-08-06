package arhangel.dim.webinar;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class SemaphoreDeadlock {


    static class Task implements Runnable {
        Semaphore s1;
        Semaphore s2;

        public Task(Semaphore s1, Semaphore s2) {
            this.s1 = s1;
            this.s2 = s2;
            try {
                System.out.println("Acquire first");
                s1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                System.out.println("Acquire second");
                s2.acquire();
                System.out.println("Never seen");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        new Thread(new Task(semaphore1, semaphore2)).start();
        new Thread(new Task(semaphore2, semaphore1)).start();
    }
}
