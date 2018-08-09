package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.Optional;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void addTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void replaceTest() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId())
                .get()
                .getName(), is("test2"));
    }

    @Test
    public void editTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        tracker.edit(item.getId(), "test2", "");
        assertThat(tracker.findById(item.getId())
                .get()
                .getName(), is("test2"));
        assertThat(tracker.findById(item.getId())
                .get()
                .getDescription(), is("testDescription"));
    }

    @Test
    public void findByIdNothingFoundTest() {
        Tracker tracker = new Tracker();
        assertThat(tracker.findById("132131454643"), is(Optional.empty()));
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
        Optional<Item[]> result = tracker.findByName("test");
        for (int i = 0; i < result.get().length; i++) {
            assertThat(result.get()[i], is(items[2 * i + 1]));
        }
    }

    @Test
    public void findByNameTestNotFound() {
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
        Optional<Item[]> result = tracker.findByName("testing");
        assertThat(result, is(Optional.empty()));
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
        assertThat(tracker.findById(items[4].getId()), is(Optional.empty()));
    }
}
