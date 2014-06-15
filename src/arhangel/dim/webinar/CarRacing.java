package arhangel.dim.webinar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CarRacing {
    private static final int COUNT = 4;
    private static final Object fillPool = new Object();
    private static final Object startRace = new Object();
    private static boolean isReady = false;
    private static List<Car> carPool = new ArrayList<>(COUNT);

    static class Car implements Runnable {
        @Override
        public void run() {

            synchronized (fillPool) {
                carPool.add(this);
                System.out.println("Car registered");
                fillPool.notifyAll();
            }

            synchronized (startRace) {
                while (!isReady) {
                    try {
                        startRace.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Start!");
                }
            }
        }
    }

    static class Flag implements Runnable {
        @Override
        public void run() {
            synchronized (fillPool) {
                while (carPool.size() != COUNT) {
                    try {
                        fillPool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("Pool is full!");
            synchronized (startRace) {
                startRace.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Flag());
        t.start();

        for (int i = 0; i < COUNT; i++) {
            new Thread(new Car()).start();
        }
    }

}
