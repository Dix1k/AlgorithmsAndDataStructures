package LaboratoryWorkNo4;

public class InsertionSortArray {
    private final long[] array;
    private int nElems;

    private long comparisons = 0; // Счетчик сравнений
    private long swaps = 0;       // Счетчик вставок

    public InsertionSortArray(int max) {
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

    public void insertionSort() {
        resetCounters();
        for (int out = 1; out < nElems; out++) {
            long temp = array[out];
            int in = out;

            while (in > 0) {
                comparisons++;
                if (array[in - 1] > temp) {
                    array[in] = array[in - 1];
                    swaps++;
                    in--;
                } else {
                    break;
                }
            }
            swaps++;
            array[in] = temp;
        }
    }
}
