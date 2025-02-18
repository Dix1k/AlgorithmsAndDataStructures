package LaboratoryWorkNo3;

public class OrderedArray extends ParentLongArray {
    // Конструктор класса OrderedArray, вызывающий конструктор родительского класса ParentLongArray
    public OrderedArray(int size) {
        super(size);
    }

    // Переопределение метода contains для бинарного поиска элемента в отсортированном массиве
    @Override
    public boolean contains(long searchValue) {
        int operationsNumber = 0; // Счётчик операций
        int lowerBound = 0; // Нижняя граница поиска
        int upperBound = nElems - 1; // Верхняя граница поиска
        int currentIndex;

        // Выполнение бинарного поиска
        while (true) {
            System.out.println("Количество операций в упорядоченном массиве: " + ++operationsNumber);
            currentIndex = (lowerBound + upperBound) / 2; // Находим средний индекс
            long currentElement = array[currentIndex]; // Элемент в текущем индексе

            if (currentElement == searchValue) { // Если элемент найден
                return true;
            } else if (lowerBound > upperBound) { // Если границы сместились, элемент не найден
                return false;
            } else {
                // Изменение границ поиска в зависимости от значения элемента
                if (currentElement < searchValue) {
                    lowerBound = currentIndex + 1; // Искомое значение больше текущего элемента
                } else {
                    upperBound = currentIndex - 1; // Искомое значение меньше текущего элемента
                }
            }
        }
    }

    // Переопределение метода insert для вставки элемента в упорядоченный массив
    @Override
    public boolean insert(long value) {
        if (nElems == array.length) {
            return false; // Если массив полон, вернуть false
        }

        // Проверяем, содержит ли массив уже это значение
        if (contains(value)) {
            return false;
        }

        // Находим позицию для вставки нового элемента с помощью бинарного поиска
        int low = 0;
        int high = nElems - 1;
        int insertIndex = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        insertIndex = low; // Позиция для вставки - начало оставшегося диапазона

        // Сдвигаем элементы вправо для освобождения места под новый элемент
        for (int j = nElems; j > insertIndex; j--) {
            array[j] = array[j - 1];
        }
        array[insertIndex] = value; // Вставляем новый элемент
        nElems++; // Увеличиваем количество элементов

        return true;
    }

    // Переопределение метода delete для удаления элемента из упорядоченного массива
    @Override
    public boolean delete(long value) {
        // Находим индекс элемента для удаления с помощью бинарного поиска
        int low = 0;
        int high = nElems - 1;
        int deleteIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) { // Если элемент найден
                deleteIndex = mid;
                break;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (deleteIndex == -1) { // Если элемент не найден
            return false;
        }

        // Сдвигаем элементы влево, чтобы удалить элемент
        for (int i = deleteIndex; i < nElems - 1; i++) {
            array[i] = array[i + 1];
        }
        nElems--; // Уменьшаем количество элементов

        return true;
    }

    // Переопределение метода getMax для получения максимального элемента
    @Override
    public long getMax() {
        return array[nElems - 1]; // Максимальный элемент — последний элемент в отсортированном массиве
    }

    // Переопределение метода getMin для получения минимального элемента
    @Override
    public long getMin() {
        return array[0]; // Минимальный элемент — первый элемент в отсортированном массиве
    }
}