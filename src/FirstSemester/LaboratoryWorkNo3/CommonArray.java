package LaboratoryWorkNo3;

public class CommonArray extends ParentLongArray {
    // Конструктор, инициализирует массив определенного размера
    public CommonArray(int size) {
        super(size);
    }

    // Метод для поиска значения в неупорядоченном массиве
    @Override
    public boolean contains(long searchValue) {
        // Счетчик операций для измерения производительности поиска
        int operationsNumber = 0;

        // Линейный проход по всем элементам массива
        for (int i = 0; i < nElems; i++) {
            // Увеличивает и выводит количество операций на текущей итерации
            System.out.println("Количество операций в неупорядоченном массиве: " + ++operationsNumber);

            // Проверка, совпадает ли текущий элемент массива с искомым значением
            if (array[i] == searchValue) {
                // Если найдено, возвращает true
                return true;
            }
        }

        // Если значение не найдено после завершения цикла, возвращает false
        return false;
    }
}