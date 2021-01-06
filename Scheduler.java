import java.util.ArrayList;

public abstract class Scheduler {

    protected ArrayList<java.lang.Process> processes; // the list of processes to be executed
    
    public Scheduler() {
        this.processes = new ArrayList<java.lang.Process>();
    }

    /* the addProcess() method should add a new process to the list of
     * processes that are candidates for execution. This will probably
     * differ for different schedulers */
    public abstract void addProcess(java.lang.Process p);
    
    /* the removeProcess() method should remove a process from the list
     * of processes that are candidates for execution. Common for all
     * schedulers. */
    public void removeProcess(java.lang.Process p) {
        /* TODO: you need to add some code here */
        
    }
    
    /* the getNextProcess() method should return the process that should
     * be executed next by the CPU */
    public abstract java.lang.Process getNextProcess();
}
