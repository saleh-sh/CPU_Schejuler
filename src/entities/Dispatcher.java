package entities;
import IO.OutputGenerator;

public class Dispatcher {
    

    public void sjfDispatch() {
        
        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0) {
            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.sjfScheduling();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            if (currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            OutputGenerator.generateOutput();
            processor.increaseTime();
        }

    }

    public void rrDispatch() {
    }

    public void fcfsDispatch() {
        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0) {

            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.fcfsScheduling();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            if (currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            OutputGenerator.generateOutput();
            processor.increaseTime();
        }
    }
    
}
