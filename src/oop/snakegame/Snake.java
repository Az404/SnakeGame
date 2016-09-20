package oop.snakegame;

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
}

public class Snake {
    private int extensionCount;

    class SnakeBlock {
        private Location location;
        private SnakeBlock nextBlock = null;
        private SnakeBlock previousBlock = null;
        private SnakeBlock(Location location) {
            this.location = location;
        }
        public void setNextBlock(SnakeBlock nextBlock) {
            this.nextBlock = nextBlock;
        }
        public void setPreviousBlock(SnakeBlock previousBlock) {
            this.previousBlock = previousBlock;
        }
    }
    private Direction headDirection;
    private SnakeBlock head;
    private SnakeBlock tail;
    private int length;
    public Snake(Location location, Direction headDirection) {
        this.headDirection = headDirection;
        head = new SnakeBlock(location);
        tail = head;
        length = 1;
    }

    public void extend(int increment) {
        extensionCount += increment;
    }

    public void move(){
        appendHead();
        if (extensionCount == 0){
            reduceTail();
        } else {
            extensionCount--;
        }
    }

    private void appendHead(){
        SnakeBlock newHead = new SnakeBlock(head.location.addOffset(headDirection.getOffset()));
        newHead.setPreviousBlock(head);
        head.setNextBlock(newHead);
        head = newHead;
        length++;
    }

    private void reduceTail(){
        tail = tail.nextBlock;
        tail.setPreviousBlock(null);
        length--;
    }

    public int getLength() {
        return length;
    }

    public void setHeadDirection(Direction direction){
        if (direction == headDirection.opposite())
            return;
        headDirection = direction;
    }

    public Location getHeadLocation(){
        return head.location;
    }

    public boolean isHeadIntersected(){
        SnakeBlock currentBlock = head.previousBlock;
        while (currentBlock != null){
            if (currentBlock.location == head.location)
                return true;
            currentBlock = currentBlock.previousBlock;
        }
        return false;
    }
}
