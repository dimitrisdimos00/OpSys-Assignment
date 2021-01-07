public class FCFS extends Scheduler {

    private static int i = 0;

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
        if (i < processes.size()) {
            i++;
            return processes.get(i - 1);
        }
        return null;
    }
}
