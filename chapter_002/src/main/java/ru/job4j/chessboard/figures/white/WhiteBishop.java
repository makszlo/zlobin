package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация белого ферзя
 * @author Zlobin Maxim
 */
public class WhiteBishop extends Figure {
    public WhiteBishop(Cell position) {
        super(position, new int[] {-135, -45, 45, 135}, 0);
    }

    public Figure copy(Cell dest) {
        return new WhiteBishop(dest);
    }
}
