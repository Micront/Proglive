package arhangel.dim.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommonErrorsTest extends Assert {

    @Test(expected = ClassCastException.class)
    public void testNonGenericContainer() {
        List words = new ArrayList();
        words.add("Apple");
        words.add("Orange");

        words.add(new Integer(10)); // Hmm, seems like an error...

        for (Object o : words) {
            // need to cast item manually
            String s = (String) o; // Runtime error
            System.out.println(s + " : " + s.length());
        }
    }

    @Test
    public void testGenericContainer() {
        List<String> words = new ArrayList<>();
        words.add("Apple");
        words.add("Orange");

        //words.add(new Integer(10)); // Compile error

        // Simple iteration without casting
        for (String s : words) {
            System.out.println(s + " : " + s.length());
        }
    }

    @Test
    public void testJuicer() {
        Juicer juicer = new Juicer();

        Collection<Apple> apples = new ArrayList<>();
        apples.add(new Apple(100));
        apples.add(new Apple(90));

        Collection<Orange> oranges = new ArrayList<>();
        oranges.add(new Orange(70));
        oranges.add(new Orange(80));

        juicer.makeAppleJuice(apples);

        //juicer.makeAppleJuice(oranges);

        Collection<Fruit> fruits= new ArrayList<>();
        fruits.addAll(oranges);
        fruits.addAll(apples);

        juicer.makeMultifruit(fruits);

    }


}