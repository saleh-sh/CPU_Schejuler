import java.util.Scanner;

import algorithms.FCFS;
import algorithms.RoundRobin;
import algorithms.SJF;
import entities.Task;
import entities.Type;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FCFS fcfs = new FCFS();
        // SJF sjf = new SJF();
        // RoundRobin RR = new RoundRobin();

        // user inputs to initialization
        int taskCount = scanner.nextInt();
        for (int counter = 0; counter < taskCount; counter++) {
            String taskName = scanner.next();
            String taskType = scanner.next().toUpperCase();
            int duration = scanner.nextInt();

            Task task = new Task(taskName, Type.valueOf(taskType), duration);
            fcfs.addToReady(task);
        }

        
    }
}