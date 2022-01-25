package entities;

public class Task {

    private State state;
    private int totalTime;

    // constants
    public final String NAME;
    public final Type TYPE;
    public final int PRIORITY;
    public final int DURATION;

    public Task(String name, Type type, int duration) {
        this.NAME = name;
        this.TYPE = type;
        this.PRIORITY = type.priority;
        this.DURATION = duration;
        this.totalTime = 0;
        this.state = State.READY;
    }

    public void increaseTotalTime() {
        this.totalTime++;
    }

    public void run(){
        this.state = State.RUNNING;
    }

    public void terminate(){
        this.state = State.TERMINATED;
    }

    public boolean isTerminated(){
        return (this.totalTime == this.DURATION);
    }


}
