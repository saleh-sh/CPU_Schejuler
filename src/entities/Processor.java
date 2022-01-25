package entities;

import algorithms.Scheduler;

public class Processor {

    private boolean busy;
    private int time;
    private Task currentTask;
    private Scheduler scheduler;
    public static Processor INSTANCE = new Processor();

    private Processor(){
        this.time = 0;
        this.busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public void assign(Task currentTask) {
        this.currentTask = currentTask;
        this.busy = true;
    }

    public void unassign(){
        this.currentTask = null;
        this.busy = false;
    }

    public void increaseTime(){
        this.time++;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("_______________________________________________________________________________");
        builder.append("Ready Queue : \n" + this.scheduler.toString());
        builder.append("Current Task : \n" + this.currentTask.toString());

        return builder.toString();
    }
}
