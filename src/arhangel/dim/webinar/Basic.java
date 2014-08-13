package arhangel.dim.webinar;

import java.io.IOException;

/**
 *
 */
public class Basic {
    private static int INTEGER_SIZE = 32;


    // print binary representation of integer
    public static String toBinaryString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append((n >>> i) & 0x1);
        }
        return builder.toString();
    }


    // comparison with epsilon
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

    // My own exception class
    static class MyCheckedException extends Exception {
        public MyCheckedException(String msg) {
            super(msg);
        }
    }

    // How finally works
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (Exception e) {
            System.out.println("Catch");
            return;
        } finally {
            System.out.println("Finally");
        }
    }


}
