package LaboratoryWorkNo4;

public class ChainHashTable {
    private LinkedList[] hashArray;
    private int arraySize;
    private int itemCount;
    private static final double LOAD_FACTOR = 0.75;

    public ChainHashTable(int size) {
        arraySize = size;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }
        itemCount = 0;
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    public void insert(Link theLink) {
        if ((double)itemCount / arraySize >= LOAD_FACTOR) {
            resize();
        }

        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
        itemCount++;
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        int beforeSize = hashArray[hashVal].size();
        hashArray[hashVal].delete(key);
        int afterSize = hashArray[hashVal].size();

        if (afterSize < beforeSize) {
            itemCount--;
        }
    }

    private void resize() {
        System.out.println("Изменение размера хэш-таблицы с " + arraySize + " до " + (arraySize * 2));

        LinkedList[] oldArray = hashArray;
        int oldSize = arraySize;

        arraySize *= 2;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }
        itemCount = 0;

        for (int j = 0; j < oldSize; j++) {
            Link current = oldArray[j].getFirst();
            while (current != null) {
                insert(new Link(current.getKey()));
                current = current.getNext();
            }
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getArraySize() {
        return arraySize;
    }
}