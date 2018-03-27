package ru.job4j.tracker;

public class StartUI {
    private Input input;
    private Tracker tracker;

    public static void main(String[] args) {
        new StartUI().init();
    }

    public StartUI() {
        this.tracker = new Tracker();
        this.input = new ConsoleInput();
    }

    public StartUI(Input input) {
        this.tracker = new Tracker();
        this.input = input;
    }

    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    public  void init() {
        String exit = "0";
        MenuTracker mt = new MenuTracker(this.input, this.tracker);
        mt.fillActions();
        do {
            mt.showActions();
            int answer = Integer.valueOf(input.ask("Select:"));
                if (answer != mt.exitButton()) {
                    mt.select(answer - 1);
                } else {
                    exit = "1";
                }
            } while ("0".equals(exit));
        }
    }