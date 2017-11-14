package ru.job4j.array;

import java.util.Arrays;
/**
 * Class for bubble array duplicate task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 14.11.2017
 * @version 0.1
 */
public class ArrayDuplicate {
    /**
     * Метод удаляет дубликаты из массива String.
     * @param array - массив String с дубликатами.
     * @return - массив String без дубликатов.
     */
    public String[] remove(String[] array) {
        int i = 0;
        String tmp;
        while (i != array.length - 1) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    array[j] = array[array.length - 1];
                    array = Arrays.copyOf(array, array.length - 1);
                    break;
                }
                if (j == array.length - 1) {
                    i++;
                }
            }
        }
        return  array;
    }
}
