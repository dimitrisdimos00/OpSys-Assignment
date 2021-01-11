import java.util.ArrayList;

public class BestFit extends MemoryAllocationAlgorithm {

    public BestFit(int[] availableBlockSizes) {
        super(availableBlockSizes);
    }

    public int fitProcess(Process p, ArrayList<MemorySlot> currentlyUsedMemorySlots) {
        boolean fit = false;
        int address = -1;
        /* TODO: you need to add some code here
         * Hint: this should return the memory address where the process was
         * loaded into if the process fits. In case the process doesn't fit, it
         * should return -1. */

        // remaking the defaultMemoryBlocks ArrayList, according to the given currentlyUsedMemorySlots
        int i = 0;
        for (MemorySlot memorySlot: currentlyUsedMemorySlots) {
            while (defaultMemoryBlocks.get(i).getBlockStart() != memorySlot.getBlockStart())
                i++;
            defaultMemoryBlocks.set(i, memorySlot);
        }

        int minDiff = 99999;
        int minDiffIndex = 99999;
        for (int j = 0; j < defaultMemoryBlocks.size(); j++) {
            MemorySlot m = defaultMemoryBlocks.get(j);
            int availableSlotSize = m.getBlockEnd() - m.getEnd();
            if (availableSlotSize >= p.getMemoryRequirements() && availableSlotSize - p.getMemoryRequirements() < minDiff) {
                minDiff = availableSlotSize - p.getMemoryRequirements();
                minDiffIndex = j;
            }
        }
        if (minDiffIndex != 99999)
            address = defaultMemoryBlocks.get(minDiffIndex).getEnd() + 1;



        return address;
    }

}
