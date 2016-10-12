package oop.snakegame;


class SnakeBlock extends SolidCell {
    final Snake owner;
    SnakeBlock(Location location, Snake owner) {
        super(location);
        this.owner = owner;
    }
}
