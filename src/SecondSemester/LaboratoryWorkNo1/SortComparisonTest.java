package LaboratoryWorkNo1;

import java.util.Random;

public class SortComparisonTest {
    public static void main(String[] args) {
        int size = 100000; // Размер массива
        Random random = new Random();

        // Создание массивов
        SelectionSortArray selectionSortArray = new SelectionSortArray(size);
        InsertionSortArray insertionSortArray = new InsertionSortArray(size);
        BubbleSortArray bubbleSortArray = new BubbleSortArray(size);
        ShellSortArray shellSortArrayKnuth = new ShellSortArray(size);
        ShellSortArray shellSortArraySedgewick = new ShellSortArray(size);
        ShellSortArray shellSortArrayHibbard = new ShellSortArray(size);
        ShellSortArray shellSortArrayPratt = new ShellSortArray(size);

        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            selectionSortArray.insert(value);
            insertionSortArray.insert(value);
            bubbleSortArray.insert(value);
            shellSortArrayKnuth.insert(value);
            shellSortArraySedgewick.insert(value);
            shellSortArrayHibbard.insert(value);
            shellSortArrayPratt.insert(value);
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

        // Сортировка Шелла
        // Сравнение последовательности Кнута
        long startTime = System.nanoTime();
        shellSortArrayKnuth.shellSortKnuth();
        long endTime = System.nanoTime();
        double durationKnuth = (endTime - startTime) / 1e6;
        System.out.println("Последовательность Кнута - Время: " + durationKnuth + " мс, Сравнений: " + shellSortArrayKnuth.getComparisons() + ", Обменов: " + shellSortArrayKnuth.getSwaps());

        // Сравнение последовательности Седжвика
        startTime = System.nanoTime();
        shellSortArraySedgewick.shellSortSedgewick();
        endTime = System.nanoTime();
        double durationSedgewick = (endTime - startTime) / 1e6;
        System.out.println("Последовательность Седжвика - Время: " + durationSedgewick + " мс, Сравнений: " + shellSortArraySedgewick.getComparisons() + ", Обменов: " + shellSortArraySedgewick.getSwaps());

        // Сравнение последовательности Хиббарда
        startTime = System.nanoTime();
        shellSortArrayHibbard.shellSortHibbard();
        endTime = System.nanoTime();
        double durationHibbard = (endTime - startTime) / 1e6;
        System.out.println("Последовательность Хиббарда - Время: " + durationHibbard + " мс, Сравнений: " + shellSortArrayHibbard.getComparisons() + ", Обменов: " + shellSortArrayHibbard.getSwaps());

        // Сравнение последовательности Пратта
        startTime = System.nanoTime();
        shellSortArrayPratt.shellSortPratt();
        endTime = System.nanoTime();
        double durationPratt = (endTime - startTime) / 1e6;
        System.out.println("Последовательность Пратта - Время: " + durationPratt + " мс, Сравнений: " + shellSortArrayPratt.getComparisons() + ", Обменов: " + shellSortArrayPratt.getSwaps());
    }
}
