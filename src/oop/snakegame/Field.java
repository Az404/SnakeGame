package oop.snakegame;

import java.util.ArrayList;
import java.util.List;

enum CellType {
    Wall,
    Empty
}

public class Field {

    private CellType[][] cells;
    private int width;
    private int height;
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new CellType[width][height];
    }

    public Field(char[][] cellMap){
        this(cellMap[0].length, cellMap.length);
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                cells[j][i] = getCellType(cellMap[i][j]);
            }
        }
    }

    private CellType getCellType(char c){
        switch (c){
            case ' ':
                return CellType.Empty;
            case '#':
                return CellType.Wall;
        }
        return CellType.Empty;
    }

    public List<Location> GetCellsOfType(CellType type) {
        List<Location> result = new ArrayList<>();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                result.add(new Location(i, j));
        return result;
    }

    public CellType getCell(Location location){
        return cells[location.getX()][location.getY()];
    }

    public boolean contains(Location location) {
        return (location.getX() >= 0 && location.getX() < width &&
                location.getY() >= 0 && location.getY() < height);

    }

    public boolean isFree(Location location){
        return contains(location) && getCell(location) == CellType.Empty;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
