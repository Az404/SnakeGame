package oop.snakegame.cells;


import oop.snakegame.IVisitor;
import oop.snakegame.primitives.Location;

public class SnakeBlock extends SolidCell {
    public final int id;

    public SnakeBlock(Location location, int id) {
        super(location);
        this.id = id;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
