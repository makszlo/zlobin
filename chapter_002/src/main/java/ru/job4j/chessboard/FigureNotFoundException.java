package ru.job4j.chessboard;

/**
 * Класс исключения ненайденной в клетке фигуры
 * @author Zlobin Maxim
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
