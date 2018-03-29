package ru.job4j.tracker;

public class MenuOutOfRange extends RuntimeException {
    public MenuOutOfRange(String msg) {
        super(msg);
    }
}
