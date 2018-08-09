package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Environment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
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

    @Test
    public void addTest() {
    Tracker tracker = new Tracker();
    ValidateInput input = new ValidateInput(new StabInput(new String[]{"1", "test name", "description", "8"}));
    new StartUI(input, tracker).init();
    assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    @Test
    public void editTest() {
        Tracker tracker = new Tracker();
        Item test = new Item();
        tracker.add(test);
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"4", test.getId(), "test name", "", "8"}));
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    @Test
        public void replaceTest() {
        Tracker tracker = new Tracker();
        Item test = new Item();
        tracker.add(test);
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"3", test.getId(), "test name", "description", "8"}));
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    @Test
        public void deleteTest() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test name_1", "description");
        Item test2 = new Item("test name_2", "description");
        tracker.add(test1);
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"5", test1.getId(), "8"}));
        new StartUI(input, tracker).init();
        tracker.add(test2);
        assertThat(tracker.getAll().get(0), is(test2));
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(new PrintStream(this.stdout));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test name_1", "description");
        tracker.add(test1);
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"6", test1.getId(), "8"}));
        new StartUI(input, tracker).init();
        String expected = this.menu + test1.getName() + " " + test1.getDescription() + "\r\n\r\n" + this.menu;
        assertThat(this.out.toString(), is(expected));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                items[i] = new Item("test name_" + 0, "description");
                tracker.add(items[i]);
            } else {
                items[i] = new Item("test name_" + 1, "description");
                tracker.add(items[i]);
            }
        }
        ValidateInput input = new ValidateInput(new StabInput(new String[]{"7", "test name_0", "8"}));
        new StartUI(input, tracker).init();
        String answer = "\nList of items:\r\n" + "1. " + items[0].getName() + " " + items[0].getId() + "\r\n2. " + items[2].getName() + " " + items[2].getId() + "\r\n\r\n";
        String expected = this.menu + answer + this.menu;
        assertThat(this.out.toString(), is(expected));
    }
}
