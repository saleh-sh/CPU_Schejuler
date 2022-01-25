import IO.Initializer;
import entities.Processor;

public class Main {
    public static void main(String[] args) {

        Initializer.setup();
        Processor processor = Processor.INSTANCE;
        processor.run();
    }
}