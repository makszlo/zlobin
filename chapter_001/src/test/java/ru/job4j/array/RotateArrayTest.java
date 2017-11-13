package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for rotate array task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class RotateArrayTest {
    /**
     * Тест для массива 3 на 3
     */
    @Test
    public void threeByThreeArray() {
        RotateArray rtar = new RotateArray();
        int[][] result = rtar.rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        int[][] expected = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }
    /**
     * Тест для массива 2 на 2
     */
    @Test
    public void twoByTwoArray() {
        RotateArray rtar = new RotateArray();
        int[][] result = rtar.rotate(new int[][] {{1, 2}, {3, 4}});
        int[][] expected = new int[][] {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }
}
