package oop.snakegame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class LevelCreator {

//    public static Level create(int width, int height, Random random){
//         Field field = ...
//         Snake snake = ...
//         return Level(field, snake, ...)
//    }

    static Level create(String filename) throws IOException, ParseException {
        return create(Files.readAllLines(Paths.get(filename)).toArray(new String[0]));
    }

    static Level create(String[] cellMap) throws ParseException {
        Field field = new Field(cellMap[0].length(), cellMap.length);
        List<Bonus> bonuses = new ArrayList<>();
        Snake snake = null;

        for (int y = 0; y < field.getHeight(); y++) {

            if (cellMap[y].length() != field.getWidth())
                throw new ParseException("lines have different length", y*field.getWidth() + 1);

            for (int x = 0; x < field.getWidth(); x++) {
                char currentCell = cellMap[y].charAt(x);
                Location location = new Location(x, y);

                field.setCell(location, getCellType(currentCell));
                Bonus bonus = getBonus(location, currentCell);
                if (bonus != null)
                    bonuses.add(bonus);

                if (snake == null)
                    snake = getSnake(location, currentCell);
            }
        }
        if (snake == null)
            throw new ParseException("no snake on map", field.getHeight() * field.getWidth());
        return new Level(field, snake, bonuses);
    }

    private static CellType getCellType(char c){
        switch (c){
            case '#':
                return CellType.Wall;
            default:
                return CellType.Empty;
        }
    }

    private static Bonus getBonus(Location location, char c){
        if ('0' <= c && c <= '9')
            return new SizeBonus(location, Character.getNumericValue(c));
        else
            return null;
    }

    private static Snake getSnake(Location location, char c){
        Direction direction = Direction.fromChar(c);
        if (direction == null)
            return null;
        else
            return new Snake(location, direction);
    }

}
