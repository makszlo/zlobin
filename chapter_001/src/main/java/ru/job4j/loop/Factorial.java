package ru.job4j.loop;
/**
 * Class for factorial task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class Factorial {
    /**
     * Расчёт факториала
     * @param n - до заданного числа
     * @return - факториал
     */
    public int calc(int n) {
        int fact = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
        }
        return fact;
    }
}
