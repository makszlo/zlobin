package ru.job4j.change;

/**
 * Class for counting change in coffee machine
 * @author Zlobin Maxim
 * @since 24.05.2018
 * @version 1.0
 */
public class Change {
    private static final int[] RANGE = {10, 5, 2, 1};

    /**
     * Метод для рсчёта сдачи
     * @param value - внесённая сумма
     * @param price - цена выбранной позиции
     * @return - массив всех монет для сдачи
     */
    public int[] change(int value, int price) {
        int[] change = {0, 0, 0, 0};
        int tmp = value - price;
        if (tmp > 0) {
            while (tmp != 0) {
                for (int i = 0; i < RANGE.length; i++) {
                    while (tmp >= RANGE[i]) {
                        change[i]++;
                        tmp -= RANGE[i];
                    }
                }
            }
        }
        return createArray(change);
    }

    /**
     * Метод для создания массива монет
     * @param change - массив с количеством монет разных типов
     * @return - массив
     */
    private int[] createArray(int[] change) {
        int amount = 0;
        for (int peace : change) {
            amount += peace;
        }
        int[] result = new int[amount];
        int i = 0;
            for (int x = 0; x < RANGE.length; x++) {
                for (int y = 0; y < change[x]; y++) {
                    result[i] = RANGE[x];
                    i++;
                }
            }
        return result;
    }
}
