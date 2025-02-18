package LaboratoryWorkNo5;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[size];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(int value) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is full. Cannot insert " + value);
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = value;
        nItems++;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty. Cannot remove.");
        }
        int temp = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public int peekFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return queueArray[front];
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}
