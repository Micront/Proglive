package arhangel.dim.webinar;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 *
 */
public class BasicTest extends Assert {
    private static Logger logger = LoggerFactory.getLogger(BasicTest.class);

    @Test
    public void testBinaryView() {
        logger.info("\n 1: {}\n-1: {}", Basic.toBinaryString(1), Basic.toBinaryString(-1));
        logger.info("\n 127: {}\n-128: {}", Basic.toBinaryString(127), Basic.toBinaryString(-128));
    }

    @Test
    public void compareBoxed() {
        // primitives
        int x = 128;
        int y = 128;
        assertTrue(x == y);

        // objects
        Integer a = 128;
        Integer b = 128;
        //assertTrue(a == b);
        assertTrue(a.equals(b));

        a = 127;
        b = 127;
        // interval -128..127 is cached
        assertTrue(a == b);

        // String compare
        String s1 = "test";
        String s2 = "test";
        String s3 = "abcd";

        assertTrue(s1.equals(s2));
        assertFalse(s1.equals(s3));
    }

    @Test
    public void compareFloat() {
        float a = 0.3f;
        float b = 0.4f;
        logger.info("0.3 + 0.4 = {}", (double) (a + b));
        //assertTrue(a + b == 0.7f);

        assertTrue(Basic.equalsFloat(a + b, 0.7f, 1e-6));
    }


}
