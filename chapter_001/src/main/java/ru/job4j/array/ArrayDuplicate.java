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
        int uniqueCounter = array.length;
        int i = 1;
        String tmp;
        while (i != uniqueCounter) {
            for (int j = 0; j < i; j++) {
                if (array[i].equals(array[j])) {
                    uniqueCounter--;
                    tmp = array[uniqueCounter];
                    array[uniqueCounter] = array[i];
                    array[i] = tmp;
                    break;
                } else if (j == i - 1) {
                    i++;
                    break;
                }
            }
        }
        return Arrays.copyOf(array, uniqueCounter);
    }
}