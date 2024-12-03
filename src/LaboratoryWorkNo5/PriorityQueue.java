package LaboratoryWorkNo5;

public class PriorityQueue {
    private int maxSize;
    private int[] queueArray;
    private int nItems;

    public PriorityQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.nItems = 0;
    }

    public void insert(int value) throws Exception {
        if (isFull()) {
            throw new Exception("PriorityQueue is full. Cannot insert " + value);
        }
        if (nItems == 0) {
            queueArray[nItems++] = value;
        } else {
            int j;
            for (j = nItems - 1; j >= 0; j--) {
                if (value > queueArray[j]) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = value;
            nItems++;
        }
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("PriorityQueue is empty. Cannot remove.");
        }
        return queueArray[--nItems];
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}
