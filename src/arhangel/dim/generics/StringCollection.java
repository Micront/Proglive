package arhangel.dim.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dmirty on 29/07/14.
 */
public class StringCollection {
    public ArrayList<String> list;

    public void test() {
        list = new ArrayList<>();
        list.add("aaa");
        list.add("b");
        list.add("cd");
        //Collections.sort(list, new LengthComparator());
    }


    public static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
