package oop.snakegame;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

abstract class PlayerController {
    private Player player;

    private Direction snakeDirection;

    PlayerController(Player player){
        this.player = player;
    }

    void controlPlayer(){
        if (snakeDirection != null) {
            player.getSnake().setNextHeadDirection(snakeDirection);
            snakeDirection = null;
        }
    }

    void setSnakeDirection(Direction direction){
        snakeDirection = direction;
    }

    public void rotate() {
        throw new NotImplementedException();
    }
}
