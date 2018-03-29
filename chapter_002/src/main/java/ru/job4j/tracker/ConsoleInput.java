package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask("Select:"));
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
