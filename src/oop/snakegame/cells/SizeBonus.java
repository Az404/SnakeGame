package oop.snakegame.cells;

import oop.snakegame.*;
import oop.snakegame.primitives.Location;

import java.util.List;

public class SizeBonus extends Bonus {

    private int sizeIncrement;

    public SizeBonus(Location location, int sizeIncrement) {
        super(location);
        this.sizeIncrement = sizeIncrement;
    }

    @Override
    public void interactWithSnake(Snake snake, Level level) throws GameException {
        super.interactWithSnake(snake, level);
        snake.extend(sizeIncrement);
        regenerate(level);
    }

    private void regenerate(Level level) {
        List<Location> freeLocations = level.getFreeLocations();
        int index = level.random.nextInt(freeLocations.size());
        int increment = level.random.nextInt(4) + 1;
        level.field.addCell(new SizeBonus(freeLocations.get(index), increment));
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
