package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import entities.Processor;
import entities.State;
import entities.Task;

public class FCFS implements Scheduler {

    private final Queue<Task> readyQueue;

    public FCFS() {
        this.readyQueue = new LinkedList<>();
    }

    @Override
    public void schedule() {

        Processor processor = Processor.INSTANCE;
        Task currentTask = null;

        while (!this.readyQueue.isEmpty()) {
            processor.increaseTime();

            if (!processor.isBusy()) {
                // selected task
                currentTask = getNextTask();
                currentTask.run();

                // assign cpu to task
                processor.assign(currentTask);
            }

            currentTask.increaseTotalTime();
            if (currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }
            
        }
    }

    @Override
    public Task getNextTask() {
        return this.readyQueue.poll();
    }

    @Override
    public void addToReady(Task t) {
        this.readyQueue.add(t);
    }

}
