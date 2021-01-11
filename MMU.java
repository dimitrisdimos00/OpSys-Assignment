import java.util.ArrayList;

public class MMU {

    private final int[] availableBlockSizes;
    private MemoryAllocationAlgorithm algorithm;
    private ArrayList<MemorySlot> currentlyUsedMemorySlots;

    public MMU(int[] availableBlockSizes, MemoryAllocationAlgorithm algorithm) {
        this.availableBlockSizes = availableBlockSizes;
        this.algorithm = algorithm;
        this.currentlyUsedMemorySlots = new ArrayList<MemorySlot>();
    }

    public boolean loadProcessIntoRAM(Process p) {
        boolean fit = false;
        /* TODO: you need to add some code here
         * Hint: this should return true if the process was able to fit into memory
         * and false if not */
        int address = algorithm.fitProcess(p, currentlyUsedMemorySlots);


        if (address != -1) {
            fit = true;

            // updating the currentlyUsedMemorySlots ArrayList with the new address
            // if the address is within the range of an already used memory slot
            boolean existsAlready = false;
            for (int i = 0; i < currentlyUsedMemorySlots.size(); i++) {
                int blockStart = currentlyUsedMemorySlots.get(i).getBlockStart();
                int blockEnd = currentlyUsedMemorySlots.get(i).getBlockEnd();

                if (address >= blockStart && address <= blockEnd) {
                    currentlyUsedMemorySlots.get(i).setEnd(address + p.getMemoryRequirements());
                    existsAlready = true;
                    break;
                }
            }

            // if the returned address is not within the scope of an already used memory slot
            // a new one is created, using the availableBlockSizes array in order to define blockStart, blockEnd.
            // In this case the returned address shall always be equal to the blockStart address.
            if (!existsAlready) {
                int blockStart = 0, blockEnd = availableBlockSizes[0] - 1;
                int i = 1;
                while (address != blockStart ) { // alternatively while(address > blockEnd)
                    blockStart = blockEnd + 1;
                    blockEnd += availableBlockSizes[i];
                    i++;
                }
                MemorySlot memorySlot = new MemorySlot(address, p.getMemoryRequirements() - 1, blockStart, blockEnd);
                currentlyUsedMemorySlots.add(memorySlot);
            }
        }

        return fit;
    }
}
