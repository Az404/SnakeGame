package oop.snakegame;

class Wall extends SolidCell {
    Wall(Location location) {
        super(location);
    }

    @Override
    void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
