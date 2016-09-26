package oop.snakegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {
    @Test
    public void extend() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Right);
        snake.extend(1);
        snake.move();
        assertArrayEquals(new SnakeBlock[]{
                new SnakeBlock(new Location(1, 0)),
                new SnakeBlock(new Location(0, 0))
        }, snake.toArray());
    }

    @Test
    public void move() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Down);
        snake.move();
        assertArrayEquals(new SnakeBlock[]{
                new SnakeBlock(new Location(0, 1))
        }, snake.toArray());
    }

    @Test
    public void isHeadIntersected() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Down);
        snake.extend(6);
        Direction[] directions = new Direction[]{
            Direction.Down, Direction.Right, Direction.Up, Direction.Left
        };
        for (Direction direction : directions) {
            snake.setHeadDirection(direction);
            assertFalse(snake.isHeadIntersected());
            snake.move();
        }
        assertTrue(snake.isHeadIntersected());
    }
}