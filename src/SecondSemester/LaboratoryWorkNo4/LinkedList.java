package LaboratoryWorkNo4;

public class LinkedList {
    private Link first;

    public Link getFirst() {
        return first;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;

        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.setNext(theLink);
        }
        theLink.setNext(current);
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = first.getNext();
        } else if (current != null) {
            previous.setNext(current.getNext());
        }
    }

    public Link find(int key) {
        Link current = first;

        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayList() {
        System.out.print("Список (первый->последний): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Link current = first;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}