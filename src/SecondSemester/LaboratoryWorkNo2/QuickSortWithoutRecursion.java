package LaboratoryWorkNo2;

import java.util.Stack;

public class QuickSortWithoutRecursion {
    private long[] data;
    private int size;
    private int comparisons;
    private int swaps;

    public QuickSortWithoutRecursion(int maxSize) {
        data = new long[maxSize];
        size = 0;
        comparisons = 0;
        swaps = 0;
    }

    public void insert(long value) {
        data[size++] = value;
    }

    public void quickSortWithoutRecursion() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, size - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int leftIndex = range[0];
            int rightIndex = range[1];

            if (rightIndex - leftIndex + 1 <= 10) { // Используем сортировку вставками для небольших подмассивов
                insertionSort(leftIndex, rightIndex);
            } else {
                long pivot = medianOfThreePoints(leftIndex, rightIndex);
                int partition = partition(leftIndex, rightIndex, pivot);

                if (partition - 1 > leftIndex) {
                    stack.push(new int[]{leftIndex, partition - 1});
                }
                if (partition + 1 < rightIndex) {
                    stack.push(new int[]{partition + 1, rightIndex});
                }
            }
        }
    }

    private long medianOfThreePoints(int leftIndex, int rightIndex) {
        int center = (leftIndex + rightIndex) / 2;

        if (data[leftIndex] > data[center]) {
            swap(leftIndex, center);
        }
        if (data[leftIndex] > data[rightIndex]) {
            swap(leftIndex, rightIndex);
        }
        if (data[center] > data[rightIndex]) {
            swap(center, rightIndex);
        }
        swap(center, rightIndex - 1);
        return data[rightIndex - 1];
    }

    private void insertionSort(int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            long temp = data[i];
            int j = i;
            while (j > leftIndex && data[j - 1] > temp) {
                data[j] = data[j - 1];
                j--;
                comparisons++;
                swaps++;
            }
            data[j] = temp;
            swaps++;
        }
    }

    private int partition(int leftIndex, int rightIndex, long pivot) {
        int leftPtr = leftIndex;
        int rightPtr = rightIndex - 1;
        while (true) {
            while (data[++leftPtr] < pivot) {
                comparisons++;
            }
            while (data[--rightPtr] > pivot) {
                comparisons++;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, rightIndex - 1);
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
        swaps++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}