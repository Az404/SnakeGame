package oop.snakegame;

import java.util.List;

class Level {

    private Field field;
    private Snake snake;

    private List<Bonus> bonuses;

    Level(Field field, Snake snake, List<Bonus> bonuses) {
        this.field = field;
        this.snake = snake;
        this.bonuses = bonuses;
    }

    Snake getSnake(){
        return snake;
    }

    Field getField(){
        return field;
    }

    void handleTick() throws GameOverException {
        snake.move();
        if (isCollision())
           throw new GameOverException();
        handleBonuses();
    }

    private void handleBonuses(){
        for (Bonus bonus:bonuses) {
            if (bonus.getLocation().equals(snake.getHeadLocation())) {
                bonus.apply(this);
                bonuses.remove(bonus);
                break;
            }
        }
    }

    private boolean isCollision(){
        return !field.isFree(snake.getHeadLocation()) || snake.isHeadIntersected();
    }

    List<Bonus> getBonuses() {
        return bonuses;
    }
}
