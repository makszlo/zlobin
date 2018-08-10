package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Optional;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private static final Random RN = new Random();

    public void add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
        for (int pos = 0; pos < this.items.size(); pos++) {
            if (items.get(pos).getId().equals(id)) {
                items.set(pos, item);
                break;
            }
        }
    }

    public void delete(String id) {
        for (int pos = 0; pos < this.items.size(); pos++) {
            if (items.get(pos).getId().equals(id)) {
               items.remove(pos);
            }
        }
    }

    public List<Item> getAll() {
        return this.items;
    }

    public Optional<List<Item>> findByName(String key) {
        List<Item> found = new ArrayList<Item>();
        for (Item item : this.getAll()) {
            if (item.getName().equals(key)) {
                found.add(item);
            }
        }
        if (found.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(found);
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
