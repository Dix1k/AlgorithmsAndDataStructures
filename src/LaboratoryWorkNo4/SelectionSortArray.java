package LaboratoryWorkNo4;

public class SelectionSortArray {
    private final long[] array;
    private int nElems;

    private long comparisons = 0; // Счетчик сравнений
    private long swaps = 0;       // Счетчик обменов

    public SelectionSortArray(int max) {
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

    public void selectionSort() {
        resetCounters();
        for (int out = 0; out < nElems - 1; out++) {
            int min = out;
            for (int in = out + 1; in < nElems; in++) {
                comparisons++;
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            if (min != out) {
                swaps++;
                swap(out, min);
            }
        }
    }

    private void swap(int one, int two) {
        long temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}