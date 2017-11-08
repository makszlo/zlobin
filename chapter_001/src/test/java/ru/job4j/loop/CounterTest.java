package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for counter task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class CounterTest {
    /**
     * Сумма чётных чисел от 0 до 10
     */
    @Test
    public void sumFromZeroToTen() {
        Counter count = new Counter();
        int result = count.add(0, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}