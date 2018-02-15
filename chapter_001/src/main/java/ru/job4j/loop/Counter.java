package ru.job4j.loop;

/**
 * Class for counter task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class Counter {
    /**
     * Метод считает сумму четных числе на отрезке
     * @param start - начало отрезка
     * @param finish - конец отрезка
     * @return - сумма четных чисел
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum  += i;
            }
        }
        return sum;
    }
}
