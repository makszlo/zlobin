package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for turn task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class TurnTest {
    /**
     * Прочерка для массива с нечетным количеством элементов
     */
    @Test
    public void oddArray() {
        Turn trn = new Turn();
        int[] arr = new int[] {0, 1, 2, 3, 4};
        int[] result = trn.back(arr);
        int[] expected = new int[] {4, 3, 2, 1, 0};
        assertThat(result, is(expected));
    }
    /**
     * Прочерка для массива с четным количеством элементов
     */
    @Test
    public void evenArray() {
        Turn trn = new Turn();
        int[] result = trn.back(new int[] {0, 1, 2, 3});
        int[] expected = new int[] {3, 2, 1, 0};
        assertThat(result, is(expected));
    }

}
