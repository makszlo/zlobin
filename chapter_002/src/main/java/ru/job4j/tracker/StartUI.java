package ru.job4j.tracker;

import java.util.Optional;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public  void init() {
        Tracker tracker = new Tracker();
        ConsoleInput input = new ConsoleInput();
        String exit = "0";
        int pos;
        for (int i = 0; i < 3; i++) {
            Item item = new Item("test1", "testDescription");
            tracker.add(item);
        }
        while ("0".equals(exit)) {
            System.out.println("0. Add new item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by id\n5. Find items by name\n6. Exit program");
            String answer = input.ask("Select:");
            switch (answer) {
                case "0":
                    tracker.add(new Item(input.ask("Enter item name:"), input.ask("Enter description of new item:")));
                    break;
                case "1":
                    System.out.println("\nList of items:\n");
                    pos = 0;
                    for (Item item : tracker.getAll()) {
                        System.out.println(++pos + ". " + item.getName() + " " + item.getId());
                    }
                    System.out.println();
                    break;
                case "2":
                    tracker.replace(input.ask("Enter item id:"), new Item(input.ask("Enter new item's name:"), input.ask("Enter description of new item:")));
                    break;
                case "3":
                    tracker.delete(input.ask("Enter item id:"));
                    break;
                case "4":
                    Optional<Item> item = tracker.findById(input.ask("Enter id:"));
                    if (item.isPresent()) {
                        System.out.println(item.get().getName() + " " + item.get().getDescription());
                    } else {
                        System.out.println("There is no such item!");
                    }
                    System.out.println();
                    break;
                case "5":
                    Optional<Item[]> items = tracker.findByName(input.ask("Enter keyword"));
                    if (items.isPresent()) {
                        pos = 0;
                        System.out.println("\nList of items:");
                        for (Item it : items.get()) {
                            System.out.println(++pos + ". " + it.getName() + " " + it.getId());
                        }
                    } else {
                        System.out.println("There are no such items!");
                    }
                    System.out.println();
                    break;
                case "6":
                    exit = "1";
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}