package entities;
import java.util.Queue;

public class Scheduler {

    public Task sjfScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        Task shortestJob = null;
        int minDuration = Integer.MAX_VALUE;
        for (Task t : readyQueue) {
            if (t.DURATION < minDuration) {
                minDuration = t.DURATION;
                shortestJob = t;
            }
        }
        readyQueue.remove(shortestJob);
        return shortestJob;
    }

    public Task rrScheduling() {
        return null;
    }

    public Task fcfsScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        return readyQueue.poll();
    }

}
