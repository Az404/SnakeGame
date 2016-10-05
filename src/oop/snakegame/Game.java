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
        } catch (CollisionException e) {
            state = GameState.Loss;
        } catch (GameException e){
            e.printStackTrace();
        }
    }

    GameState getState(){
        return state;
    }

    void setSnakeDirection(Direction direction) {
        level.snake.setNextHeadDirection(direction);
    }

    void loadLevel(Level level){
        state = GameState.Proceed;
        this.level = level;
    }

    Level getLevel(){
        return level;
    }

}
