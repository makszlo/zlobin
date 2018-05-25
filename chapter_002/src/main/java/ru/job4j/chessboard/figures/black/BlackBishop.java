package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация черного ферзь
 * @author Zlobin Maxim
 */
public class BlackBishop extends Figure {
    public BlackBishop(Cell position) {
        super(position, new int[] {-135, -45, 45, 135}, 0);
    }

    public Figure copy(Cell dest) {
        return new BlackBishop(dest);
    }
}
