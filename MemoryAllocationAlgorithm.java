import java.util.ArrayList;

public abstract class MemoryAllocationAlgorithm {

    protected final int[] availableBlockSizes;

    // created a protected ArrayList<Memory slot>
    protected ArrayList<MemorySlot> defaultMemoryBlocks;

    public MemoryAllocationAlgorithm(int[] availableBlockSizes) {
        this.availableBlockSizes = availableBlockSizes;

        // initializing the defaultMemoryBlocks ArrayList
        defaultMemoryBlocks = new ArrayList<>();
        int BlockStart = 0, BlockEnd = this.availableBlockSizes[0] - 1;

        for (int i = 1; i < this.availableBlockSizes.length; i++) {
            MemorySlot memorySlot = new MemorySlot(BlockStart, BlockStart, BlockStart, BlockEnd);
            defaultMemoryBlocks.add(memorySlot);
            BlockStart = BlockEnd + 1;
            BlockEnd += this.availableBlockSizes[i];
        }
    }

    public abstract int fitProcess(Process p, ArrayList<MemorySlot> currentlyUsedMemorySlots);
}
