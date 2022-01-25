package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import entities.Task;

public class RoundRobin implements Scheduler{

    private final Queue<Task> readyQueue;

    public RoundRobin(){
        this.readyQueue = new LinkedList<>();
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
