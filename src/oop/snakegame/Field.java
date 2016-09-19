package oop.snakegame;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

enum cellType {
    Wall,
    Empty
}

public class Field {

    private cellType[][] cells;
    private int width;
    private int height;
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new cellType[width][height];
    }

    public List<Location> GetCellsOfType(cellType type) {
        List<Location> result = new ArrayList<>();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                result.add(new Location(i, j));
        return result;
    }

    public boolean contains(Location location) {
        return (location.getX() >= 0 && location.getX() < width &&
                location.getY() >= 0 && location.getY() < height);

    }
}
