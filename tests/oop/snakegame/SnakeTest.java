package oop.snakegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {
    @Test
    public void extend() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Right);
        snake.extend(1);
        snake.move();
        assertEquals(snake.getHeadLocation(), new Location(1, 0));
        assertEquals(snake.getLength(), 2);
    }

    @Test
    public void move() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Down);
        snake.move();
        assertEquals(snake.getHeadLocation(), new Location(0, 1));
        assertEquals(snake.getLength(), 1);
    }

    @Test
    public void isHeadIntersected() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Down);
        snake.extend(6);
        Direction[] directions = new Direction[]{
            Direction.Right, Direction.Up, Direction.Left
        };
        for (Direction direction : directions) {
            snake.move();
            assertFalse(snake.isHeadIntersected());
            snake.setHeadDirection(direction);
        }
        snake.move();
        assertTrue(snake.isHeadIntersected());
    }
}