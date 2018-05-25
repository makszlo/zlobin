package ru.job4j.change;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тестовый класс для расчёта сдачи
 * @author Zlobin Maxim
 * @since 25.05.2018
 * @version 1.0
 */
public class ChangeTest {
    @Test
    public void changeTest() {
        int[] answer = {10, 10, 10, 10, 10, 5, 2, 1};
        int value = 0;
        int price = 35;
        for (int one: answer) {
            value += one;
        }
        Change change = new Change();
        change.change(value + price, price);
        assertThat(change.change(value + price, price),
                is(answer));
    }
}
