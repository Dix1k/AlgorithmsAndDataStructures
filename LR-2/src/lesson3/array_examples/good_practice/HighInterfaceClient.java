package lesson3.array_examples.good_practice;

import java.util.Random;

public class HighInterfaceClient {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 100;
        HighInterfaceArray array = new HighInterfaceArrayImpl(size);

        // Заполнение массива
        for (int i = 0; i < size; i++) {
            array.insert(random.nextLong(50));
        }

        // Отображаем элементы массива
        array.display();

        // Ищем элемент
        long searchValue = random.nextLong(50);
        if (array.find(searchValue)) {
            System.out.println("Значение было найдено. " + searchValue);
        } else {
            System.out.println("Не удалось найти значение. " + searchValue);
        }

        // Удаляем элемент
        array.delete(30);
        array.display();

        // Получаем массив из highArray и преобразуем его в int[]
        long[] longArray = array.getArray();
        int[] arrayForMinMax = new int[longArray.length];
        for (int i = 0; i < longArray.length; i++) {
            arrayForMinMax[i] = (int) longArray[i];  // Преобразуем long в int
        }

        // Находим и выводим минимальный и максимальный элементы
        System.out.println("Минимальный элемент: " + array.findMin(arrayForMinMax));
        System.out.println("Максимальный элемент: " + array.findMax(arrayForMinMax));
    }
}
