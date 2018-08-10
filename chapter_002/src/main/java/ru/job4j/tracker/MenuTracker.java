package ru.job4j.tracker;

import java.util.Optional;
import java.util.List;

class FindItemById extends BaseAction {

    public FindItemById(String info, int key) {
        super(info, key);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Optional<Item> item = tracker.findById(input.ask("Enter id:"));
        if (item.isPresent()) {
            System.out.println(item.get().getName() + " " + item.get().getDescription());
        } else {
            System.out.println("There is no such item!");
        }
        System.out.println();
    }
}

class FindItemByName extends BaseAction {

    public FindItemByName(String info, int key) {
        super(info, key);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Optional<List<Item>> items = tracker.findByName(input.ask("Enter keyword"));
        if (items.isPresent()) {
            int pos = 0;
            System.out.println("\nList of items:");
            for (Item it : items.get()) {
                System.out.println(++pos + ". " + it.getName() + " " + it.getId());
            }
        } else {
            System.out.println("There are no such items!");
        }
        System.out.println();
    }
}



public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];


    public MenuTracker(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem("Add new item", 1);
        this.actions[1] = new MenuTracker.ShowItems("Show all items", 2);
        this.actions[2] = this.new ReplaceItem("Replace item", 3);
        this.actions[3] = this.new EditItem("Edit item", 4);
        this.actions[4] = this.new DeleteItem("Delete item", 5);
        this.actions[5] = new FindItemById("Find item by id", 6);
        this.actions[6] = new FindItemByName("Find items by name", 7);
    }

    public void select(int key) {
        if (key < actions.length && key >= 0) {
            this.actions[key].execute(this.input, this.tracker);
        } else {
            System.out.println("There are no such menu's item!");
        }
    }
    public void showActions() {
        int pos = 1;
        for (UserAction action: this.actions) {
            pos++;
            System.out.println(action.info());
        }
        System.out.println(pos + ". Exit program");
    }

    public int[] getRange() {
        int[] range = new int[this.actions.length + 1];
        for (int i = 0; i < this.actions.length; i++) {
            range[i] = actions[i].key();
        }
        range[this.actions.length] = this.actions.length + 1;
        return range;
    }

    public int exitButton() {
        return this.actions.length + 1;
    }

    private static class AddItem extends BaseAction {

        public AddItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.add(new Item(input.ask("Enter item name:"), input.ask("Enter description of new item:")));
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("\nList of items:\n");
            int pos = 0;
            for (Item item : tracker.getAll()) {
                System.out.println(++pos + ". " + item.getName() + " " + item.getId());
            }
            System.out.println();
        }
    }

    private class ReplaceItem extends BaseAction {

        public ReplaceItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.replace(input.ask("Enter item id:"), new Item(input.ask("Enter new item's name:"), input.ask("Enter description of new item:")));
        }
    }

    private class EditItem extends BaseAction {

        public EditItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.edit(input.ask("Enter item id:"), input.ask("Enter new item's name (leave blank if it not changed):"), input.ask("Enter description of new item (leave blank if it not changed):"));
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(String info, int key) {
            super(info, key);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.delete(input.ask("Enter item id:"));
        }

    }
}
