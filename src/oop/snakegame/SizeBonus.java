package oop.snakegame;

import java.util.List;

class SizeBonus extends Bonus {

    private int sizeIncrement;

    SizeBonus(Location location, int sizeIncrement) {
        super(location);
        this.sizeIncrement = sizeIncrement;
    }

    @Override
    void interact(Level level) throws GameException {
        super.interact(level);
        level.snake.extend(sizeIncrement);
        regenerate(level);
    }

    private void regenerate(Level level) {
        List<Location> freeLocations = level.getFreeLocations();
        int index = level.random.nextInt(freeLocations.size());
        int increment = level.random.nextInt(4) + 1;
        level.field.addCell(new SizeBonus(freeLocations.get(index), increment));
    }
}
