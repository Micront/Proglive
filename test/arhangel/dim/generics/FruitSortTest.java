package arhangel.dim.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FruitSortTest extends Assert {

    @Test
    public void testSort() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple(100));
        fruits.add(new Orange(80));
        fruits.add(new Apple(70));
        fruits.add(new Orange(97));

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(90));
        apples.add(new Apple(80));

        // sort as fruits
        FruitSort.sortFruits(fruits, new FruitSort.FruitComparator());
        System.out.println(fruits);

        // may sort as apples
        FruitSort.sortApples(apples, new FruitSort.AppleComparator());
        // also may sort as fruits
        FruitSort.sortApples(apples, new FruitSort.FruitComparator());



    }
}