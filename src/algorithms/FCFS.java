package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import entities.Task;


public class FCFS implements Scheduler{

    private final Queue<Task> readyQueue;
    public FCFS(){
        this.readyQueue = new LinkedList<>();
    }

    @Override
    public Task schedule() {
        return null;
    }
    
}
