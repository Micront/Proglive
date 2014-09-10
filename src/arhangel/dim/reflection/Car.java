package arhangel.dim.reflection;


public class Car {

    private Engine engine;
    private Gear gear;

    public Car() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", gear=" + gear +
                '}';
    }
}
