package arhangel.dim.abstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by dmirty on 01/09/14.
 */
public class Main {



    class Test {
        final int var = 10;

        public Test() {
            //var = 10;
        }
    }


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");

        Map<String, String> map = new HashMap<>();

        // id - Long, person - Person

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> str = Arrays.asList("one", "two", "three");

        Iterator iter = numbers.iterator();
        while (iter.hasNext()) {
            Object o = iter.next();
        }

        for (Integer integer : numbers) {

        }



    }

    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }





}
