package arhangel.dim.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LengthComparatorTest extends Assert {

    @Test
    public void testSort() {
        List<String> expected = Arrays.asList("a", "aa", "aaa");
        List<String> actual = Arrays.asList("aa", "a", "aaa");

        Collections.sort(actual, new LengthComparator());

        assertEquals(expected, actual);
    }

}