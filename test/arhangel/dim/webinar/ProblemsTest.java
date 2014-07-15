package arhangel.dim.webinar;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class ProblemsTest extends Assert {
    @Test
    public void testReverse() throws Exception {
        Problems.List head = new Problems.List(1, null);
        head.next = new Problems.List(2, new Problems.List(3, new Problems.List(4, null)));
        Problems.printList(head);

        head = Problems.reverse(head);
        Problems.printList(head);
        assertTrue(head.val == 4);

        head = new Problems.List(10, new Problems.List(20, null));
        head = Problems.reverse(head);
        assertTrue(head.val == 20);
    }

    @Test
    public void testIsPalindrome() {
        String s = "";
        assertTrue(Problems.isPalindrome(s));

        s = "x";
        assertTrue(Problems.isPalindrome(s));

        s = "ab";
        assertFalse(Problems.isPalindrome(s));

        s = "eee";
        assertTrue(Problems.isPalindrome(s));

        s = "abba";
        assertTrue(Problems.isPalindrome(s));

        s = "abbaa";
        assertFalse(Problems.isPalindrome(s));
    }
}
