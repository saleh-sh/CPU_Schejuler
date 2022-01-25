package algorithms;

import entities.Task;

public interface Scheduler {
    void schedule();
    Task getNextTask();
    void addToReady(Task t);
}
