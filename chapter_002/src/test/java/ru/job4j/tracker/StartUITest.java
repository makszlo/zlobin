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

    @Test
    public void addTest() {
    Tracker tracker = new Tracker();
    StabInput input = new StabInput(new String[]{"0", "test name", "description", "6"});
    new StartUI(input, tracker).init();
    assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
        public void editTest() {
        Tracker tracker = new Tracker();
        Item test = new Item();
        tracker.add(test);
        StabInput input = new StabInput(new String[]{"2", test.getId(), "test name", "description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
        public void deleteTest() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test name_1", "description");
        Item test2 = new Item("test name_2", "description");
        tracker.add(test1);
        StabInput input = new StabInput(new String[]{"3", test1.getId(), "6"});
        new StartUI(input, tracker).init();
        tracker.add(test2);
        assertThat(tracker.getAll()[0], is(test2));
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
        StabInput input = new StabInput(new String[]{"4", test1.getId(), "6"});
        new StartUI(input, tracker).init();
        String menu = "0. Add new item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by id\n"
                + "5. Find items by name\n"
                + "6. Exit program\r\n";
        String expected = menu + test1.getName() + " " + test1.getDescription() + "\r\n\r\n" + menu;
        assertThat(expected, is(out.toString()));
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
        StabInput input = new StabInput(new String[]{"5", "test name_0", "6"});
        new StartUI(input, tracker).init();
        String menu = "0. Add new item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by id\n"
                + "5. Find items by name\n"
                + "6. Exit program\r\n";
        String answer = "\nList of items:\r\n" + "1. " + items[0].getName() + " " + items[0].getId() + "\r\n2. " + items[2].getName() + " " + items[2].getId() + "\r\n\r\n";
        String expected = menu + answer + menu;
        assertThat(expected, is(this.out.toString()));
    }
}
