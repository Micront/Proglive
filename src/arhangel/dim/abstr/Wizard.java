package arhangel.dim.abstr;


public class Wizard extends Unit {

    int mana;

    public Wizard(String name, int health, int speed, int mana) {
        super(name, health, speed);
        this.mana = mana;
    }

    void spell() {
        System.out.println("Cast: " + mana);
    }


    public static void main(String[] args) {
        Wizard wizard = new Wizard("Merlin", 100, 10, 100);
        Archer archer = new Archer("Legolas", 150, 20, 100);

        Drawable[] objects = new Drawable[4];
        objects[0] = wizard;
        objects[1] = new Grass();
        objects[2] = new Tree();
        objects[3] = archer;


        for (Drawable object : objects) {
            object.draw();
        }

    }

    @Override
    public String getFullInfo() {
        return "Wizard: ...";
    }

    @Override
    public void draw() {
        System.out.println("drawing wizard");
    }


}
