package entities;

public class Processor {

    private boolean busy;
    private int time;
    private Task currentTask;
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
}
