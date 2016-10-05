package oop.snakegame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Level implements Iterable<Cell> {

    final Field field;
    final Snake snake;

    final Random random;

    Level(Field field, Snake snake) {
        this.field = field;
        this.snake = snake;
        this.random = new Random();
    }

    void handleTick() throws GameException {
        snake.move();
        if (!field.isCorrectLocation(snake.getHead().location))
            throw new CollisionException();
        for (Cell cell : getCells(snake.getHead().location))
            if (cell != snake.getHead())
                cell.interact(this);
    }

    private List<Cell> getCells(Location location) {
        return stream().filter(cell -> cell.location.equals(location)).collect(Collectors.toList());
    }

    List<Location> getFreeLocations() {
        HashSet<Location> result = new HashSet<>();
        for (int x = 0; x < field.width; x++)
            for (int y = 0; y < field.height; y++)
                result.add(new Location(x, y));
        for (Cell cell : this) {
            result.remove(cell.location);
        }
        return new ArrayList<>(result);
    }

    Stream<Cell> stream(){
        return Stream.concat(
                StreamSupport.stream(field.spliterator(), false),
                StreamSupport.stream(snake.spliterator(), false)
        );
    }

    @Override
    public Iterator<Cell> iterator() {
        return stream().collect(Collectors.toList()).iterator();
    }
}
