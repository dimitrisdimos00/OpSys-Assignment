import java.util.ArrayList;

public class FirstFit extends MemoryAllocationAlgorithm {
    
    public FirstFit(int[] availableBlockSizes) {
        super(availableBlockSizes);
    }

    public int fitProcess(Process p, ArrayList<MemorySlot> currentlyUsedMemorySlots) {
        boolean fit = false;
        int address = -1;
        /* TODO: you need to add some code here
         * Hint: this should return the memory address where the process was
         * loaded into if the process fits. In case the process doesn't fit, it
         * should return -1. */
        for(int i=0;i<currentlyUsedMemorySlots.size();i++)
        {
            if(p.getMemoryRequirements()>=(currentlyUsedMemorySlots.get(i).getEnd()-currentlyUsedMemorySlots.get(i).getStart()))
            {
                fit=true;
                address=currentlyUsedMemorySlots.get(i).getStart();
            }
        }
        return address;


    }

}
