package arhangel.dim.generics;

import java.util.Collection;

/**
 *
 */
public class IntegerStack implements Stack<Integer> {

    public static final int DEFAULT_CAPACITY = 10;
    private Integer[] data;
    private int size;
    private int capacity;

    public IntegerStack() {
        data = new Integer[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public IntegerStack(int capacity) {
        this.capacity = capacity;
        data = new Integer[capacity];
        size = 0;
    }

    public Integer peek() {
        throw new UnsupportedOperationException("NIY");
    }

    public Integer pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty");
        }
        int e = data[size - 1];
        data[size - 1] = null;
        size--;
        return e;
    }

    public void push(Integer value) {
        if (size == data.length) {
            throw new RuntimeException("Stack is full");
        }
        size++;
        data[size - 1] = value;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void pushAll(Collection<Integer> src) {

    }

    @Override
    public void popAll(Collection<Integer> dst) {

    }
}
