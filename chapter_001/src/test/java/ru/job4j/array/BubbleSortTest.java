package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for bubble sort task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class BubbleSortTest {
    /**
     * Тест для сортировки методом пузырька
     */
    @Test
    public void oddArray() {
        BubbleSort bbblSort = new BubbleSort();
        int[] result = bbblSort.sort(new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        int[] expected = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }

}
