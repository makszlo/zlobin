package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder()
                .append("  *  ")
                .append(" * * ")
                .append("*****");
        return pic.toString();
    }
}
