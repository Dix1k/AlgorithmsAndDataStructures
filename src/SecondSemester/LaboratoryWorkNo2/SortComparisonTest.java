package LaboratoryWorkNo2;

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

        QuickSortWithoutRecursion quickSortArrayWithoutRecursion = new QuickSortWithoutRecursion(size);
        for (int i = 0; i < size; i++) {
            long value = random.nextInt(100000);
            quickSortArrayWithoutRecursion.insert(value);
        }

        // Выполнение Быстрой сортировки
        long startTime = System.nanoTime();
        quickSortArray.quickSort();
        long endTime = System.nanoTime();
        double durationHibbard = (endTime - startTime) / 1e6;
        System.out.println("Быстрая сортировка - Время: " + durationHibbard + " мс, Сравнений: " + quickSortArray.getComparisons() + ", Обменов: " + quickSortArray.getSwaps());

        startTime = System.nanoTime();
        quickSortArrayWithoutRecursion.quickSortWithoutRecursion();
        endTime = System.nanoTime();
        durationHibbard = (endTime - startTime) / 1e6;
        System.out.println("Быстрая сортировка без рекурсии - Время: " + durationHibbard + " мс, Сравнений: " + quickSortArrayWithoutRecursion.getComparisons() + ", Обменов: " + quickSortArrayWithoutRecursion.getSwaps());

    }
}