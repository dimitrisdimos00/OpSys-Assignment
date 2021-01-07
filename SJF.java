import java.util.ArrayList;

public class SJF extends Scheduler {

    public SJF() {
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
        ArrayList<Process> temp= processes;
        int min=processes.get(0).getBurstTime();
        int k=0;
        for(int i=0;i<processes.size();i++) {
          if(processes.get(i).getBurstTime()<min)
          {
             min=processes.get(i).getBurstTime();
             k=i;
          }
        }

        return processes.get(k) ;
    }
}
