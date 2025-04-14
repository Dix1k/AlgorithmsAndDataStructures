package LaboratoryWorkNo5;

public class Main {
    public static void main(String[] args) {
        OpenAddressingHashTable hashTable = new OpenAddressingHashTable(10); // Создаём таблицу размером 10

        // Вставка элементов (меньше, чем размер таблицы, чтобы избежать переполнения)
        for (int i = 0; i < 8; i++) {
            hashTable.insert(new OpenAddressingHashTable.Item(i));
            System.out.println("Вставлен элемент с ключом: " + i);
        }

        // Вывод таблицы
        System.out.println("\nСостояние таблицы после вставки:");
        hashTable.display();

        // Поиск элемента
        int searchKey = 5;
        OpenAddressingHashTable.Item foundItem = hashTable.find(searchKey);
        if (foundItem != null) {
            System.out.println("\nЭлемент с ключом " + searchKey + " найден.");
        } else {
            System.out.println("\nЭлемент с ключом " + searchKey + " не найден.");
        }

        // Удаление элемента
        int deleteKey = 5;
        OpenAddressingHashTable.Item deletedItem = hashTable.delete(deleteKey);
        if (deletedItem != null) {
            System.out.println("\nЭлемент с ключом " + deleteKey + " удалён.");
        } else {
            System.out.println("\nЭлемент с ключом " + deleteKey + " не найден (удаление не выполнено).");
        }

        // Вывод таблицы после удаления
        System.out.println("\nСостояние таблицы после удаления:");
        hashTable.display();

        // Проверка, что элемент удалён
        foundItem = hashTable.find(deleteKey);
        if (foundItem != null) {
            System.out.println("\nЭлемент с ключом " + deleteKey + " всё ещё существует.");
        } else {
            System.out.println("\nЭлемент с ключом " + deleteKey + " больше не в таблице (успешно удалён).");
        }
    }
}