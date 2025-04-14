package LaboratoryWorkNo5;

public class Link {
    private final int key;

    public Link(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void displayLink() {
        System.out.print(key + " ");
    }
}