package arhangel.dim.battleship;

/**
 * Created on 18/08/14.
 */
public class Ship {


    int x, y;
    boolean isVertical;
    int length;

    public Ship(int x, int y, boolean isVertical, int length) {
        this.x = x;
        this.y = y;
        this.isVertical = isVertical;
        this.length = length;
    }

    public boolean isHit(int x, int y) {
        if (isVertical) {
            if (this.x == x && this.y <= y && this.y + length > y) {
                return true;
            }
        } else {
            if (this.y == y && this.x <= x && this.x + length > x) {
                return true;
            }
        }
        return false;
    }

}
