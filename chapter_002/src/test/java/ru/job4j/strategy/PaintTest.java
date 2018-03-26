package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }

    @Test
    public void drawingSquare() {
        new Paint().draw(new Square());
        String expected = new StringBuilder()
                .append("****\n")
                .append("*  *\n")
                .append("*  *\n")
                .append("****\n")
                .toString();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void drawingTriangle() {
        new Paint().draw(new Triangle());
        String expected = new StringBuilder()
                .append("  *  \n")
                .append(" * * \n")
                .append("*****\n")
                .toString();
        assertThat(out.toString(), is(expected));
    }
}
