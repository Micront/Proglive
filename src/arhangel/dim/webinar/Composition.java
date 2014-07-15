package arhangel.dim.webinar;

/**
 *
 */
public class Composition {
    static class Car {
        private Wheel wheel;
        private Engine engine;

        Car(Engine engine, Wheel wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public void move() {
            System.out.println("A nice car with " + wheel.radius + " inch wheels and powerful " +
                    "engine with " + engine.power + " horse powers.");
        }
    }

    static class Wheel {
        int radius;

    }

    static class Engine {
        int power;
    }

    public static void main(String[] args) {
        Wheel wheel = new Wheel();
        wheel.radius = 19;
        Engine engine = new Engine();
        engine.power = 250;

        Car myCar = new Car(engine, wheel);
        myCar.move();

    }

}
