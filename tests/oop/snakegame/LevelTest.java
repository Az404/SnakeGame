package oop.snakegame;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;


public class LevelTest {

    @Test
    public void testSimpleStep() throws Exception {
        String[] map = new String[]{
            "####",
            "#  #",
            "#R #",
            "####"
        };

        Level level = LevelCreator.create(map);
        level.handleTick();
        assertEquals(new Location(2, 2), level.getSnake().getHeadLocation());
    }

    @Test(expected = GameOverException.class)
    public void testWallCollision() throws Exception {
        String[] map = new String[]{
            "#####",
            "#   #",
            "# D #",
            "# # #",
            "#####"
        };
        Level level = LevelCreator.create(map);
        level.handleTick();
    }

    @Test
    public void testBonus() throws ParseException, GameOverException {
        String[] map = new String[]{
            "#####",
            "#D  #",
            "#1  #",
            "#   #",
            "#####"
        };
        Level level = LevelCreator.create(map);
        level.handleTick();
        assertEquals(new Location(1, 2), level.getSnake().getHeadLocation());
        assertEquals(1, level.getSnake().getLength());
        level.handleTick();
        assertArrayEquals(new SnakeBlock[]{
            new SnakeBlock(new Location(1, 3)),
            new SnakeBlock(new Location(1, 2))
        }, level.getSnake().toArray());
    }
}