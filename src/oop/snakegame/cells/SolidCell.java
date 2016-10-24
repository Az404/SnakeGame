package oop.snakegame.cells;

import oop.snakegame.GameException;
import oop.snakegame.Level;
import oop.snakegame.primitives.Location;
import oop.snakegame.Snake;

public abstract class SolidCell extends Cell {
    SolidCell(Location location) {
        super(location);
    }

    @Override
    public void interactWithSnake(Snake snake, Level level) throws GameException {
        snake.destroy();
    }
}
