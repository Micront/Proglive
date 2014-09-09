package arhangel.dim.concurrency;

import java.util.LinkedList;

/**
 *
 */
public class BlockingQueue<T> {

    int capacity = 3;
    LinkedList<T> list = new LinkedList<>();

    public synchronized void enqueue(T item) throws InterruptedException {
        while (list.size() == capacity) {
            wait();
        }
        list.add(item);
        if (list.isEmpty())
            notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (list.isEmpty()) {
            wait();
        }
        T item = list.remove();
        if (list.size() == capacity)
            notifyAll();
        return item;
    }

    public static void main(String[] args) {

    }

}
