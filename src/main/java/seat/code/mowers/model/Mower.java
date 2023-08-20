package seat.code.mowers.model;

public class Mower {
    private Coordinate coordinate;
    private ECardinale cardinale;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Mower(String mowerOptions) {
        String[] mowerOption = mowerOptions.split(" ");
        String x = mowerOption[0];
        String y = mowerOption[1];
        String pointCardinale = mowerOption[2];

        setCoordinate(Integer.valueOf(x), Integer.valueOf(y));
        setCardinale(ECardinale.getEnumByFirstLetter(pointCardinale));
    }

    public void setCoordinate(int x, int y) {
        this.coordinate = new Coordinate(x, y);
    }
    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ECardinale getCardinale() {
        return cardinale;
    }

    public void setCardinale(ECardinale cardinale) {
        this.cardinale = cardinale;
    }

    public void setAction(EMowerOption mowerOption) {
        switch(mowerOption) {
            case MOVE -> move();
            case ROTATE_LEFT -> rotate(-1);
            case ROTATE_RIGHT -> rotate(1);
        }
    }

    public void move() {
        switch(cardinale) {
            case NORTH -> getCoordinate().sumYCoordinate(1);
            case SOUTH -> getCoordinate().sumYCoordinate(-1);
            case EAST -> getCoordinate().sumXCoordinate(1);
            case WEST -> getCoordinate().sumXCoordinate(-1);
        }
    }

    public void rotate(int position) {
        if(cardinale.getValue() + position < ECardinale.NORTH.getValue()) {
            this.cardinale = ECardinale.WEST;
        } else if(cardinale.getValue() + position > ECardinale.WEST.getValue()) {
            this.cardinale = ECardinale.NORTH;
        } else {
            this.cardinale = ECardinale.getEnum(cardinale.getValue() + position);
        }
    }

    public String toOutputString() {
        return this.getCoordinate().getX() + " " + this.getCoordinate().getY() + " " + this.getCardinale().toString().substring(0,1);
    }
}
