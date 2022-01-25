package algorithms;

import java.util.ArrayList;
import entities.Task;

public class SJF implements Scheduler{

    private final ArrayList<Task> readyQueue;

    public SJF(){
        this.readyQueue = new ArrayList<>();
    }

    @Override
    public void schedule() {
    }

    @Override
    public Task getNextTask() {
        return null;
    }

    @Override
    public void addToReady(Task t) {
        this.readyQueue.add(t);        
    }

    
    
}
