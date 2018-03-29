package ru.job4j.tracker;

public class StabInput implements Input {
    private final String[] keywords;
    private int position = 0;

    public StabInput(String[] keywords) {
        this.keywords = keywords;
    }
    public String ask(String question) {
        return this.keywords[this.position++];
    }
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(""));
        boolean exist = false;
        for (int rangeKey : range) {
            if (rangeKey == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return  key;
        } else {
            throw new MenuOutOfRange("Out of menu range.");
        }
    }
}
