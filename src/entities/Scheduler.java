package entities;

import java.util.Queue;

import enums.Algorithm;

public class Scheduler {

    public Task schedule(Algorithm algorithm) {
        switch (algorithm) {
            case SJF:
                return sjfScheduling();
            case RR:
                return rrScheduling();

            default:
                return fcfsScheduling();
        }
    }

    private Task sjfScheduling() {
        return null;
    }

    private Task rrScheduling() {
        return null;
    }

    private Task fcfsScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        return readyQueue.poll();
    }

}
