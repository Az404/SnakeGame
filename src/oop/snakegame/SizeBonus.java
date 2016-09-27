package oop.snakegame;

class SizeBonus extends Bonus {

    private int sizeIncrement;

    SizeBonus(Location location, int sizeIncrement) {
        super(location);
        this.sizeIncrement = sizeIncrement;
    }

    @Override
    public void apply(Level level) {
        level.getSnake().extend(sizeIncrement);
    }
}
