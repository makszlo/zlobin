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
     * Positive numbers test
     */
    @Test
    public void positive() {
        Max testMax = new Max();
        int result = testMax.max(3, 9);
        assertThat(result, is(9));
    }

    /**
     * Negative numbers test
     */
    @Test
    public void negative() {
        Max testMax = new Max();
        int result = testMax.max(-4, -23);
        assertThat(result, is(-4));
    }

    /**
     * Positive and negative numbers test
     */
    @Test
    public void positiveAndNegative() {
        Max testMax = new Max();
        int result = testMax.max(-4, 32);
        assertThat(result, is(32));
    }
    /**
     * Three numbers test
     */
    public void threeNum() {
        Max testMax = new Max();
        int result = testMax.max(-43, 0, 112);
        assertThat(result, is(112));
    }

}
