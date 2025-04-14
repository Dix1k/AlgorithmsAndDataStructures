package LaboratoryWorkNo5;

public class OpenAddressingHashTable {
    private Link[] hashArray;
    private int arraySize;
    private int itemCount;
    private static final double LOAD_FACTOR = 0.75;
    private static final Link DELETED = new Link(-1); // Маркер для удаленных элементов

    public OpenAddressingHashTable(int size) {
        arraySize = getNextPrime(size);
        hashArray = new Link[arraySize];
        itemCount = 0;
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    // Квадратичное пробирование
    private int hashFunc(int key, int i) {
        return (hashFunc(key) + i * i) % arraySize;
    }

    public Link find(int key) {
        int i = 0;
        int hashVal = hashFunc(key, i);

        while (hashArray[hashVal] != null && i < arraySize) {
            if (hashArray[hashVal] != DELETED && hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            i++;
            hashVal = hashFunc(key, i);
        }
        return null;
    }

    public void insert(Link theLink) {
        if ((double)itemCount / arraySize >= LOAD_FACTOR) {
            resize();
        }

        int key = theLink.getKey();
        int i = 0;
        int hashVal = hashFunc(key, i);

        while (hashArray[hashVal] != null && hashArray[hashVal] != DELETED) {
            if (hashArray[hashVal].getKey() == key) {
                hashArray[hashVal] = theLink;
                return;
            }
            i++;
            hashVal = hashFunc(key, i);
        }

        hashArray[hashVal] = theLink;
        itemCount++;
    }

    public void delete(int key) {
        int i = 0;
        int hashVal = hashFunc(key, i);

        while (hashArray[hashVal] != null && i < arraySize) {
            if (hashArray[hashVal] != DELETED && hashArray[hashVal].getKey() == key) {
                hashArray[hashVal] = DELETED;
                itemCount--;
                return;
            }
            i++;
            hashVal = hashFunc(key, i);
        }
    }

    private void resize() {
        System.out.println("Изменение размера хэш-таблицы с " + arraySize + " до " + (arraySize * 2));

        Link[] oldArray = hashArray;
        int oldSize = arraySize;

        arraySize = getNextPrime(arraySize * 2);
        hashArray = new Link[arraySize];
        itemCount = 0;

        for (int j = 0; j < oldSize; j++) {
            if (oldArray[j] != null && oldArray[j] != DELETED) {
                insert(new Link(oldArray[j].getKey()));
            }
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            if (hashArray[j] == null) {
                System.out.println("Пустой");
            } else if (hashArray[j] == DELETED) {
                System.out.println("Удаленный");
            } else {
                hashArray[j].displayLink();
                System.out.println();
            }
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getArraySize() {
        return arraySize;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private int getNextPrime(int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }
}