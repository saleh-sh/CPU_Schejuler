package IO;

import entities.Processor;

public class OutputGenerator {
    
    public static void generateOutput(){
        System.out.println(Processor.INSTANCE.toString());
    }
}
