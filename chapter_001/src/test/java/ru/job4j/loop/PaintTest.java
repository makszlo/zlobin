package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for pyramid painting task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class PaintTest {
    /**
     * Тест для пирамиды высотой 2 строки
     */
    @Test
    public void heightTwo() {
        Paint pnt = new Paint();
        String newLine = System.getProperty("line.separator");
        String result = pnt.piramid(2);
        String expected = String.format(" ^ %s^^^", newLine);
        assertThat(result, is(expected));
    }
    /**
     * Тест для пирамиды высотой 3 строки
     */
    @Test
    public void heightThree() {
        Paint pnt = new Paint();
        String newLine = System.getProperty("line.separator");
        String result = pnt.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", newLine, newLine);
        assertThat(result, is(expected));
    }

}
