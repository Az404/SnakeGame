package oop.snakegame;


public abstract class Bonus {
    private Location location;

    public Bonus(Location location) {
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }

    public abstract void apply(Level level);
}
