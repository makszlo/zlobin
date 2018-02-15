package ru.job4j.array;
/**
 * Class for bubble rotate array task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class RotateArray {
    /**
     * Поворачивает массив int на 90 градусов по часовой.
     * @param array - неповёрнутый квадратный массив
     * @return - повёрнутый массив
     */
    public int[][] rotate(int[][] array) {
        int index = array.length - 1;
        for (int i = 0; i < index; i++) {
            int tmp = array[0][i];
            array[0][i] = array[index - i][0];
            array[index - i][0] = array[index][index - i];
            array[index][index - i] = array[i][index];
            array[i][index] = tmp;
        }
        return array;
    }
}
