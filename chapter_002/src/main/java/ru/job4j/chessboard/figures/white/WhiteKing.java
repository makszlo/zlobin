package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация белого короля
 * @author Zlobin Maxim
 */
public class WhiteKing extends Figure {

    public WhiteKing(Cell position) {
        super(position, new int[] {-135, -90, -45, 0, 45, 90, 135, 180}, 2);
    }

    @Override
    public Figure copy(Cell dest) {
        return new WhiteKing(dest);
    }
}
