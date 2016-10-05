package oop.snakegame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

enum Direction {
    Up,
    Right,
    Down,
    Left;

    public Direction opposite() {
        switch (this) {
            case Down:
                return Up;
            case Left:
                return Right;
            case Right:
                return Left;
            default:
                return Down;
        }
    }

    public Offset getOffset() {
        switch (this) {
            case Down:
                return new Offset(0, 1);
            case Left:
                return new Offset(-1, 0);
            case Right:
                return new Offset(1, 0);
            default:
                return new Offset(0, -1);
        }
    }

    public static Direction fromChar(char c) {
        switch (c) {
            case 'L':
                return Direction.Left;
            case 'R':
                return Direction.Right;
            case 'U':
                return Direction.Up;
            case 'D':
                return Direction.Down;
            default:
                return null;
        }
    }
}

class Snake implements Iterable<SnakeBlock> {
    private Direction lastHeadDirection;
    private Direction nextHeadDirection;
    private LinkedList<SnakeBlock> blocks;
    private int extensionCount;

    Snake(Location location, Direction headDirection) {
        this.nextHeadDirection = headDirection;
        blocks = new LinkedList<>();
        blocks.addFirst(new SnakeBlock(location));
    }

    void extend(int increment) {
        extensionCount += increment;
    }

    void move() {
        appendHead();
        if (extensionCount == 0) {
            reduceTail();
        } else {
            extensionCount--;
        }
    }

    private void appendHead() {
        synchronized (this) {
            SnakeBlock newHead = new SnakeBlock(getHead().location.addOffset(nextHeadDirection.getOffset()));
            blocks.addFirst(newHead);
            lastHeadDirection = nextHeadDirection;
        }
    }

    private void reduceTail() {
        blocks.removeLast();
    }

    int getLength() {
        return blocks.size();
    }

    void setNextHeadDirection(Direction direction) {
        if (getLength() > 1 && direction == lastHeadDirection.opposite())
            return;
        synchronized (this){
            nextHeadDirection = direction;
        }
    }

    public Iterator<SnakeBlock> iterator() {
        return blocks.iterator();
    }

    SnakeBlock[] toArray() {
        return blocks.toArray(new SnakeBlock[0]);
    }

    Direction getNextHeadDirection() {
        synchronized (this) {
            return nextHeadDirection;
        }
    }

    SnakeBlock getHead() {
        return blocks.getFirst();
    }
}
