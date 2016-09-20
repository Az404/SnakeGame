package oop.snakegame;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LevelTest {
    private char[][] map = new char[][] {
            new char[] {'#', '#', '#', '#', '#', '#'},
            new char[] {'#', ' ', ' ', ' ', ' ', '#'},
            new char[] {'#', ' ', ' ', ' ', ' ', '#'},
            new char[] {'#', ' ', ' ', ' ', ' ', '#'},
            new char[] {'#', ' ', ' ', ' ', ' ', '#'},
            new char[] {'#', '#', '#', '#', '#', '#'},
    };

    @Test
    public void testSimpleStep() throws Exception {
        Field field = new Field(map);
        Snake snake = new Snake(new Location(2, 2), Direction.Right);
        List<Bonus> bonuses = new ArrayList<>();
        Level level = new Level(field, snake, bonuses);
        level.handleTick();
        assertEquals(snake.getHeadLocation(), new Location(3, 2));
    }
}