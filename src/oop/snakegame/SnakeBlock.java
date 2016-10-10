package oop.snakegame;


class SnakeBlock extends SolidCell {
    public final int number;
    SnakeBlock(Location location, int number) {
        super(location);
        this.number = number;
    }
    SnakeBlock(Location location) {
        super(location);
        this.number = 0;
    }

}
