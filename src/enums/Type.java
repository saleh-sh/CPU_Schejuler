package enums;

public enum Type {
    X, Y, Z;

    public int priority;

    static {
        X.priority = 3;
        Y.priority = 2;
        Z.priority = 1;
    }
}
