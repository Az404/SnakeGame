package oop.snakegame;

enum GameState{
    Proceed, Loss, Completed
}

public class Game {

    public Game() {

    }

    private Level level;

    private GameState state = GameState.Proceed;

    public void tick() {
        try {
            level.handleTick();
        } catch (GameOverException e) {
            state = GameState.Loss;
        }
    }

    public GameState getState(){
        return state;
    }

    public void setSnakeDirection(Direction direction) {
        level.snake.setHeadDirection(direction);
    }

    public void loadLevel(Level level){
        state = GameState.Proceed;
        this.level = level;
    }

}
