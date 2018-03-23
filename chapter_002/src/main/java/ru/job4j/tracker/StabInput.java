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
}
