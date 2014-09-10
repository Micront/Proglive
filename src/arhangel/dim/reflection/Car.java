package arhangel.dim.reflection;


import arhangel.dim.reflection.di.Auto;

public class Car {

    @Auto(isRequired = true)
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
