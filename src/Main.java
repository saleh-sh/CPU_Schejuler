import IO.Initializer;
import entities.Processor;
import enums.Algorithm;

public class Main {
    public static void main(String[] args) {

        Initializer.setup();
        Processor processor = Processor.INSTANCE;
        // processor.run(Algorithm.FCFS);
        // processor.run(Algorithm.SJF);
        processor.run(Algorithm.RR);
    }
} 