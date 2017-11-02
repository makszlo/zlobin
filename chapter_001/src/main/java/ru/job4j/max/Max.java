package ru.job4j.max;
/**
 * Class for finding max of two
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.11.2017
 * @version 0.1
 */
public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }
}
