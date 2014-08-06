package arhangel.dim.generics;

import java.util.Collection;

/**
 *
 */
public class GenericStack<E> implements Stack<E> {
    private Object[] elements;
    private int capacity;
    private int size;



    public GenericStack(int capacity) {
        this.capacity = capacity;
        size = 0;
        elements = new Object[capacity];
    }

    @Override
    public void push(E element) throws StackException {
        if (isFull()) {
            throw new StackException("Stack overflow");
        }
        elements[size] = element;
        size++;
    }

    @Override
    public E pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        size--;
        @SuppressWarnings("unchecked")
        E element = (E) elements[size];
        elements[size] = null;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E element = (E) elements[size - 1];
        return element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void pushAll(Collection<E> src) throws StackException {
        for (E e : src) {
            push(e);
        }
    }

    @Override
    public void popAll(Collection<E> dst) throws StackException {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
