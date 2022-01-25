package algorithms;

import java.util.ArrayList;
import entities.Task;

public class SJF implements Scheduler{

    private final ArrayList<Task> readyQueue;

    public SJF(){
        this.readyQueue = new ArrayList<>();
    }

    @Override
    public Task schedule() {
        return null;
    }

    @Override
    public void addToReady(Task t) {
        this.readyQueue.add(t);        
    }

    
    
}
