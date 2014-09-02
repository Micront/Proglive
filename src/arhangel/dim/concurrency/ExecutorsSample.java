package arhangel.dim.concurrency;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsSample {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);
/*
        for (int i = 0; i < 20; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Done!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
*/
        ExecutorService cached = Executors.newCachedThreadPool();
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future f = cached.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Some string";
                }
            });
            futureList.add(f);

        }
        for (Future future : futureList) {
            System.out.println(future.get());
        }
    }
}
