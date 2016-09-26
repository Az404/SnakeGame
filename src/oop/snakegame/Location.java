package oop.snakegame;

class Location {
    private int x;
    private int y;
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int getX() { return x;}
    int getY() { return y;}
    Location addOffset(Offset offset) {
        return new Location(x + offset.getX(), y + offset.getY());
    }


    @Override
    public int hashCode() {
        return  (x * 167) ^ y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        return !(x != other.x || y != other.y);
    }

    @Override
    public String toString(){
        return String.format("Location(%1$d, %2$d)", x, y);
    }
}
