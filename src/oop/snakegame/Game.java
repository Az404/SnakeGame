package oop.snakegame;

enum GameState{
    Proceed, Loss, Completed
}

class Game {

    Game() {

    }

    private Level level;

    private GameState state = GameState.Proceed;

    void tick() {
        try {
            level.handleTick();
        } catch (GameOverException e) {
            state = GameState.Loss;
        }
    }

    public GameState getState(){
        return state;
    }

    void setSnakeDirection(Direction direction) {
        level.getSnake().setHeadDirection(direction);
    }

    void loadLevel(Level level){
        state = GameState.Proceed;
        this.level = level;
    }

    Level getLevel(){
        return level;
    }

}
