package oop.snakegame.primitives;

public enum Direction {
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
