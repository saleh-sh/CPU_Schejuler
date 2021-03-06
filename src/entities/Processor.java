package entities;

import java.util.LinkedList;
import java.util.Queue;

import enums.Algorithm;

public class Processor {

    private final Queue<Task> readyQueue;
    private boolean busy;
    private int time;
    private Task currentTask;
    private Scheduler scheduler;
    private Dispatcher dispatcher;

    public static Processor INSTANCE = new Processor();

    private Processor() {
        this.time = 0;
        this.busy = false;
        this.readyQueue = new LinkedList<>();
        this.scheduler = new Scheduler();
        this.dispatcher = new Dispatcher();
    }

    public void run(Algorithm algorithm) {
        switch (algorithm) {
            case SJF:
                this.dispatcher.sjfDispatch();
                break;

            case RR:
                this.dispatcher.rrDispatch();
                break;

            case HRRN:
                this.dispatcher.hrrnDispatch();
                break;

            default:
                this.dispatcher.fcfsDispatch();
        }
    }

    public boolean isBusy() {
        return busy;
    }

    public void assign(Task currentTask) {
        this.currentTask = currentTask;
        this.busy = true;
    }

    public void unassign() {
        this.currentTask = null;
        this.busy = false;
    }

    public void increaseTime() {
        this.time++;
    }

    public void addToReady(Task t) {
        this.readyQueue.add(t);
    }

    public Queue<Task> getReadyQueue() {
        return this.readyQueue;
    }

    public int getReadyTaskCount() {
        return this.readyQueue.size();
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(" ____________________\n");
        builder.append(" Total CPU Time : " + this.time + "\n");
        builder.append(" ####################\n");
        builder.append(" Ready Queue : \n");
        for (Task t : this.readyQueue) {
            builder.append(" ....................\n");
            builder.append(t.toString());
        }
        builder.append(" ####################\n");
        if (this.currentTask != null)
            builder.append(" Current Task : \n" + this.currentTask.toString());
        else
            builder.append(" Current Task : \n" + "  processor is free!!!\n");
        builder.append("\n");
        return builder.toString();
    }
}
