package oop.snakegame.cells;

import oop.snakegame.IVisitor;
import oop.snakegame.primitives.Location;

public class Wall extends SolidCell {
    public Wall(Location location) {
        super(location);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
