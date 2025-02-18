package LaboratoryWorkNo4;

public class BubbleSortArray {
    private final long[] array;
    private int nElems;

    private long comparisons = 0; // Счетчик сравнений
    private long swaps = 0;       // Счетчик обменов

    public BubbleSortArray(int max) {
        array = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public void bubbleSort() {
        resetCounters();
        for (int out = nElems - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                comparisons++;
                if (array[in] > array[in + 1]) {
                    swaps++;
                    swap(in, in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}