package arhangel.dim.generics;

import java.util.Collection;

/**
 *
 */
public interface Stack<E> {

    public void push(E element) throws StackException;

    public E pop() throws StackException;

    public E peek();

    public int getSize();

    public boolean isEmpty();

    public boolean isFull();

    public void pushAll(Collection<E> src) throws StackException;

    public void popAll(Collection<E> dst) throws StackException;
}
