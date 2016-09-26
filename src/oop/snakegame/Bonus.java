package oop.snakegame;


abstract class Bonus extends Cell {

    Bonus(Location location) {
        super(location);
    }

    public abstract void apply(Level level);
}
