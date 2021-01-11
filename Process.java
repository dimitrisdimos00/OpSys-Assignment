
public class Process {
    private ProcessControlBlock pcb;
    private int arrivalTime;
    private int burstTime;
    private int memoryRequirements;

    public Process(int arrivalTime, int burstTime, int memoryRequirements) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.memoryRequirements = memoryRequirements;
        this.pcb = new ProcessControlBlock();
    }

    public ProcessControlBlock getPCB() {
        return this.pcb;
    }

    // added getRequirements public getter

    public int getMemoryRequirements() { return memoryRequirements; }

    // methods

    public void run() {
        /* TODO: you need to add some code here
         * Hint: this should run every time a process starts running */
        pcb.setState(ProcessState.RUNNING, CPU.clock);

    }

    public void waitInBackground() {
        /* TODO: you need to add some code here
         * Hint: this should run every time a process stops running */
        pcb.setState(ProcessState.READY, CPU.clock);

    }

    public double getWaitingTime() {
        /* TODO: you need to add some code here
         * and change the return value */
        return getTurnAroundTime() - burstTime;
    }

    public double getResponseTime() {
        /* TODO: you need to add some code here
         * and change the return value */
        return pcb.getStopTimes().get(0) - pcb.getStartTimes().get(0);
    }

    public double getTurnAroundTime() {
        /* TODO: you need to add some code here
         * and change the return value */
        int lastElementStartTimes = pcb.getStartTimes().size() - 1;
        return pcb.getStartTimes().get(lastElementStartTimes) - pcb.getStopTimes().get(0);
    }
}
