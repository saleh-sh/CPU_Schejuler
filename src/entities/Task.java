package entities;

import enums.State;
import enums.Type;

public class Task {

    private State state;
    private int totalTime;
    private int runPoint;
    private int arrivalTime;

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

    public Task(String name, Type type, int duration, int arrivalTime) {
        this(name, type, duration);
        this.arrivalTime = arrivalTime;
    }

    public void increaseTotalTime() {
        this.totalTime++;
    }

    public void run() {
        this.state = State.RUNNING;
        this.runPoint = Processor.INSTANCE.getTime();
    }

    public void terminate() {
        this.state = State.TERMINATED;
    }

    public void preemte() {
        this.state = State.READY;
    }

    public boolean isTerminated() {
        return (this.totalTime == this.DURATION);
    }

    public boolean isPreemted(int quantom) {
        int currentTime = Processor.INSTANCE.getTime();
        return ((currentTime - this.runPoint + 1 > quantom) && Processor.INSTANCE.getReadyTaskCount() != 0);
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    // HRRN
    public int getRunPoint() {
        return this.runPoint;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("  Task Name -> " + this.NAME + "\n");
        builder.append("  Task Type -> " + this.TYPE + "\n");
        builder.append("  Task Total Time -> " + this.totalTime + "\n");
        builder.append("  Task State -> " + this.state + "\n");

        builder.append(" ------- HRRN -------" + "\n");
        builder.append("  Arrival Time ->" + this.arrivalTime + "\n");

        int waitingTime = (Processor.INSTANCE.getTime() - this.arrivalTime);
        builder.append("  Waiting Time ->" + waitingTime + "\n");

        double responseRatio = ((double) (waitingTime + this.DURATION)) / this.DURATION;
        builder.append("  Response Ratio ->" + responseRatio + "\n");

        return builder.toString();
    }
}
