package oop.snakegame;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class LevelCreator {

//    public static Level create(int width, int height, Random random){
//         Field field = ...
//         Snake snakes = ...
//         return Level(field, snakes, ...)
//    }

    static Level create(String filename) throws IOException, ParseException {
        return create(Files.readAllLines(Paths.get(filename)).toArray(new String[0]));
    }

    private static int nextId = 0;

    private static int getId() {
        nextId++;
        return nextId;
    }


    static Level create(String[] cellMap) throws ParseException {
        Field field = new Field(cellMap[0].length(), cellMap.length);
        List<Snake> snakes = new ArrayList<>();

        for (int y = 0; y < field.height; y++) {

            if (cellMap[y].length() != field.width)
                throw new ParseException("lines have different length", y * field.width + 1);

            for (int x = 0; x < field.width; x++) {
                char currentCell = cellMap[y].charAt(x);
                Location location = new Location(x, y);

                Cell cell = createCell(location, currentCell);
                if (cell != null) {
                    field.addCell(cell);
                    continue;
                }

                Snake snake = createSnake(location, currentCell);
                if (snake != null)
                    snakes.add(snake);
            }
        }
        if (snakes.isEmpty())
            throw new ParseException("no snakes on map", field.height * field.width);

        return new Level(field, snakes.toArray(new Snake[snakes.size()]));
    }

    private static Cell createCell(Location location, char c) {
        if ('0' <= c && c <= '9')
            return new SizeBonus(location, Character.getNumericValue(c));
        else if (c == '#')
            return new Wall(location);
        else
            return null;
    }

    private static Snake createSnake(Location location, char c) {
        Direction direction = Direction.fromChar(c);
        if (direction == null)
            return null;
        else
            return new Snake(location, direction, getId());
    }

}
