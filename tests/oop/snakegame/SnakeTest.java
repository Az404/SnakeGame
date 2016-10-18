package oop.snakegame;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {
    @Test
    public void extend() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Right, 0);
        snake.extend(1);
        snake.move();
        assertArrayEquals(new SnakeBlock[]{
                new SnakeBlock(new Location(1, 0), 0),
                new SnakeBlock(new Location(0, 0), 0)
        }, snake.toArray());
    }

    @Test
    public void move() throws Exception {
        Snake snake = new Snake(new Location(0, 0), Direction.Down, 0);
        snake.move();
        assertArrayEquals(new SnakeBlock[]{
                new SnakeBlock(new Location(0, 1), 0)
        }, snake.toArray());
    }

    @Test
    public void setHeadDirection() {
        Snake snake = new Snake(new Location(1, 1), Direction.Up, 0);
        snake.setNextHeadDirection(Direction.Down);
        assertEquals(Direction.Down, snake.getNextHeadDirection());
        snake.extend(2);
        for (int i = 0; i < 2; i++){
            snake.move();
        }
        snake.setNextHeadDirection(Direction.Up);
        assertEquals(Direction.Down, snake.getNextHeadDirection());
        snake.move();
        snake.setNextHeadDirection(Direction.Right);
        snake.setNextHeadDirection(Direction.Up);
        assertEquals(Direction.Right, snake.getNextHeadDirection());
    }
}