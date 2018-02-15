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

    /**
     * Конструктор для класса Point.
     * @param x
     * @param y
     */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для получения кооридинаты по оси Х
     * @return - координата Х
     */
    public int getX() {
        return this.x;
    }

    /**
     * Метод для получения кооридинаты по оси Y
     * @return - координата Y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Метод для проверки принадлежит ли точка на прямой
     * @param a - коэффициент наклона в уравнении прямой
     * @param b - коэффициент смещения по оси Y
     * @return - принадлежи / не принадлежит
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b;
    }
}
