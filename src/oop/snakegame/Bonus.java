package oop.snakegame;


abstract class Bonus extends Cell {

    Bonus(Location location) {
        super(location);
    }

    @Override
    void interact(Level level) throws GameException {
        level.field.removeCell(this);
    }
}
