package arhangel.dim.lesson6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 */
public class CollectionsReview {

    static Logger logger = LoggerFactory.getLogger(CollectionsReview.class);

    static void listInterface() {
        // There are two way to get element: by value and by index
        // Ordered elements
        List<String> list = new ArrayList<>();
        // ADD
        list.add("Bob");
        list.add("Alisa");
        logger.info("Initial list {}", list);

        // GET
        logger.info("element by index 0 = {}", list.get(0)); // arr[0]

        // SET
        list.add("John"); // by value
        list.add(0, "Jack"); // by index
        logger.info("List after set {}", list);
        logger.info("element by index 0 = {}", list.get(0));

        // REMOVE
        list.remove("John"); // by value
        list.remove(0); // by index
        logger.info("List after remove {}", list);

        Deque linked = new LinkedList<>();

        //FIFO - очередь First In First Out
        // LIFO - стек Last In --\\--

        ArrayDeque deque = new ArrayDeque();
        deque.pop();
        deque.push(new Object());
    }

    static void queueInterface() {
        // Ordered elements
        // FIFO
        Queue<String> queue = new LinkedList<>();
        queue.add("Audi");
        queue.add("BMW");
        queue.add("Porsche");
        logger.info("Initial queue {}", queue);

        while (!queue.isEmpty()) {
            logger.info("Polling queue - {}", queue.poll());
        }

        // LIFO / FIFO
        Deque<String> deque = new LinkedList<>();
        deque.add("Audi");
        deque.add("BMW");
        deque.add("Porsche");
        logger.info("\nInitial deque {}", deque);

        while (!deque.isEmpty()) {
            logger.info("Polling deque - {}", deque.pollLast());
        }

    }

    static void setInterface() {
        // Contains only unique elements
        Set<String> set = new HashSet<>();
        // ADD
        set.add("Apple");
        set.add("Facebook");
        set.add("Google");
        set.add("Apple"); // cannot add the same element twice

        logger.info("Initial set {}", set);

        // CONTAINS
        logger.info("Contains <Apple>: {}", set.contains("Apple"));
        logger.info("Contains <Amazon>: {}", set.contains("Amazon"));

        // REMOVE
        set.remove("Apple");
        logger.info("Set after remove {}", set);

        // SortedSet
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Apple");
        sortedSet.add("Amazon");
        sortedSet.add("Google");
        sortedSet.add("Facebook");
        logger.info("SortedSet initial: {}", sortedSet);
    }

    static void mapInterface() {
        Map<String, Integer> requests = new HashMap<>();
        requests.put("Football", 120);
        requests.put("Hokey", 134);
        requests.put("Ski", 25);
        requests.put("Ski", 48);

        logger.info("Map initial {}", requests);

        // CONTAINS
        String key = "Running";
        logger.info("Contains key {} : {}", key, requests.containsKey(key));

        // GET
        key = "Hokey";
        logger.info("Get by key {} = {}", key, requests.get(key));

        // REMOVE
        requests.remove(key);
        logger.info("Remove key {} => {}", key, requests);


        Set<String> keys = requests.keySet();
        for (String s : keys) {
            System.out.println(s);
        }

        Collection<Integer> vals = requests.values();
        for (Integer i : vals) {
            System.out.println(String.valueOf(i));
        }

        for (Map.Entry<String, Integer> entry : requests.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", val=" + entry.getValue());
        }

    }

    static void operations() {
        List<Integer> list = Arrays.asList(3, 5, 6, 1, 2, 9, 4);
        logger.info("Initial list: {}", list);

        Collections.shuffle(list);
        logger.info("Shuffled list: {}", list);

        Collections.sort(list);
        logger.info("Sorted list: {}", list);

        Collections.reverse(list);
        logger.info("Reversed list: {}", list);

        Collections.swap(list, 0, list.size() - 1);
        logger.info("Swapped list: {}", list);

        Collections.fill(list, 42);
        logger.info("Filled list: {}", list);

    }

    public static void main(String[] args) {

        //listInterface();
        //queueInterface();
        // setInterface();
        mapInterface();
        //operations();
    }
}
