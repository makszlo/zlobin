package ru.job4j.chessboard;

/**
 * Исключение невозможного построения пути
 * @author Zlobin Maxim
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}