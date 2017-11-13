package ru.job4j.array;
/**
 * Class for bubble sort task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class BubbleSort {
    /**
     * Метод для сортировки методом пузырька
     * @param array - неотсортированный массив int
     * @return - отсортированный массив int
     */
    public int[] sort(int[] array) {
        int tmpLenght = array.length;
        for (int i = 0; i < tmpLenght; i++) {
            for (int j = 0; j < tmpLenght - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
