package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for factorial task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class FactorialTest {
    /**
     * Факториал нуля
     */
    @Test
    public void factorialOfZero() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Факториал пяти
     */
    @Test
    public void factorialOfFive() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }

}
