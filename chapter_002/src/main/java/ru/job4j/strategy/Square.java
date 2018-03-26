package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder()
                .append("****\n")
                .append("*  *\n")
                .append("*  *\n")
                .append("****\n");
        return pic.toString();
    }
}
