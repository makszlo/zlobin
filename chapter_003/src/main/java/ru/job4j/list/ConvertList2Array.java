package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int ceils = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][ceils];
        int counter = 0;
        for (int[] row : array) {
            for(int i = 0; i < ceils; i++) {
                if (counter < list.size()) {
                    row[i] = list.get(counter++);
                }
            }
        }
        return array;
    }
}
