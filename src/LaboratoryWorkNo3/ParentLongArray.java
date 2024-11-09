package LaboratoryWorkNo3;

public abstract class ParentLongArray implements ArrayInterface {
    protected final long[] array;
    protected int nElems;
    protected Long minValue = null; // Изначально null, чтобы определить первое вставленное значение
    protected Long maxValue = null;

    public ParentLongArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    @Override
    public boolean insert(long value) {
        if (nElems == array.length) {
            return false; // Массив полон
        }

        // Обновление минимального и максимального значения
        if (minValue == null || value < minValue) minValue = value;
        if (maxValue == null || value > maxValue) maxValue = value;

        array[nElems] = value;
        nElems++;
        return true;
    }

    @Override
    public boolean delete(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (array[i] == value) {
                break;
            }
        }

        if (i == nElems) {
            return false;
        } else {
            for (int j = i; j < nElems - 1; j++) {
                array[j] = array[j + 1];
            }
            nElems--;

            if (value == minValue || value == maxValue) {
                recalculateMinMax(); // Пересчет, если удалено min или max
            }
            return true;
        }
    }

    private void recalculateMinMax() {
        minValue = null;
        maxValue = null;
        for (int i = 0; i < nElems; i++) {
            if (minValue == null || array[i] < minValue) minValue = array[i];
            if (maxValue == null || array[i] > maxValue) maxValue = array[i];
        }
    }

    @Override
    public long getMax() {
        if (maxValue == null) throw new IllegalStateException("Array is empty");
        return maxValue;
    }

    @Override
    public long getMin() {
        if (minValue == null) throw new IllegalStateException("Array is empty");
        return minValue;
    }

    @Override
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return this.nElems;
    }
}