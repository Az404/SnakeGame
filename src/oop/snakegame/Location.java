package oop.snakegame;

public class Location {
    private int x;
    private int y;
    public  Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return x;}
    public int getY() { return y;}
    public Location addOffset(Offset offset) {
        return new Location(x + offset.getX(), y + offset.getY());
    }


    @Override
    public int hashCode() {
        return  (x * 167) ^ y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
