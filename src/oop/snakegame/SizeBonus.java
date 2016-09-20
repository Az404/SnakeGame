package oop.snakegame;

public class SizeBonus extends Bonus {

    private int sizeIncrement;

    public SizeBonus(Location location, int sizeIncrement) {
        super(location);
        this.sizeIncrement = sizeIncrement;
    }

    @Override
    public void apply(Level level) {
        level.snake.extend(sizeIncrement);
    }
}
