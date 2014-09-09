package arhangel.dim.battleship;

import java.util.Scanner;


public class Battleship {

    public static final int BATTLESHIP_COUNT = 1;
    public static final int SUBMARINE_COUNT = 2;
    public static final int DESTROYER_COUNT = 3;
    public static final int BOAT_COUNT = 4;
    public static final int TOTAL_COUNT = BOAT_COUNT + DESTROYER_COUNT + SUBMARINE_COUNT + BATTLESHIP_COUNT;

    /*
    Таким образом можно объявить двумерный массив, прямая аналогия - таблица в Excel
    У каждого элемента таблицы есть координата x, y (или номер колонки и номер строки)
    Инициализируется также, как и одномерный массив, только нужно указать обе размерности: 10х10
    Массив может содержать данные любого типа, в данном случае boolean
    true - клетка занята кораблем
    false - клетка свободна (вода)
    На начальном этапе отрисовки карты нам достаточно двух состояний, чтобы описать больше характеристик
    клетки, следует определить новый класс Cell и работать с ним

    Это будет эмуляция карты сражения


     */

    //private boolean[][] map = new boolean[10][10];

    private Cell[][] cellMap = new Cell[10][10];

    // Храним здесь все корабли
    private Ship[] ships = new Ship[TOTAL_COUNT];

    public static void main(String[] args) {
        greeting();


        Battleship game = new Battleship();


        game.createShips();
        game.createMap();

        game.showMap();

    }

    /* создаем корабли вручную
       Вашей задачей будет придумать алгоритм автоматической расстановки кораблей,
       чтобы они не пересекали друг друга

    */
    private void createShips() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellMap[i][j] = new Cell();
            }
        }

        // Battleship
        ships[0] = new Ship(1, 1, true, 4);

        // Submarines
        ships[1] = new Ship(3, 0, false, 3);
        ships[2] = new Ship(3, 2, false, 3);

        // Destroyers
        ships[3] = new Ship(7, 0, true, 2);
        ships[4] = new Ship(9, 0, true, 2);
        ships[5] = new Ship(0, 9, false, 2);

        // Boats
        ships[6] = new Ship(7, 7, false, 1);
        ships[7] = new Ship(9, 9, false, 1);
        ships[8] = new Ship(5, 5, false, 1);
        ships[9] = new Ship(8, 5, false, 1);
    }

    // заполняем карту, где стоят корабли
    private void createMap() {
        for (int i = 0; i < ships.length; i++) {
            if (isPlaceFree(ships[i])) {
                markShipOnMap(ships[i]);
            } else {
                System.out.println("Failed to create map");
                return;
            }
        }
    }

    // Отмечаем на карте клетки, где стоит корабль
    private void markShipOnMap(Ship ship) {
        for (int i = 0; i < ship.length; i++) {
            if (ship.isVertical) {
                cellMap[ship.x][ship.y + i].owner = ship; // клетка занята кораблем
            } else {
                cellMap[ship.x + i][ship.y].owner = ship;
            }
        }
    }

    // Проверяем, что место куда мы ставим корабль, свободно (клетка карты не отмечена, как занятая)
    private boolean isPlaceFree(Ship ship) {
        for (int i = 0; i < ship.length; i++) {
            if (ship.isVertical) {
                if (cellMap[ship.x][ship.y + i].owner != null) { // если клетка не свободна
                    return false;
                }
            } else {
                if (cellMap[ship.x + i][ship.y].owner != null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void showMap() {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i) + " ");
            // либо численные System.out.println(i + " ");
        }

        System.out.println("\n-+--------------------+-");
        for (int i = 0; i < 10; i++) {

            System.out.print(i + "|");
            for (int j = 0; j < 10; j++) {
                if (cellMap[i][j].owner != null) {
                    System.out.print("X ");
                } else if (cellMap[i][j].isAlreadyHit) {
                    System.out.println("* ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
    }

    static void greeting() {
        System.out.println("Hello! What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Welcome, " + name);
    }

    public void restart() {
        // почистить поле
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cellMap[i][j] = new Cell();
            }
        }

        // создать корабли
        //
        createShips();


    }


}
