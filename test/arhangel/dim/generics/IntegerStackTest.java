package arhangel.dim.generics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntegerStackTest extends Assert {

    static IntegerStack stack;
    static final int CAPACITY = 5;

    @BeforeClass
    public static void init() {
        stack = new IntegerStack(CAPACITY);
    }

    @Test(expected = RuntimeException.class)
    public void testFillStack() {
        for (int i = 0; i < CAPACITY; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
        stack.push(0);

    }

    @Test(expected = RuntimeException.class)
    public void testEmptyStack() {
        while (!stack.isEmpty()) {
            stack.pop();
        }

        assertTrue(stack.isEmpty());
        stack.pop();
    }

    @Test
    public void testPushPop() {
        stack = new IntegerStack(CAPACITY);
        Integer expected = 100;
        stack.push(expected);

        assertEquals(expected, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackCycle() {
        stack = new IntegerStack(CAPACITY);
        assertTrue(stack.isEmpty());
        Integer a[] = new Integer[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            a[i] = i;
            stack.push(i);
        }

        assertTrue(stack.isFull());

        for (int i = CAPACITY - 1; i >= 0; i--) {
            assertEquals(a[i], stack.pop());
        }
        assertTrue(stack.isEmpty());

    }


}