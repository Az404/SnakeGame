package oop.snakegame;

abstract class PlayerController {
    private Player player;

    PlayerController(Player player){
        this.player = player;
    }

    protected void setHeadDirection(Direction direction){
        player.getSnake().setNextHeadDirection(direction);
    }
}
