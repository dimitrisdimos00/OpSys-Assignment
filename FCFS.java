import java.util.ArrayList;

public class FCFS extends Scheduler {

    public FCFS() {
        /* TODO: you _may_ need to add some code here */
        super();
    }

    public void addProcess(Process p) {
        /* TODO: you need to add some code here */
        processes.add(p);
    }
    
    public Process getNextProcess() {
        /* TODO: you need to add some code here
         * and change the return value */
        ArrayList<Process> temp=processes;
        Process p = temp.get(0);
        temp.remove(0);
        return p;
    }
}
