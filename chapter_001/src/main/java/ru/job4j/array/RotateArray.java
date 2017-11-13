package ru.job4j.array;
/**
 * Class for bubble rotate array task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class RotateArray {
    /**
     * Поворачивает массив на 90 градусов по часовой
     * @param array - неповёрнутый квадратный массив
     * @return - повёрнутый массив
     */
    public int[][] rotate(int[][] array) {
        int indexOfLastElement = array.length - 1;
        for (int i = 0; i < indexOfLastElement; i++) {
            int tmp = array[0][i];
            array[0][i] = array[indexOfLastElement - i][0];
            array[indexOfLastElement - i][0] = array[indexOfLastElement][indexOfLastElement - i];
            array[indexOfLastElement][indexOfLastElement - i] = array[i][indexOfLastElement];
            array[i][indexOfLastElement] = tmp;
        }
        return array;
    }
}
