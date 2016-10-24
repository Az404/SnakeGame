package oop.snakegame.playercontrollers;

import oop.snakegame.primitives.Direction;
import oop.snakegame.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class PlayerController {
    private Player player;

    private Direction snakeDirection;

    PlayerController(Player player){
        this.player = player;
    }

    public void controlPlayer(){
        if (snakeDirection != null) {
            player.getSnake().setNextHeadDirection(snakeDirection);
            snakeDirection = null;
        }
    }

    public void setSnakeDirection(Direction direction){
        snakeDirection = direction;
    }

    public void rotate() {
        throw new NotImplementedException();
    }
}
