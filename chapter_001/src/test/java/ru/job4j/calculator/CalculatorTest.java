package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void addTest() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void subtractTest() {
        Calculator calc = new Calculator();
        calc.subtract(13D, 2D);
        double result = calc.getResult();
        double expected = 11D;
        assertThat(result, is(expected));
    }
    @Test
    public void divTest() {
        Calculator calc = new Calculator();
        calc.div(16D, 4D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
    @Test
    public void multipleTest() {
        Calculator calc = new Calculator();
        calc.multiple(16D, 16D);
        double result = calc.getResult();
        double expected = 256D;
        assertThat(result, is(expected));
    }
}
