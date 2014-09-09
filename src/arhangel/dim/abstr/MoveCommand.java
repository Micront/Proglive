package arhangel.dim.abstr;


import java.util.Deque;
import java.util.LinkedList;

import arhangel.dim.command.Command;

public class MoveCommand implements Command {

    private int x, y;
    private int oldX, oldY;
    private Unit unit;

    Deque<Position> history = new LinkedList<>();

    public MoveCommand(Unit unit, int x, int y) {
        this.unit = unit;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        oldX = unit.x;
        oldY = unit.y;
        unit.moveTo(x, y);
        history.push(new Position());
    }

    @Override
    public void undo() {
        Position prev = history.pop();
        // unit.moveTo(Position);
        unit.moveTo(oldX, oldY);

    }
}
