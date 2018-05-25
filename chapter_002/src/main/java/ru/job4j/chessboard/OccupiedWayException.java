package ru.job4j.chessboard;

/**
 * Исключение препядствия на пути
 * @author Zlobin Maxim
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
