package oop.snakegame;


class SnakeBlock extends SolidCell {
    final Snake owner;
    SnakeBlock(Location location, Snake owner) {
        super(location);
        this.owner = owner;
    }

    @Override
    void visit(IVisitor visitor) {
        visitor.visit(this);
    }
}
