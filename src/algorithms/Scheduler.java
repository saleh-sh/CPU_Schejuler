package algorithms;

import entities.Task;

public interface Scheduler {
    Task schedule();
    void addToReady(Task t);
}
