package entities;

import java.util.Queue;

public class Scheduler {


    public Task sjfScheduling() {
        return null;
    }

    public Task rrScheduling() {
        return null;
    }

    public Task fcfsScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        return readyQueue.poll();
    }

}
