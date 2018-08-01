package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для конвертация двумерного массива в ArrayList
 * @author Zlobin Maxim
 * @version 1.0
 */
public class ConvertMatrix2List {
    /**
     * Метод для конвертации двумерного массива в ArrayList
     * @param array - массив int для конвертации
     * @return - ArrayList, созданный из массива
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int current : row) {
                list.add(current);
            }
        }
        return list;
    }
}