package entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        return readyQueue.poll();
    }

    public Task fcfsScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();
        return readyQueue.poll();
    }

    public Task hrrnScheduling() {
        Queue<Task> readyQueue = Processor.INSTANCE.getReadyQueue();

        int time = Processor.INSTANCE.getTime();
        double maxResponseRatio = Double.MIN_VALUE;
        Task selectedTask = null;
        for (Task t : readyQueue) {
            int waitingTime = time - t.getArrivalTime();
            double responseRatio = ((double) (waitingTime + t.DURATION)) / t.DURATION;
            if (Double.compare(responseRatio, maxResponseRatio) > 0) {
                selectedTask = t;
            }
        }

        readyQueue.remove(selectedTask);
        return selectedTask;
    }

}
