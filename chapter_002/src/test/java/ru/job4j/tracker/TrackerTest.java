package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        int amount = 6;
        Item[] items = new Item[amount];
        for (int i = 0; i < amount; i = i + 2) {
            items[i] = new Item("test" + i, "testDescription");
        }
        for (int i = 1; i < amount + 1; i = i + 2) {

            items[i] = new Item("test", "testDescription");
        }
        for (int i = 0; i < amount; i++) {
            tracker.add(items[i]);
        }
        Item[] result = tracker.findByName("test");
        for (int i = 0; i < result.length; i++) {
            assertThat(result[i], is(items[2 * i + 1]));
        }
    }

    @Test
    public void deleteTest() {
        Tracker tracker = new Tracker();
        int amount = 6;
        Item[] items = new Item[amount];
        for (int i = 0; i < amount; i++) {
            items[i] = new Item("test" + i, "testDescription");
        }
        for (int i = 0; i < amount; i++) {
            tracker.add(items[i]);
        }
        tracker.delete(items[4].getId());
        assertThat(tracker.findById(items[4].getId()), is((Item) null));
    }
}