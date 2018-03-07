package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public void replace(String id, Item item) {
        item.setId(id);
        for (int pos = 0; pos < this.position; pos++) {
            if (items[pos].getId().equals(id)) {
                items[pos] = item;
            }
        }
    }

    public void delete(String id) {
        for (int pos = 0; pos < this.position; pos++) {
            if (items[pos].getId().equals(id)) {
                System.arraycopy(this.items, pos + 1, this.items, pos, this.items.length  - pos - 1);
                break;
            }
        }
        position--;
    }

    public Item[] getAll() {
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key) {
        Item[] found = new Item[position];
        int pos = 0;
        for (Item item : this.getAll()) {
            if (item.getName().equals(key)) {
                found[pos++] = item;
            }
        }
        return Arrays.copyOf(found, pos);
    }

    public Item findById(String id) {
        for (int pos = 0; pos < this.position; pos++) {
            if (items[pos].getId().equals(id)) {
                return items[pos];
            }
        }
        return null;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
