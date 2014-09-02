package arhangel.dim.abstr;


import java.io.Serializable;

public abstract class Unit implements Drawable, Serializable {

    protected String name;
    protected int health;
    protected int speed;

    public Unit(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public final void run() {
        System.out.println("run with speed: " + speed);
    };

    public abstract String getFullInfo();


}

