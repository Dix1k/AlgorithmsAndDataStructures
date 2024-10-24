package lesson3.array_examples.good_practice;

public class HighInterfaceArrayImpl implements HighInterfaceArray {
    private final long[] array;
    private int nElems;

    public HighInterfaceArrayImpl(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    @Override
    public boolean find(long searchValue) {
        for (int i = 0; i < this.nElems; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    @Override
    public void delete(long value) {
        int i;
        for (i = 0; i < this.nElems; i++) {
            if (array[i] == value) {
                break;
            }
        }

        if (i == nElems - 1) {
        } else {
            for (int j = i; j < nElems - 1; j++) {
                array[j] = array[j + 1];
            }
            nElems--;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return this.nElems;
    }

    // Реализация метода поиска минимального элемента массива
    @Override
    public int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Реализация метода поиска максимального элемента массива
    @Override
    public int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Возвращаем копию массива длиной, соответствующей количеству элементов
    public long[] getArray() {
        return array.clone();
    }

}
