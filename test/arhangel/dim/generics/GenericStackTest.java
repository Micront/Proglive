package arhangel.dim.generics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenericStackTest extends Assert {


    static final int CAPACITY = 10;
    static Random random;

    @BeforeClass
    public static void init() {
        random = new Random();
    }

    @Test
    public void testPushPop() throws StackException {
        Stack<Integer> stack = new GenericStack<>(CAPACITY);
        assertTrue(stack.isEmpty());
        for (int i = 0; i < CAPACITY; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());

        for (int i = 0; i < CAPACITY; i++) {
            Integer actual = stack.pop();
            Integer expected = CAPACITY - 1 - i;
            assertEquals(expected, actual);
        }
        assertTrue(stack.isEmpty());
    }

    @Test(expected = StackException.class)
    public void testStackOverflow() throws StackException {
        Stack<Integer> stack = new GenericStack<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
        stack.push(0);
    }

    @Test(expected = StackException.class)
    public void testStackEmpty() throws StackException {
        Stack<String> stack = new GenericStack<>(CAPACITY);
        stack.pop();
    }

    @Test
    public void testPeek() throws StackException {
        Stack<Integer> stack = new GenericStack<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            stack.push(i);
            assertEquals(new Integer(i), stack.peek());
        }
    }

    @Test
    public void testPushPopAll() throws StackException {
        Stack<Integer> stack = new GenericStack<>(CAPACITY);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < CAPACITY; i++) {
            numbers.add(i);
        }
        stack.pushAll(numbers);
        assertTrue(stack.isFull());

        List<Integer> result = new ArrayList<>();
        stack.popAll(result);
        assertTrue(stack.isEmpty());

        for (int i = 0; i < CAPACITY; i++) {
            assertEquals(numbers.get(CAPACITY - 1 - i), result.get(i));
        }
    }

    @Test
    public void testSuperExtends() throws StackException {
        Stack<Number> stack = new GenericStack<>(CAPACITY);
        List<Integer> integers = new ArrayList<>();
        Collections.fill(integers, 0);

        // Fix Stack interface to accept all children of <E>
        // stack.pushAll(integers);

        Stack<Integer> intStack = new GenericStack<>(CAPACITY);
        List<Number> numbers = new ArrayList<>();

        // Fix Stack interface to accept all parents of <E>
        // intStack.popAll(numbers);
    }


}