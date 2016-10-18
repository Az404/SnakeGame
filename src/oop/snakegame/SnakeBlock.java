package oop.snakegame;


class SnakeBlock extends SolidCell {
    public final int id;

    SnakeBlock(Location location, int id) {
        super(location);
        this.id = id;
    }

    @Override
    void visit(IVisitor visitor) {
        visitor.visit(this);
    }
}
