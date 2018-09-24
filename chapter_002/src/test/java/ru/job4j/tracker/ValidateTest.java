package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String menu = "1. Add new item" + System.lineSeparator()
            + "2. Show all items" + System.lineSeparator()
            + "3. Replace item" + System.lineSeparator()
            + "4. Edit item" + System.lineSeparator()
            + "5. Delete item" + System.lineSeparator()
            + "6. Find item by id" + System.lineSeparator()
            + "7. Find items by name" + System.lineSeparator()
            + "8. Exit program" + System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }

    @Test
    public void menuOutOfRangeTest() {
        Tracker tracker = new Tracker();
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"-1", "8"}));
        new StartUI(input, tracker).init();
        String expected = menu + "Please select key from menu." + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void numberFormatException() {
        Tracker tracker = new Tracker();
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"s", "8"}));
        new StartUI(input, tracker).init();
        String expected = menu + "Please enter valid data again." + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }
}
