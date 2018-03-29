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
    private String menu = "1. Add new item\r\n"
            + "2. Show all items\r\n"
            + "3. Replace item\r\n"
            + "4. Edit item\r\n"
            + "5. Delete item\r\n"
            + "6. Find item by id\r\n"
            + "7. Find items by name\r\n"
            + "8. Exit program\r\n";
    private String moexc = "Please enter valid data again\r\n";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }

    @Test
    public void MenuOutOfRangeTest() {
        Tracker tracker = new Tracker();
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"-1", "8"}));
        new StartUI(input, tracker).init();
        String expected = menu + "Please select key from menu.\r\n";
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void NumberFormatException() {
        Tracker tracker = new Tracker();
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"s", "8"}));
        new StartUI(input, tracker).init();
        String expected = menu + "Please enter valid data again.\r\n";
        assertThat(out.toString(), is(expected));
    }
}
