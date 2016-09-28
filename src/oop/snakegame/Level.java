package oop.snakegame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

class Level {

    private Field field;
    private Snake snake;

    private List<Bonus> bonuses;

    private Random random;

    Level(Field field, Snake snake, List<Bonus> bonuses) {
        this.field = field;
        this.snake = snake;
        this.bonuses = bonuses;
        this.random = new Random();
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
                generateBonus();
                break;
            }
        }
    }

    private void generateBonus(){
        List<Location> freeCells = findFreeCells();
        int index = random.nextInt(freeCells.size());
        int increment = random.nextInt(4) + 1;
        bonuses.add(new SizeBonus(freeCells.get(index), increment));
    }

    private List<Location> findFreeCells(){
        HashSet<Location> result = new HashSet<>();
        result.addAll(field.getCellsOfType(CellType.Empty));
        for (SnakeBlock block: snake){
            result.remove(block.getLocation());
        }
        for (Bonus bonus: bonuses){
            result.remove(bonus.getLocation());
        }
        return new ArrayList<>(result);
    }

    private boolean isCollision(){
        return !field.isFree(snake.getHeadLocation()) || snake.isHeadIntersected();
    }

    List<Bonus> getBonuses() {
        return bonuses;
    }
}
