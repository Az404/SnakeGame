package oop.snakegame;

enum PlayerState{
    Alive, Dead
}

public class Player {
    private int score;
    private Snake snake;

    public IControllableSnake getSnake(){
        return snake;
    }

    void setSnake(Snake snake){
        this.snake = snake;
    }

    PlayerState getState(){
        return snake.isDead() ? PlayerState.Dead : PlayerState.Alive;
    }
}
