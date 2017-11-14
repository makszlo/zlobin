package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for rotate array duplicate task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 13.11.2017
 * @version 0.1
 */
public class ArrayDuplicateTest {
    /**
     * Тест с пятью словами.
     */
    @Test
    public void fiveWords() {
        ArrayDuplicate test = new ArrayDuplicate();
        String[] result = test.remove(new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expected = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }
}
