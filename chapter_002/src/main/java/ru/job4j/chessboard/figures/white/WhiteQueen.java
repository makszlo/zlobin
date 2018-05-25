package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация белой королевы
 * @author Zlobin Maxim
 */
public class WhiteQueen extends Figure {

    public WhiteQueen(Cell position) {
        super(position, new int[] {-135, -90, -45, 0, 45, 90, 135, 180}, 0);
    }

    public Figure copy(Cell dest) {
        return new WhiteQueen(dest);
    }
}
