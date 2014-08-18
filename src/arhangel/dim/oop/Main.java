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
        Main m = new Main();

        Inner in = m.new Inner();

        Nested n = new Nested();

        List l = new ArrayList<>();
        Collections.sort(l, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

    }
}
