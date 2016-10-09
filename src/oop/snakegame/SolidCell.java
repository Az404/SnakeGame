package oop.snakegame;

class SolidCell extends Cell {
    SolidCell(Location location) {
        super(location);
    }

    @Override
    void interact(Level level) throws CollisionException {
        level.snake.destroy();
        //throw new CollisionException();
    }
}
