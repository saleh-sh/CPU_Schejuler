package entities;
public class Task {
    public final String NAME;
    public final Type TYPE;
    public final int PRIORITY;
    private final int DURATION;
    private State state;
    private int totalTime;

    public Task(String name, Type type, int duration) {
        this.NAME = name;
        this.TYPE = type;
        this.PRIORITY = type.priority;
        this.DURATION = duration;
        this.totalTime = 0;
    }
}
