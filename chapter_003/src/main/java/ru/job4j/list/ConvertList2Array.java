package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для конвертации ArrayList в двухмерный массив
 * @author Zlobin Maxim
 */
public class ConvertList2Array {
    /**
     * Метод конвертирующий ArrayList в двухмерный массив
     * @param list - конвертируемый ArrayList
     * @param rows - количество строк в двумерном массиве
     * @return - двухмерный массив из ArrayList
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int ceils = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][ceils];
        int counter = 0;
        for (int[] row : array) {
            for (int i = 0; i < ceils; i++) {
                if (counter < list.size()) {
                    row[i] = list.get(counter++);
                } else {
                    row[i] = 0;
                }
            }
        }
        return array;
    }

    /**
     * Метод конвертирующии несколько масссивов в ArrayList
     * @param list - массивы для обработки
     * @return - ArrayList из массивов
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int[] array : list) {
            for (int current : array) {
                result.add(current);
            }
        }
        return result;
    }
}
