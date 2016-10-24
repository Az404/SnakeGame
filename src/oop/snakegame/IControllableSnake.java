package oop.snakegame;

import oop.snakegame.primitives.Direction;

public interface IControllableSnake {
    void setNextHeadDirection(Direction direction);
    void reverse();
}
