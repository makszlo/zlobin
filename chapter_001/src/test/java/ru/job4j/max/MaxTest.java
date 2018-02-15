package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 02.11.2017
 * @version 0.1
 */
public class MaxTest {
    /**
     * Тест на сравнение двух положительных цифр
     */
    @Test
    public void positive() {
        Max testMax = new Max();
        int result = testMax.max(3, 9);
        assertThat(result, is(9));
    }

    /**
     * Тест на сравнение двух отрицательных цифр
     */
    @Test
    public void negative() {
        Max testMax = new Max();
        int result = testMax.max(-4, -23);
        assertThat(result, is(-4));
    }

    /**
     * Тест на сравнение положительного и отрицательного цисла
     */
    @Test
    public void positiveAndNegative() {
        Max testMax = new Max();
        int result = testMax.max(-4, 32);
        assertThat(result, is(32));
    }
    /**
     * Тест на поиск максимального среди трёх числе
     */
    public void threeNum() {
        Max testMax = new Max();
        int result = testMax.max(-43, 0, 112);
        assertThat(result, is(112));
    }

}
