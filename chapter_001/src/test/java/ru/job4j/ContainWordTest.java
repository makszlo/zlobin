package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ContainWordTest {
    /**
     * Тесты для проверки метода поиска слова в строке текста.
     */
    @Test
    public void helloTest() {
        ContainWord cw = new ContainWord();
        String origin = "Привет";
        String sub = "иве";
        boolean result = cw.contains(origin, sub);
        boolean expected = true;
        assertThat(result, is(expected));
    }
    @Test
    public void helloTestTwo() {
        ContainWord cw = new ContainWord();
        String origin = "Привтиве";
        String sub = "иве";
        boolean result = cw.contains(origin, sub);
        boolean expected = true;
        assertThat(result, is(expected));
    }
    @Test
    public void helloTestThree() {
        ContainWord cw = new ContainWord();
        String origin = "Hello";
        String sub = "иве";
        boolean result = cw.contains(origin, sub);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}

