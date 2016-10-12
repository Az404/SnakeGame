package oop.snakegame;

class Wall extends SolidCell {
    Wall(Location location) {
        super(location);
    }

    @Override
    void visit(IVisitor visitor) {
        visitor.visit(this);
    }
}
