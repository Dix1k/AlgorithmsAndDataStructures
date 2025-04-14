package LaboratoryWorkNo5;

public class Main {
    public static void main(String[] args) {
        OpenAddressingHashTable hashTable = new OpenAddressingHashTable(5);

        System.out.println("Начальный размер таблицы: " + hashTable.getArraySize());

        // Вставка элементов
        for (int i = 0; i < 20; i++) {
            hashTable.insert(new Link(i));
            System.out.println("Вставлен " + i +
                    ", размер таблицы: " + hashTable.getArraySize() +
                    ", предметов: " + hashTable.getItemCount());
        }

        // Поиск элемента
        Link found = hashTable.find(10);
        if (found != null) {
            System.out.println("Нашёл: " + found.getKey());
        }

        // Удаление элемента
        hashTable.delete(10);
        System.out.println("Предметов после удаления: " + hashTable.getItemCount());

        // Вывод итоговой таблицы
        System.out.println("\nИтоговая хэш-таблица:");
        hashTable.displayTable();
    }
}