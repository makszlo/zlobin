package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for board task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class BoardTest {
    /**
     * Тест заполнения Х-ами для доски 3х3
     */
    @Test
    public void boardThreeXThree() {
        Board brd = new Board();
        String result = brd.paint(3, 3);
        String newLine = System.getProperty("line.separator");
        String expected = String.format("X X%s X %sX X%s", newLine, newLine, newLine);
        assertThat(result, is(expected));
    }
    /**
     * Тест заполнения Х-ами для доски 5х4
     */
    @Test
    public void boardFiveXFour() {
        Board brd = new Board();
        String result = brd.paint(5, 4);
        String newLine = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s", newLine, newLine, newLine, newLine);
        assertThat(result, is(expected));
    }
}
