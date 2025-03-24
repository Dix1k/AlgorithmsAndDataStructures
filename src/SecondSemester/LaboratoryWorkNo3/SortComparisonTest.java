package LaboratoryWorkNo3;

import java.util.Random;

public class SortComparisonTest {
    public static void main(String[] args) {
        int size = 1000000;//Размер массива
        Random random = new Random();

        // Создание массива и заполнение случайными значениями
        QuickSortWithInsertion quickSortArray = new QuickSortWithInsertion(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            quickSortArray.insert(value);
        }

        ShellSortArray shellSortArrayKnuth = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            shellSortArrayKnuth.insert(value);
        }

        ShellSortArray shellSortArraySedgewick = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            shellSortArraySedgewick.insert(value);
        }

        ShellSortArray shellSortArrayHibbard = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            shellSortArrayHibbard.insert(value);
        }

        ShellSortArray shellSortArrayPratt = new ShellSortArray(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            shellSortArrayPratt.insert(value);
        }

        MergeSortArray mergeSortArray = new MergeSortArray(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            mergeSortArray.insert(value);
        }

        // Выполнение Быстрой сортировки
        long startTime = System.nanoTime();
        quickSortArray.quickSort();
        long endTime = System.nanoTime();
        double durationQuickSort = (endTime - startTime) / 1e6;
        System.out.println("Быстрая сортировка - Время: " + durationQuickSort + " мс, Сравнений: " + quickSortArray.getComparisons() + ", Обменов: " + quickSortArray.getSwaps());

        // Сортировка Шелла
        System.out.println("Сортировка Шелла:");
        // Сравнение последовательности Кнута
        startTime = System.nanoTime();
        shellSortArrayKnuth.shellSortKnuth();
        endTime = System.nanoTime();
        double durationKnuth = (endTime - startTime) / 1e6;
        System.out.println("    Последовательность Кнута - Время: " + durationKnuth + " мс, Сравнений: " + shellSortArrayKnuth.getComparisons() + ", Обменов: " + shellSortArrayKnuth.getSwaps());

        // Сравнение последовательности Седжвика
        startTime = System.nanoTime();
        shellSortArraySedgewick.shellSortSedgewick();
        endTime = System.nanoTime();
        double durationSedgewick = (endTime - startTime) / 1e6;
        System.out.println("    Последовательность Седжвика - Время: " + durationSedgewick + " мс, Сравнений: " + shellSortArraySedgewick.getComparisons() + ", Обменов: " + shellSortArraySedgewick.getSwaps());

        // Сравнение последовательности Хиббарда
        startTime = System.nanoTime();
        shellSortArrayHibbard.shellSortHibbard();
        endTime = System.nanoTime();
        double durationHibbard = (endTime - startTime) / 1e6;
        System.out.println("    Последовательность Хиббарда - Время: " + durationHibbard + " мс, Сравнений: " + shellSortArrayHibbard.getComparisons() + ", Обменов: " + shellSortArrayHibbard.getSwaps());

        // Сравнение последовательности Пратта
        startTime = System.nanoTime();
        shellSortArrayPratt.shellSortPratt();
        endTime = System.nanoTime();
        double durationPratt = (endTime - startTime) / 1e6;
        System.out.println("    Последовательность Пратта - Время: " + durationPratt + " мс, Сравнений: " + shellSortArrayPratt.getComparisons() + ", Обменов: " + shellSortArrayPratt.getSwaps());

        // Выполнение сортировки слиянием
        startTime = System.nanoTime();
        mergeSortArray.sort();
        endTime = System.nanoTime();
        double durationMergeSort = (endTime - startTime) / 1e6;
        System.out.println("Сортировка слиянием - Время: " + durationMergeSort + " мс, Сравнений: " + mergeSortArray.getComparisons() + ", Обменов: " + mergeSortArray.getSwaps());

    }
}