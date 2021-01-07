import java.util.ArrayList;

public class WorstFit extends MemoryAllocationAlgorithm {
    
    public WorstFit(int[] availableBlockSizes) {
        super(availableBlockSizes);
    }

    public int fitProcess(Process p, ArrayList<MemorySlot> currentlyUsedMemorySlots) {
        boolean fit = false;
        int address = -1;
        /* TODO: you need to add some code here
         * Hint: this should return the memory address where the process was
         * loaded into if the process fits. In case the process doesn't fit, it
         * should return -1. */

        int i=0;
        int max=currentlyUsedMemorySlots.get(0).getBlockEnd()-currentlyUsedMemorySlots.get(0).getBlockStart();
        for(i=1;i<currentlyUsedMemorySlots.size();i++)
        {
            if(currentlyUsedMemorySlots.get(i).getBlockEnd()-currentlyUsedMemorySlots.get(i).getBlockStart()>max && p.getMemoryRequirements()<=currentlyUsedMemorySlots.get(i).getBlockEnd()-currentlyUsedMemorySlots.get(i).getBlockStart())
            {
                max=currentlyUsedMemorySlots.get(i).getBlockEnd()-currentlyUsedMemorySlots.get(i).getBlockStart();
                address=currentlyUsedMemorySlots.get(i).getStart();
            }
        }


        return address;
    }

}
