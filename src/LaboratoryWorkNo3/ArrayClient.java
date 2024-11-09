package LaboratoryWorkNo3;

import java.util.Random;

public class ArrayClient {
    public static void main(String[] args) {
        // Разделитель для вывода
        String separator = "__________________________________________________________";

        // Создание объекта для генерации случайных чисел
        Random random = new Random();

        // Размер массивов
        int size = 100;

        // Создание обычного и упорядоченного массивов
        CommonArray commonArray = new CommonArray(size);
        OrderedArray orderedArray = new OrderedArray(size);

        // Заполнение массивов случайными значениями
        for (int i = 0; i < size; i++) {
            boolean insertResultCommonArray = false;
            boolean insertResultOrderedArray = false;

            // Вставка случайного значения в обычный массив до успешной вставки
            while (!insertResultCommonArray) {
                insertResultCommonArray = commonArray.insert(random.nextLong(1000));
            }

            // Вставка случайного значения в упорядоченный массив до успешной вставки
            while (!insertResultOrderedArray) {
                insertResultOrderedArray = orderedArray.insert(random.nextLong(1000));
            }
        }

        // Генерация случайного значения для поиска
        long searchValue = random.nextLong(1000);

        // Поиск значения в обычном массиве и вывод результата
        if (commonArray.contains(searchValue)) {
            System.out.println("Значение было найдено. " + searchValue);
        } else {
            System.out.println("Не удалось найти значение. " + searchValue);
        }

        // Разделитель
        System.out.println(separator);

        // Поиск значения в упорядоченном массиве и вывод результата
        if (orderedArray.contains(searchValue)) {
            System.out.println("Значение было найдено. " + searchValue);
        } else {
            System.out.println("Не удалось найти значение. " + searchValue);
        }
    }
}