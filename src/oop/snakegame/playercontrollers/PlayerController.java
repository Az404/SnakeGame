package oop.snakegame.playercontrollers;

import oop.snakegame.primitives.Direction;
import oop.snakegame.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class PlayerController {
    private Player player;
    private boolean wasCommandReverse = false;
    private Direction snakeDirection;
    PlayerController(Player player){
        this.player = player;
    }

    public void controlPlayer(){
        if (snakeDirection != null) {
            player.getSnake().setNextHeadDirection(snakeDirection);
            snakeDirection = null;
        }
        if (wasCommandReverse) {
            player.getSnake().reverse();
            wasCommandReverse = false;
        }
    }

    public void setSnakeDirection(Direction direction){
        snakeDirection = direction;
    }
    public void reverseSnake() {
        wasCommandReverse = true;
    }
}
