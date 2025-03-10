package LaboratoryWorkNo1;

public class ShellSortArray {
    private final long[] array;
    private int nElems;

    private long comparisons = 0; // Счетчик сравнений
    private long swaps = 0;       // Счетчик обменов

    public ShellSortArray(int max) {
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

    // Метод для сортировки с использованием последовательности Кнута
    public void shellSortKnuth() {
        resetCounters();
        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        shellSortWithSequence(h, "Кнут", 0);
    }

    // Метод для сортировки с использованием последовательности Седжвика
    public void shellSortSedgewick() {
        resetCounters();
        int k = 0;
        int h = 1;

        // Вычисляем максимальный шаг из последовательности Седжвика
        while (h <= nElems / 3) {
            if (k % 2 == 0) {
                h = 9 * (int) Math.pow(2, k) - 9 * (int) Math.pow(2, k / 2) + 1;
            } else {
                h = 8 * (int) Math.pow(2, k) - 6 * (int) Math.pow(2, (k + 1) / 2) + 1;
            }
            k++;
        }

        // Сортировка с использованием последовательности Седжвика
        shellSortWithSequence(h, "Седжвик", k - 1); // Передаем k - 1, так как k было увеличено в цикле
    }

    // Метод для сортировки с использованием последовательности Хиббарда
    public void shellSortHibbard() {
        resetCounters();
        int k = 0; // Инициализация переменной k
        int h = 1;

        // Вычисляем максимальный шаг из последовательности Хиббарда
        while (h <= nElems / 3) {
            h = (int) Math.pow(2, k) - 1;
            k++;
        }

        // Сортировка с использованием последовательности Хиббарда
        shellSortWithSequence(h, "Хиббард", k - 1);
    }

    // Метод для сортировки с использованием последовательности Пратта
    public void shellSortPratt() {
        resetCounters();
        int h = 1;
        while (h <= nElems / 3) {
            h = 2 * h;
        }
        shellSortWithSequence(h, "Пратт", 0);
    }

    // Общий метод для сортировки с заданной последовательностью
    private void shellSortWithSequence(int h, String sequenceType, int k) {
        int inner, outer;
        long temp;

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= temp) {
                    comparisons++;
                    array[inner] = array[inner - h];
                    inner -= h;
                    swaps++;
                }
                comparisons++;
                array[inner] = temp;
            }

            // Пересчет h в зависимости от последовательности
            switch (sequenceType) {
                case "Кнут":
                    h = (h - 1) / 3;
                    break;
                case "Седжвик":
                    k--;
                    if (k % 2 == 0) {
                        h = 9 * (int) Math.pow(2, k) - 9 * (int) Math.pow(2, k / 2) + 1;
                    } else {
                        h = 8 * (int) Math.pow(2, k) - 6 * (int) Math.pow(2, (k + 1) / 2) + 1;
                    }
                    break;
                case "Хиббард":
                    k--;
                    h = (int) Math.pow(2, k) - 1;
                    break;
                case "Пратт":
                    if (h % 2 == 0) {
                        h = h / 2;
                    } else {
                        h = h / 3;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип последовательности: " + sequenceType);
            }
        }
    }
}