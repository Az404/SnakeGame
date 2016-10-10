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
        for (Snake snake : level.snakes)
            if (snake.isDead())
                state = GameState.Loss;
    }

    GameState getState(){
        return state;
    }

    void setSnakeDirection( int numberSnake, Direction direction) {
        // FIXME
        if (numberSnake < level.snakes.length)
            level.snakes[numberSnake].setNextHeadDirection(direction);
    }

    void loadLevel(Level level){
        state = GameState.Proceed;
        this.level = level;
    }

    Level getLevel(){
        return level;
    }

}
