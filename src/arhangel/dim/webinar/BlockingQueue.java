package arhangel.dim.webinar;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class BlockingQueue<T> {

    int capacity = 3;
    LinkedList<T> list = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition isFull = lock.newCondition();


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
}
