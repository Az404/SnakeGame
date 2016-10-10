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
        } catch (GameException e){
            e.printStackTrace();
        }
        // FIXME
        if (level.snakes[0].isDead())
            state = GameState.Loss;
    }

    GameState getState(){
        return state;
    }

    void setSnakeDirection(Direction direction) {
        // FIXME
        level.snakes[0].setNextHeadDirection(direction);
    }

    void loadLevel(Level level){
        state = GameState.Proceed;
        this.level = level;
    }

    Level getLevel(){
        return level;
    }

}
