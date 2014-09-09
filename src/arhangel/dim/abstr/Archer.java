package arhangel.dim.abstr;

public class Archer extends Unit {
    int strength;

    public Archer(String name, int health, int speed, int strength) {
        super(name, health, speed);
        this.strength = strength;
    }

    @Override
    public String getFullInfo() {
        return "Archer position = (" + x + ", " + y + ")";
    }

    public void shoot() {

    }

    public void draw() {
        System.out.println("Draw archer");
    }
}
