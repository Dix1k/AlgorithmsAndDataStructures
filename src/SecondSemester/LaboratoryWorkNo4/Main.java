package LaboratoryWorkNo4;

public class Main {
    public static void main(String[] args) {
        ChainHashTable hashTable = new ChainHashTable(5);

        System.out.println("Начальный размер таблицы: " + hashTable.getArraySize());

        for (int i = 0; i < 20; i++) {
            hashTable.insert(new Link(i));
            System.out.println("Вставлен " + i +
                    ", размер таблицы: " + hashTable.getArraySize() +
                    ", предметов: " + hashTable.getItemCount());
        }

        Link found = hashTable.find(10);
        if (found != null) {
            System.out.println("Нашёл: " + found.getKey());
        }

        hashTable.delete(10);
        System.out.println("Предметов после удаления: " + hashTable.getItemCount());

        System.out.println("\nИтоговая хэш-таблица:");
        hashTable.displayTable();
    }
}