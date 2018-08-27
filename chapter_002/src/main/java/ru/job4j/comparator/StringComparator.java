package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Класс для сравнение двух строк
 * @author Zlobin Maxim
 */
public class StringComparator implements Comparator<String> {
    /**
     * Класс для сравнения двух строк
     * @param left - первая строка
     * @param right - вторая строка
     * @return - разница между ними
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = left.length() < right.length() ? left.length() : right.length();
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        return result == 0 ? left.length() - right.length() : result;
    }
}
