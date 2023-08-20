package seat.code.mowers.model;

public enum ECardinale {
    NORTH (0),
    EAST (1),
    SOUTH (2),
    WEST(3);

    private final int value;

    ECardinale(final int newValue) {
        value = newValue;
    }

    static ECardinale getEnum(int value) {
        for(ECardinale e: ECardinale.values()) {
            if(e.value == value) {
                return e;
            }
        }
        return null;
    }

    static ECardinale getEnumByFirstLetter(String firstLetter) {
        for(ECardinale e: ECardinale.values()) {
            if(e.toString().substring(0,1).equals(firstLetter)) {
                return e;
            }
        }
        return null;
    }

    public int getValue() { return value; }
}
