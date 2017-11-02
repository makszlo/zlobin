package ru.job4j.condition;
/**
 * Class for point task
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.10.2017
 * @version 0.1
 */
public class Point {
    private int x;
    private int y;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean is(int a, int b) {
        return (a != 0 || b != 0) && getY() == a * getX() + b;
    }
}
