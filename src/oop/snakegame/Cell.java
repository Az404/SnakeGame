package oop.snakegame;

abstract class Cell {
    private Location location;

    Cell(Location location) {
        this.location = location;
    }

    Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass())
            return false;
        Cell other = (Cell)obj;
        return location.equals(other.getLocation());
    }
}
