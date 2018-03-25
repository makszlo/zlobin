package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void drawTriangle() {
        Square square = new Square();
        String expected = new StringBuilder()
                .append("****")
                .append("*  *")
                .append("*  *")
                .append("****")
                .toString();
        assertThat(square.draw(), is(expected));
    }
}
