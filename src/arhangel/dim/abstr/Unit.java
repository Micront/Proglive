package arhangel.dim.abstr;


import java.io.Serializable;

public abstract class Unit implements Drawable, Serializable {

    protected String name;
    protected int health;
    protected int speed;

    protected int x, y;

    public Unit(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public final void run() {
        System.out.println("run with speed: " + speed);
    };

    public abstract String getFullInfo();

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

