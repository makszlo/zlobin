package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int ceils = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][ceils];
        int row = 0;
        int ceil = 0;
        for (int current : list) {
            array[row][ceil] = current;
            ceil++;
            if (ceil >= ceils) {
                ceil = 0;
                row++;
            }
        }
        for (; ceil < ceils; ceil++) {
            array[row][ceil] = 0;
        }
        return array;
    }
}
