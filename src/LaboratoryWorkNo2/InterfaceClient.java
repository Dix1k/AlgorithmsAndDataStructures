package LaboratoryWorkNo2;

import java.util.Random;

public class InterfaceClient {
    public static void main(String[] args) {
        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        // Генерируем случайный размер массива в пределах от 0 до 49
        int s = random.nextInt(50);
        // Создаем экземпляр InterfaceArrayImpl с заданным размером
        InterfaceArray array = new InterfaceArrayImpl(s);

        // Заполняем массив s случайными значениями типа long
        for (int i = 0; i < s; i++) {
            array.add(random.nextLong(50)); // Генерируем случайные числа до 50
        }

        // Выводим содержимое массива на экран
        array.show();

        // Генерируем случайное значение для поиска в массиве
        long Search = random.nextLong(s);
        // Проверяем, найдено ли значение в массиве
        if (array.find(Search)) {
            System.out.println("Значение " + Search + " было найдено.");
        } else {
            System.out.println("Не удалось найти значение. " + Search);
        }

        // Выводим количество элементов в массиве
        System.out.println("Количество элементов в массиве:");
        array.getSize();

        // Находим и выводим максимальный элемент массива
        System.out.println("Максимальный элемент массива:");
        System.out.println(array.findMax());

        // Находим и выводим минимальный элемент массива
        System.out.println("Минимальный элемент массива:");
        System.out.println(array.findMin());
    }
}

