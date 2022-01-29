package IO;

import java.util.Scanner;

import entities.Processor;
import entities.Task;
import enums.Type;

public class Initializer {

    public static void setup() {
        Processor processor = Processor.INSTANCE;
        try (Scanner scanner = new Scanner(System.in)) {

            // user inputs
            int taskCount = scanner.nextInt();
            for (int counter = 0; counter < taskCount; counter++) {
                String taskName = scanner.next();
                String taskType = scanner.next().toUpperCase();
                int duration = scanner.nextInt();

                Task task = new Task(taskName, Type.valueOf(taskType), duration);
                processor.addToReady(task);
            }

        }

    }

    public static void HRRN_input() {
        Processor processor = Processor.INSTANCE;
        try (Scanner scanner = new Scanner(System.in)) {

            // user inputs
            int taskCount = scanner.nextInt();
            if (taskCount != 0) {
                for (int counter = 0; counter < taskCount; counter++) {
                    String taskName = scanner.next();
                    String taskType = scanner.next().toUpperCase();
                    int duration = scanner.nextInt();

                    int arrivalTime = processor.getTime();
                    Task task = new Task(taskName, Type.valueOf(taskType), duration, arrivalTime);
                    processor.addToReady(task);
                }
            }

        }
    }

}
