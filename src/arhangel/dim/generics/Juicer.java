package arhangel.dim.generics;

import java.util.Collection;

/**
 *
 */
public class Juicer {

    public void makeAppleJuice(Collection<Apple> apples) {
        System.out.println("\nMaking apple juice...");
        double weight = 0.0;
        double k = 0.3;
        for (Apple apple : apples) {
            weight += apple.weight;
            System.out.println("added: " + apple.toString());

        }
        System.out.println("Apple juice, weight=" + weight * k + "g");
    }

    public void makeMultifruit(Collection<? extends Fruit> fruits) {
        System.out.println("\nMaking multifruit juice...");
        double weight = 0.0;
        double k = 0.3;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeight();
            System.out.println("added: " + fruit.toString());
        }
        System.out.println("Multifruit juice, weight=" + weight * k + "g");
    }
}
