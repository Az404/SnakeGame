package oop.snakegame;

import java.util.ArrayList;
import java.util.List;

enum CellType {
    Wall,
    Empty
}

class Field {

    private CellType[][] cells;
    private int width;
    private int height;

    Field(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new CellType[width][height];
    }

    public List<Location> GetCellsOfType(CellType type) {
        List<Location> result = new ArrayList<>();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                result.add(new Location(i, j));
        return result;
    }

    private CellType getCell(Location location){
        return cells[location.getX()][location.getY()];
    }

    void setCell(Location location, CellType value){
        cells[location.getX()][location.getY()] = value;
    }

    private boolean contains(Location location) {
        return (location.getX() >= 0 && location.getX() < width &&
                location.getY() >= 0 && location.getY() < height);

    }

    boolean isFree(Location location){
        return contains(location) && getCell(location) == CellType.Empty;
    }

    int getWidth(){
        return width;
    }

    int getHeight(){
        return height;
    }
}
