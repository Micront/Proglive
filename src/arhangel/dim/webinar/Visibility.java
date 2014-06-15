package arhangel.dim.webinar;

/**
 *
 */
public class Visibility {
    static boolean isStopped = false;
    static int a;
    static int b;
    //static volatile  int b;

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                a = 10;
                b = 42;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (b != 42) ;
                System.out.println(a);
            }
        }).start();
    }

}
