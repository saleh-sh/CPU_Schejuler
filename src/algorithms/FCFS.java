package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import IO.OutputGenerator;
import entities.Processor;
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

            if (!processor.isBusy()) {
                // selected task
                currentTask = getNextTask();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            if (currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            OutputGenerator.generateOutput();
            processor.increaseTime();
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Task task : this.readyQueue){
            builder.append(task.toString());
        }
        return builder.toString();
    }
}
