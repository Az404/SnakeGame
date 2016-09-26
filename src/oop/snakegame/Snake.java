package oop.snakegame;

import java.util.Iterator;
import java.util.LinkedList;

enum Direction {
    Up,
    Right,
    Down,
    Left;

    public Direction opposite() {
        switch (this){
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
        switch (this){
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

    public static Direction fromChar(char c){
        switch (c){
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

class Snake {
    private Direction headDirection;
    private LinkedList<SnakeBlock> blocks;
    private int extensionCount;

    Snake(Location location, Direction headDirection) {
        this.headDirection = headDirection;
        blocks = new LinkedList<>();
        blocks.addFirst(new SnakeBlock(location));
    }

    void extend(int increment) {
        extensionCount += increment;
    }

    void move(){
        appendHead();
        if (extensionCount == 0){
            reduceTail();
        } else {
            extensionCount--;
        }
    }

    private void appendHead(){
        SnakeBlock newHead = new SnakeBlock(getHeadLocation().addOffset(headDirection.getOffset()));
        blocks.addFirst(newHead);
    }

    private void reduceTail(){
        blocks.removeLast();
    }

    int getLength() {
        return blocks.size();
    }

    void setHeadDirection(Direction direction){
        if (getLength() > 1 && direction == headDirection.opposite())
            return;
        headDirection = direction;
    }

    Iterator<SnakeBlock> iterator(){
        return blocks.iterator();
    }

    SnakeBlock[] toArray(){
        return blocks.toArray(new SnakeBlock[0]);
    }

    Location getHeadLocation(){
        return blocks.getFirst().getLocation();
    }

    boolean isHeadIntersected(){
        SnakeBlock head = blocks.getFirst();
        for (SnakeBlock block: blocks) {
            if (block != head && block.getLocation().equals(head.getLocation()))
                return true;
        }
        return false;
    }
}
