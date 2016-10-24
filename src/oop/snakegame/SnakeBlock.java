package oop.snakegame;


class SnakeBlock extends SolidCell {
    public final int id;

    SnakeBlock(Location location, int id) {
        super(location);
        this.id = id;
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
