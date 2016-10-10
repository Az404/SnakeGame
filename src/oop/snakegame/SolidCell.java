package oop.snakegame;

class SolidCell extends Cell {
    SolidCell(Location location) {
        super(location);
    }

    @Override
    void interactWithSnake(Snake snake, Level level) throws GameException {
        snake.destroy();
    }
}
