package lesson3.array_examples.good_practice;

public interface HighInterfaceArray {
    boolean find(long searchValue);
    void insert(long value);
    void delete(long value);
    void display();
    int getSize();

    int findMin(int[] array);
    int findMax(int[] array);
    long[] getArray();
}
