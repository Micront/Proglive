package arhangel.dim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created on 13/08/14.
 */
public class Main {
    int a;

    static class Nested {
        int b;
    }

    class Inner {
        int a;

        void foo() {
            this.a = 10; // Inner
            Main.this.a = 12; // Main
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, Integer.MAX_VALUE};
        System.out.println(binarySearch(a, 1));

    }

    static int binarySearch(int[] arr, int num) {
        if (arr.length == 0) return -1;
        int a = 0;
        int b = arr.length - 1;
        if (arr[a] == num) return a;
        if (arr[b] == num) return b;
        for (; ; ) {
            System.out.println("a = " + a + " b = " + b);
            if (arr[(b + a) / 2] > num) {
                b = (b + a) / 2;
            } else {
                a = (b + a) / 2;
            }
            if (arr[a] == num) return a;
            if (arr[b] == num) return b;
            if (b - a < 2) return -1;
        }
    }
}
