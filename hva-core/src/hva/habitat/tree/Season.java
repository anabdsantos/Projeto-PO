package hva.habitat.tree;

public enum Season {
    PRIMAVERA(0), VERAO(1), OUTONO(2), INVERNO(3);

    private int _value;

    Season(int n) {
        _value = n;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int n) {
        _value = n;
    }

    public Season next() {
        return values()[(_value + 1) % values().length];
    }
}
