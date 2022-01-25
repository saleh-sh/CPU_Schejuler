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
