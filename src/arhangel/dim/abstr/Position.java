package arhangel.dim.abstr;


import arhangel.dim.battleship.Ship;

public class Position {
    int x, y;

    // состояние клетки
    enum State {
        WATER, SHIP;
    }

    class Cell {
        // в каком состоянии
        State state;
        // корабль владелец, если есть
        Ship owner;
    }


}
