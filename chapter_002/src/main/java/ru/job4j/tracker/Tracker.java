package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public void add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
    }

    public void edit(String id, String name, String desc) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                if (!"".equals(name)) {
                    item.setName(name);
                }
                if (!"".equals(desc)) {
                    item.setName(desc);
                }
                break;
            }
        }
    }

    public void replace(String id, Item item) {
        item.setId(id);
        for (int pos = 0; pos < this.position; pos++) {
            if (items[pos].getId().equals(id)) {
                items[pos] = item;
                break;
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

    public Optional<Item[]> findByName(String key) {
        Item[] found = new Item[position];
        int pos = 0;
        for (Item item : this.getAll()) {
            if (item.getName().equals(key)) {
                found[pos++] = item;
            }
        }
        if (pos == 0) {
            return Optional.empty();
        } else {
            return Optional.of(Arrays.copyOf(found, pos));
        }
    }

    public Optional<Item> findById(String id) {
        for (Item item : this.getAll()) {
            if (item.getId().equals(id)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
