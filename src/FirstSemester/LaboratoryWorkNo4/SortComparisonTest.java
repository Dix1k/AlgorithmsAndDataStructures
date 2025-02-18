package LaboratoryWorkNo4;

import java.util.Random;

public class SortComparisonTest {
    public static void main(String[] args) {
        int size = 10000; // Размер массива
        Random random = new Random();

        // Создание массивов
        SelectionSortArray selectionSortArray = new SelectionSortArray(size);
        InsertionSortArray insertionSortArray = new InsertionSortArray(size);
        BubbleSortArray bubbleSortArray = new BubbleSortArray(size);

        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            selectionSortArray.insert(value);
            insertionSortArray.insert(value);
            bubbleSortArray.insert(value);
        }

        // Сравнение Selection Sort
        selectionSortArray.selectionSort();
        System.out.println("Сортировка выбором - Сравнений: " + selectionSortArray.getComparisons() + ", Обменов: " + selectionSortArray.getSwaps());

        // Сравнение Insertion Sort
        insertionSortArray.insertionSort();
        System.out.println("Сортировка вставками - Сравнений: " + insertionSortArray.getComparisons() + ", Перемещений: " + insertionSortArray.getSwaps());

        // Сравнение Bubble Sort
        bubbleSortArray.bubbleSort();
        System.out.println("Сортировка пузырьком - Сравнений: " + bubbleSortArray.getComparisons() + ", Обменов: " + bubbleSortArray.getSwaps());
    }
}
