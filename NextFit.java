import java.util.ArrayList;

public class NextFit extends MemoryAllocationAlgorithm {

    public NextFit(int[] availableBlockSizes) {
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

        // looking for the first MemorySlot with the required size in the defaultMemoryBlocks ArrayList from end to
        // start and returning the address if one is found
        int processRequirements = p.getMemoryRequirements();
        int availableBlockSpace;
        for (int j = defaultMemoryBlocks.size() - 1; j >= 0; j--) {
            MemorySlot m = defaultMemoryBlocks.get(j);
            availableBlockSpace = m.getBlockEnd() - m.getEnd();
            if (availableBlockSpace >= processRequirements) {
                address = m.getEnd() + 1;
                break;
            }
        }
        return address;
    }

}
