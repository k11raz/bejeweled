public abstract class Jewel {

    protected char type;
    protected int points;

    protected Coordinate coordinate;

    public Jewel(char type, int points) {
        this.type = type;
        this.points = points;
    }

    public char getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }


}
