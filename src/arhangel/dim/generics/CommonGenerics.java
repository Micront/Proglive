package arhangel.dim.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class CommonGenerics {

    // PECS

    public static void produce(List<? extends Number> numbers) {
        // reading
        // Integer i = numbers.get(0); // compile error
        Number n = numbers.get(0);
        Object o = numbers.get(0);

        // writing
        // numbers.add(new Integer(10)); // compile error
        // numbers.add(new Object()); // compile error
    }

    public static <T extends Number> void process(List<T> numbers) {
        // reading
        // Integer i = numbers.get(0); // compile error
        Number n = numbers.get(0);
        Object o = numbers.get(0);
        T t = numbers.get(0);

        // writing
        // numbers.add(new Integer(10)); // compile error
        // numbers.add(new Object()); // compile error
        numbers.add(t);
    }

    public static void printAll(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void consume(List<? super Integer> numbers) {
        // reading
        // Integer i = numbers.get(0); // compile error
        // Number n = numbers.get(0); // compile error
        Object o = numbers.get(0);

        // writing
        Number n = 100.0f;
        numbers.add(new Integer(10));
        // numbers.add(n); // compile error
    }

    // Unbounded
    public static void printList(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1, 2, 3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }

    public static void inheritance() {
        List<String> strList = new ArrayList<>();
        // List<Object> objList = strList; // compile error

        List list = new ArrayList();
        list = strList;
        list.add(100); // ok

        for (Object o : list) {
            String s = (String) o; // runtime error

        }

    }

    static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return false;
    }


}
