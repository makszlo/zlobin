package ru.job4j.tracker;

import java.util.Optional;

class FindItemById implements UserAction {
    @Override
    public int key() {
        return 6;
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

    @Override
    public String info() {
        return  String.format("%s. %s", this.key(), "Find item by id");
    }
}

class FindItemByName implements UserAction {
    @Override
    public int key() {
        return 7;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Optional<Item[]> items = tracker.findByName(input.ask("Enter keyword"));
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

    @Override
    public String info() {
        return  String.format("%s. %s", this.key(), "Find items by name");
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
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = this.new ReplaceItem();
        this.actions[3] = this.new EditItem();
        this.actions[4] = this.new DeleteItem();
        this.actions[5] = new FindItemById();
        this.actions[6] = new FindItemByName();
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

    private static class AddItem implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.add(new Item(input.ask("Enter item name:"), input.ask("Enter description of new item:")));
        }

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Add new item");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class ReplaceItem implements  UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.replace(input.ask("Enter item id:"), new Item(input.ask("Enter new item's name:"), input.ask("Enter description of new item:")));
        }

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Replace item");
        }
    }

    private class EditItem implements  UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.edit(input.ask("Enter item id:"), input.ask("Enter new item's name (leave blank if it not changed):"), input.ask("Enter description of new item (leave blank if it not changed):"));
        }

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Edit item");
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.delete(input.ask("Enter item id:"));
        }

        @Override
        public String info() {
            return  String.format("%s. %s", this.key(), "Delete item");
        }
    }




}
