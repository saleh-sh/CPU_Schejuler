package entities;

import IO.OutputGenerator;

public class Dispatcher {

    public void sjfDispatch() {

        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0 || !currentTask.isTerminated()) {

            if (currentTask != null && currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.sjfScheduling();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            OutputGenerator.generateOutput();

            // end of cpu round
            processor.increaseTime();
        }

    }

    public void rrDispatch() {
        int quantom = 2;
        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0 || !currentTask.isTerminated()) {
            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.rrScheduling();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            OutputGenerator.generateOutput();

            if (currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            if (currentTask.isPreemted(quantom)) {
                currentTask.preemte();
                processor.unassign();
                processor.addToReady(currentTask);
            }
            processor.increaseTime();
        }

    }

    public void fcfsDispatch() {
        Processor processor = Processor.INSTANCE;
        Scheduler scheduler = processor.getScheduler();
        Task currentTask = null;

        while (processor.getReadyTaskCount() != 0 || !currentTask.isTerminated()) {

            if (currentTask != null && currentTask.isTerminated()) {
                currentTask.terminate();
                processor.unassign();
            }

            if (!processor.isBusy()) {
                // selected task
                currentTask = scheduler.fcfsScheduling();

                // assign cpu to task
                processor.assign(currentTask);

                currentTask.run();
            }

            currentTask.increaseTotalTime();
            OutputGenerator.generateOutput();

            // end of the cpu round
            processor.increaseTime();
        }
    }

}
