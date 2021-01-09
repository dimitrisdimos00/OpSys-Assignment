public class CPU {

    public static int clock = 0; // this should be incremented on every CPU cycle
    
    private Scheduler scheduler;
    private MMU mmu;
    private Process[] processes;
    private int currentProcess;
    
    public CPU(Scheduler scheduler, MMU mmu, Process[] processes) {
        this.scheduler = scheduler;
        this.mmu = mmu;
        this.processes = processes;
    }
    
    public void run() {
        /* TODO: you need to add some code here
         * Hint: you need to run tick() in a loop, until there is nothing else to do... */
             int i=0;
             while(i<processes.length)
             {
                 if(mmu.loadProcessIntoRAM(processes[i]))
                 {
                     scheduler.addProcess(processes[i]);
                 }
                 i++;
             }
             int j=0;
             while(j<processes.length)
             {

             }
    }
    
    public void tick() {
        /* TODO: you need to add some code here
         * Hint: this method should run once for every CPU cycle */

    }
}
