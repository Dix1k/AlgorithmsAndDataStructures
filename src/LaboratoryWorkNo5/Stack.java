package LaboratoryWorkNo5;

import java.util.EmptyStackException;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int value) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is full. Cannot push " + value);
        }
        stackArray[++top] = value;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
