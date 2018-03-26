package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder()
                .append("  *  \n")
                .append(" * * \n")
                .append("*****\n");
        return pic.toString();
    }
}
