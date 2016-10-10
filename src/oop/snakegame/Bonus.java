package oop.snakegame;


abstract class Bonus extends Cell {

    Bonus(Location location) {
        super(location);
    }

    @Override
    void interactWithSnake(Snake snake, Level level) throws GameException {
        level.field.removeCell(this);
    }
}
