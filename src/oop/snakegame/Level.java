package oop.snakegame;

import java.util.List;
import java.util.Random;

public class Level {

    private Field field;
    Snake snake;

    private List<Bonus> bonuses;

//    public static Level createLevel(Random random){
//         Field field = ...
//         Snake snake = ...
//         return Level(field, snake, ...)
//    }
//
//    public static Level createLevel(String filename){}

    public Level(Field field, Snake snake, List<Bonus> bonuses) {
        this.field = field;
        this.snake = snake;
        this.bonuses = bonuses;
    }

    public void handleTick() throws GameOverException {
        snake.move();
       if (isCollision()){
           throw new GameOverException();
        }
        handleBonuses();
    }

    private void handleBonuses(){
        for (Bonus bonus:bonuses) {
            if (bonus.getLocation() == snake.getHeadLocation())
                bonus.apply(this);
            //bonuses.remove(bonus);
            //break;
        }
    }

    private boolean isCollision(){
        return field.isFree(snake.getHeadLocation()) && !snake.isHeadIntersected();
    }

}
