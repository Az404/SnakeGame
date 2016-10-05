package oop.snakegame;

class SolidCell extends Cell {
    SolidCell(Location location) {
        super(location);
    }

    @Override
    void interact(Level level) throws CollisionException {
        throw new CollisionException();
    }
}
