package arhangel.dim.generics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class FruitSort {

    static class FruitComparator implements Comparator<Fruit> {
        @Override
        public int compare(Fruit o1, Fruit o2) {
            if (o1.weight > o2.weight)
                return 1;
            else if (o1.weight < o2.weight)
                return -1;
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            if (o1.weight > o2.weight)
                return 1;
            else if (o1.weight < o2.weight)
                return -1;
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static void sortFruits(List<Fruit> fruits, Comparator<? super Fruit> cmp) {
        Collections.sort(fruits, cmp);
    }

    public static void sortApples(List<Apple> apples, Comparator<? super Apple> cmp) {
        Collections.sort(apples, cmp);
    }
}
