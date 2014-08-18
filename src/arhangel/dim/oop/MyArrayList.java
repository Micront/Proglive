package arhangel.dim.oop;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created on 13/08/14.
 */
public class MyArrayList<T> extends ArrayList<T> {
    private String name = "";

    public Iterator<T> reverseIterator() {
        return new ReverseIterator<>();
    }

    private class ReverseIterator<T> implements Iterator<T> {
        private int cursor = size() - 1;

        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }

        @Override
        public T next() {
            @SuppressWarnings("unchecked")
            T e = (T) get(cursor);
            cursor--;
            return e;
        }
    }

    public static void main(String[] args) {
        MyArrayList<String> strings = new MyArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        Iterator<String> iter = strings.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
