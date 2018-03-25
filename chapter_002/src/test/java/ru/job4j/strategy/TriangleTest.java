package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void drawTriangle() {
        Triangle triangle = new Triangle();
        String expected = new StringBuilder()
                .append("  *  ")
                .append(" * * ")
                .append("*****")
                .toString();
        assertThat(triangle.draw(), is(expected));
    }
}
