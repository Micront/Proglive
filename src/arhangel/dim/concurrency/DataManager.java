package arhangel.dim.concurrency;

public class DataManager {
    private static boolean ready = false;

    // Thread #1
    public void sendData() {
        while (!ready) {
            // waiting
            System.out.println("Waiting for data...");
        }

        // continue execution and sending data
        System.out.println("Sending data...");
    }


    // Thread #2
    public void prepareData() {
        System.out.println("Data prepared");
        ready = true;
    }
}