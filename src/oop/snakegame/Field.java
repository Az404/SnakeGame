package oop.snakegame;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

class Field implements Iterable<Cell> {

    private List<Cell> cells;
    final int width;
    final int height;

    Field(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new ArrayList<>();
    }

    public Iterator<Cell> iterator() {
        return cells.iterator();
    }

    Stream<Cell> stream(){
        return cells.stream();
    }

    void addCell(Cell cell) {
        if (isCorrectLocation(cell.location))
            cells.add(cell);
        else
            throw new InvalidParameterException("location is not on the field");
    }

    void removeCell(Cell cell) {
        cells.remove(cell);
    }

    boolean isCorrectLocation(Location location) {
        return (location.x >= 0 && location.x < width &&
                location.y >= 0 && location.y < height);
    }
}
