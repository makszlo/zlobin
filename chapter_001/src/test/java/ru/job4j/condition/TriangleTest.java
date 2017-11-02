package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * Test class for triangle task
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.10.2017
 * @version 0.1
 */
public class TriangleTest {

    /**
     * Testing of calcualating area
     */
    @Test
    public void setThreepointsAndGetTriangleArea() {
        Point a = new Point(-3, -2);
        Point b = new Point(0, 3);
        Point c = new Point(6, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        assertThat(result, closeTo(19.5, 0.1));
    }

    /**
     * Testing of calculating distance between two points
     */
    @Test
    public void setTwoPointsAndGetDistanceBetween() {
        Point left = new Point(0, 0);
        Point right = new Point(2, 10);
        Triangle triangle = new Triangle(null, null, null);
        double rsl = triangle.distance(left, right);
        assertThat(rsl, closeTo(10.198, 0.01));
    }

    /**
     * Existing tests
     */
    @Test
    public void trianleDontExistTest() {
        Triangle triangle = new Triangle(null, null, null);
        boolean result = triangle.exist(5D, 5D, 10D);
        assertThat(result, is(false));
    }
    @Test
    public void trianleExistTest() {
        Triangle triangle = new Triangle(null, null, null);
        boolean result = triangle.exist(6D, 5D, 10D);
        assertThat(result, is(true));
    }
}
