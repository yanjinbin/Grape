package chapter6;

/**
 * @Author Silver bullet
 * @Since 2017/6/27
 */
public class Herb {
    protected enum Type {ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    protected final Type type;

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
