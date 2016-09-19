package oop.snakegame;

enum direction {
    Up,
    Right,
    Down,
    Left;

    public direction oposite() {
        if (this == direction.Down)
            return direction.Up;
        else if (this == direction.Left)
            return direction.Right;
        else if (this == direction.Right)
            return direction.Left;
        else return direction.Down;
    }

    public  static Offset getOffset(direction directionOffset) {
        if (directionOffset == direction.Down)
            return new Offset(0, 1);
        else if (directionOffset == direction.Left)
            return new Offset(-1, 0);
        else if (directionOffset == direction.Right)
            return new Offset(1, 0);
        else return new Offset(0, -1);
    }
}

public class Snake {
    static class SnakeBlock {
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
    private direction directionHead;
    private SnakeBlock head;
    private SnakeBlock tail;
    private int length;
    public Snake(Location location, direction directionHead) {
        this.directionHead = directionHead;
        head = new SnakeBlock(location);
        tail = head;
        length = 1;
    }
    public void increase(int increment) {
        for (int i = 0; i < increment; i++)
            increase();
    }
    public void increase() {
        direction opositeDirection = directionHead.oposite();
        Offset offsetTail = direction.getOffset(opositeDirection);
        SnakeBlock newTail = new SnakeBlock(tail.location.addOffset(offsetTail));
        tail.setPreviousBlock(newTail);
        newTail.setNextBlock(tail);
        tail = newTail;
        length++;
    }
    public int getLenght() {
        return length;
    }

}
