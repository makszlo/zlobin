package ru.job4j.tracker;

public class StartUI {
    private  int[] range;
    private Input input;
    private Tracker tracker;

    public static void main(String[] args) {
        new StartUI().init();
    }

    public StartUI() {
        this.tracker = new Tracker();
        this.input = new ValidateInput();
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
        this.range = mt.getRange();
        do {
            mt.showActions();
            int answer = input.ask("Select:", mt.getRange());
                if (answer != mt.exitButton()) {
                    mt.select(answer - 1);
                } else {
                    exit = "1";
                }
            } while ("0".equals(exit));
        }
    }