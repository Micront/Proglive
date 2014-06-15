package arhangel.dim.webinar;

/**
 *
 */
public class Basic {
    private static int INTEGER_SIZE = 32;

    public static String toBinaryString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append((n >> i) & 0x1);
        }
        return builder.toString();
    }

    public static boolean equalsFloat(float a, float b, double epsilon) {
        return Math.abs(a - b) <= epsilon;
    }


    public static void foo() {
        try {
            methodWithCheckedException();
        } catch (MyCheckedException e) {
            // handle exception
            e.printStackTrace();
        }
    }

    static void methodWithCheckedException() throws MyCheckedException {
        throw new MyCheckedException("My Exception");
    }

    static class MyCheckedException extends Exception {
        public MyCheckedException(String msg) {
            super(msg);
        }
    }


 }
