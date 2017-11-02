package ru.job4j.condition;
/**
 * Class for triangle task
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 02.10.2017
 * @version 0.1
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод ля вычисления расстояния между точками
     * @param left - первая точка
     * @param right - вторая точка
     * @return - расстояние между точками
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(left.getX() - right.getX(), 2) + Math.pow(left.getY() - right.getY(), 2));
    }

    /**
     * Метод для вычисления периметра треугольника
     * @param ab - расстояние между первой и второй точкой
     * @param ac - расстояние моежду первой и третьей точкой
     * @param bc - расстояние между второй и третьей точкой
     * @return - периметр треугольника
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод для рассчёта площади треугольника
     * @return - площадь треугольника
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метол для проверки существования треугольника
     * @param ab - расстояние между первой и второй точкой
     * @param ac - расстояние моежду первой и третьей точкой
     * @param bc - расстояние между второй и третьей точкой
     * @return - true - существует, false - не существует
     */
    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab;
    }
}
