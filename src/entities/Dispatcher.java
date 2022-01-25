package entities;

import IO.OutputGenerator;
import enums.Algorithm;

public class Dispatcher {
    
    public void dispatch(Algorithm algorithm){
        switch(algorithm){
            case SJF:
                sjfDispatch();
            break;

            case RR:
                rrDispatch();
            break;

            default:
                fcfsDispatch();       
        }
    }

    private void sjfDispatch() {
    }

    private void rrDispatch() {
    }

    private void fcfsDispatch() {
        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0) {

            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.schedule(Algorithm.FCFS);

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
