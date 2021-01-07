public class FCFS extends Scheduler {

    public FCFS() {
        /* TODO: you _may_ need to add some code here */
        super();
    }

    public void addProcess(java.lang.Process p) {
        /* TODO: you need to add some code here */
        processes.add(p);
    }
    
    public java.lang.Process getNextProcess() {
        /* TODO: you need to add some code here
         * and change the return value */
        java.lang.Process p = processes.get(0);
        processes.remove(0);
        return p;
    }
}
