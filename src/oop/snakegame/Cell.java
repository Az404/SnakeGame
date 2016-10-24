package oop.snakegame;

abstract class Cell {
    public final Location location;

    Cell(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return location != null ? location.equals(cell.location) : cell.location == null;

    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    abstract void interactWithSnake(Snake snake, Level level) throws GameException;

    abstract void accept(IVisitor visitor);
}
