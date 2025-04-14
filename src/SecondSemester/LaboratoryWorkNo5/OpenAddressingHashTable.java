package LaboratoryWorkNo5;

public class OpenAddressingHashTable {
    private Item[] hashArray;
    private int arraySize;
    private Item deletedItem; // Маркер удаленного элемента

    public OpenAddressingHashTable(int size) {
        arraySize = size;
        hashArray = new Item[arraySize];
        deletedItem = new Item(-1); // Специальный объект для пометки удаленных элементов
    }

    // Хеш-функция (первое хеширование)
    public int hashFunc(int key) {
        return key % arraySize;
    }

    // Функция для квадратичного пробирования
    public int stepSizeCounter(int key, int i) {
        return i * i;
    }

    // Поиск элемента с заданным ключом
    public Item find(int key) {
        int hashVal = hashFunc(key);
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key && hashArray[hashVal].getKey() != -1) {
                return hashArray[hashVal]; // Элемент найден
            }
            // Квадратичное пробирование
            hashVal = (hashVal + stepSizeCounter(key, i)) % arraySize;
            i++;
            if (i >= arraySize) { // Предотвращение бесконечного цикла
                break;
            }
        }
        return null; // Элемент не найден
    }

    // Вставка элемента данных
    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int i = 1;

        // Поиск пустой ячейки или ячейки с пометкой удаления
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            // Квадратичное пробирование
            hashVal = (hashVal + stepSizeCounter(key, i)) % arraySize;
            i++;
            if (i >= arraySize) { // Таблица заполнена
                throw new RuntimeException("Hash table is full");
            }
        }
        hashArray[hashVal] = item; // Вставка элемента
    }

    // Удаление элемента данных
    public Item delete(int key) {
        int hashVal = hashFunc(key);
        int i = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Item temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = deletedItem; // Удаление элемента (помечаем как удаленный)
                return temp; // Возвращаем удаленный элемент
            }
            // Квадратичное пробирование
            hashVal = (hashVal + stepSizeCounter(key, i)) % arraySize;
            i++;
            if (i >= arraySize) { // Предотвращение бесконечного цикла
                break;
            }
        }
        return null; // Элемент не найден
    }

    // Вывод содержимого таблицы
    public void display() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey() + " ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println("");
    }

    // Класс Item для хранения данных
    public static class Item {
        private int key;

        public Item(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }
}