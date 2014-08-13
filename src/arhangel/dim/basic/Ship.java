package arhangel.dim.basic;


public class Ship {

    int x, y;
    int length;
    boolean isVertical;
    static final int DESTROYER_NUMBER = 3;


    Ship(int x, int y, int length, boolean isVertical) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.isVertical = isVertical;
    }

    Ship(int length) {
        this.length = length;
        x = 10;
        y = 10;
    }


    public static void main(String[] args) {
        //DESTROYER_NUMBER = 10;
    }
}
