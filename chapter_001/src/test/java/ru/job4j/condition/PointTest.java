package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test class for point task
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.10.2017
 * @version 0.1
 */
public class PointTest {
    /**
     * Тесты для проверки метода проверки принадлежности точки прямой
     */
    @Test
    public void pointBelongToLine() {
        Point a = new Point(21, 14);
        assertThat(true, is(a.is(2, -28)));
    }
    @Test
    public void pointDontBelongToLine() {
        Point a = new Point(-23, 24);
        assertThat(false, is(a.is(34, 23)));
    }
}
