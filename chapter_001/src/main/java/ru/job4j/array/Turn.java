package ru.job4j.array;
/**
 * Class for turn task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class Turn {
    /**
     * Поворачивает массив int задом наперёд
     * @param array - массив int
     * @return - повёрнутый массив
     */
    public int[] back(int[] array) {
        int tmpLenght = array.length;
        for (int i = 0; i < ((tmpLenght - tmpLenght % 2) / 2); i++) {
            int tmp = array[i];
            array[i] = array[tmpLenght - 1 - i];
            array[tmpLenght - 1 - i] = tmp;
        }
        return array;
    }
}
