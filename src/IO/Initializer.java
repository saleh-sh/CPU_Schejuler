package IO;

import java.util.Scanner;
import algorithms.FCFS;
import algorithms.Scheduler;
import entities.Processor;
import entities.Task;
import entities.Type;

public class Initializer {

    public static void setup() {

        FCFS fcfs = new FCFS();
        // SJF sjf = new SJF();
        // RoundRobin RR = new RoundRobin();

        try (Scanner scanner = new Scanner(System.in)) {

            // user inputs
            int taskCount = scanner.nextInt();
            for (int counter = 0; counter < taskCount; counter++) {
                String taskName = scanner.next();
                String taskType = scanner.next().toUpperCase();
                int duration = scanner.nextInt();

                Task task = new Task(taskName, Type.valueOf(taskType), duration);
                fcfs.addToReady(task);
            }

        }

        Processor.INSTANCE.setScheduler(fcfs);
    }

}
