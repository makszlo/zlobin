package ru.job4j.tracker;

import java.util.Optional;

public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    public  void init() {
        String exit = "0";
        int pos;
        while ("0".equals(exit)) {
            System.out.println("0. Add new item\n"
                    + "1. Show all items\n"
                    + "2. Edit item\n"
                    + "3. Delete item\n"
                    + "4. Find item by id\n"
                    + "5. Find items by name\n"
                    + "6. Exit program");
            String answer = input.ask("Select:");
            switch (answer) {
                case "0":
                    this.tracker.add(new Item(input.ask("Enter item name:"), input.ask("Enter description of new item:")));
                    break;
                case "1":
                    System.out.println("\nList of items:\n");
                    pos = 0;
                    for (Item item : this.tracker.getAll()) {
                        System.out.println(++pos + ". " + item.getName() + " " + item.getId());
                    }
                    System.out.println();
                    break;
                case "2":
                    this.tracker.replace(input.ask("Enter item id:"), new Item(input.ask("Enter new item's name:"), input.ask("Enter description of new item:")));
                    break;
                case "3":
                    this.tracker.delete(input.ask("Enter item id:"));
                    break;
                case "4":
                    Optional<Item> item = this.tracker.findById(input.ask("Enter id:"));
                    if (item.isPresent()) {
                        System.out.println(item.get().getName() + " " + item.get().getDescription());
                    } else {
                        System.out.println("There is no such item!");
                    }
                    System.out.println();
                    break;
                case "5":
                    Optional<Item[]> items = this.tracker.findByName(input.ask("Enter keyword"));
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
                default:
                    System.out.println("There are no such menu item!");
                    break;
            }
        }
    }
}