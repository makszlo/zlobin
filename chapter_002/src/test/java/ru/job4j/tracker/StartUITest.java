package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {

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
}
