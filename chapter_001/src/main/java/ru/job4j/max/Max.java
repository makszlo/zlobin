package ru.job4j.max;
/**
 * Class for finding max of two
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.11.2017
 * @version 0.1
 */
public class Max {
    /**
     * Метод для нахождения максимума из двух чисел.
     * @param first - первое число
     * @param second - второе число
     * @return - максимальное из двух чисел
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Метод для нахождения максимума из трёх чисел.
     * @param first - первое число
     * @param second - второе число
     * @param third - третье число
     * @return - максимальное из трёх чисел
     */
    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }
}
