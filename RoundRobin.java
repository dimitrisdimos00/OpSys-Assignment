public class RoundRobin extends Scheduler {

    private int quantum;

    private static int i = 0; // made a static int i
    
    public RoundRobin() {
        super(); // added super constructor
        this.quantum = 1; // default quantum
        /* TODO: you _may_ need to add some code here */
    }
    
    public RoundRobin(int quantum) {
        this();
        this.quantum = quantum;
    }

    public void addProcess(Process p) {
        /* TODO: you need to add some code here */
        processes.add(p);
    }
    
    public Process getNextProcess() {
        /* TODO: you need to add some code here
         * and change the return value */
        if (i == processes.size() - 1)
            i = 0;
        i++;

        Process p = processes.get(i - 1); // get the next process in line

        int BurstTime = p.getBurstTime(); // the process's current burst time
        int diff = BurstTime - quantum;
        if (diff <= 0) // if difference between burst time and quantum etc. remaining burst time is under 0 the process is completed
            processes.remove(p);
        else
            p.setBurstTime(diff); // else reduce the burst time to difference == remaining burst time
        return p;
    }
}
