package LaboratoryWorkNo3;

public class MergeSortArray {
    private long[] data;
    private int elementsNumber;
    private int comparisons; // Счётчик сравнений
    private int swaps;       // Счётчик обменов

    public MergeSortArray(int size) {
        data = new long[size];
        elementsNumber = 0;
        comparisons = 0;
        swaps = 0;
    }

    public void insert(long value) {
        data[elementsNumber] = value;
        elementsNumber++;
    }

    public void sort() {
        long[] tempArray = new long[elementsNumber];
        comparisons = 0; // Сброс счётчика сравнений
        swaps = 0;       // Сброс счётчика обменов
        mergeSort(tempArray, 0, elementsNumber - 1);
    }

    private void mergeSort(long[] tempArray, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int middle = (lowerBound + upperBound) / 2;
            mergeSort(tempArray, lowerBound, middle);
            mergeSort(tempArray, middle + 1, upperBound);
            merge(tempArray, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(long[] tempArr, int lowPtr, int highPtr, int upperBound) {
        int tempArrIndex = 0;
        int lowerBound = lowPtr;
        int middle = highPtr - 1;
        int elementsNumber = upperBound - lowerBound + 1;

        while (lowPtr <= middle && highPtr <= upperBound) {
            comparisons++; // Увеличиваем счётчик сравнений
            if (data[lowPtr] < data[highPtr]) {
                tempArr[tempArrIndex++] = data[lowPtr++];
            } else {
                tempArr[tempArrIndex++] = data[highPtr++];
            }
            swaps++; // Увеличиваем счётчик обменов
        }

        while (lowPtr <= middle) {
            tempArr[tempArrIndex++] = data[lowPtr++];
            swaps++; // Увеличиваем счётчик обменов
        }

        while (highPtr <= upperBound) {
            tempArr[tempArrIndex++] = data[highPtr++];
            swaps++; // Увеличиваем счётчик обменов
        }

        for (tempArrIndex = 0; tempArrIndex < elementsNumber; tempArrIndex++) {
            data[lowerBound + tempArrIndex] = tempArr[tempArrIndex];
            swaps++; // Увеличиваем счётчик обменов
        }
    }

    // Геттеры для получения количества сравнений и обменов
    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public long[] getData() {
        return data;
    }
}