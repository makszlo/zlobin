package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация белой пешки
 * @author Zlobin Maxim
 */
public class WhitePawn extends Figure {
    public WhitePawn(Cell position) {
        super(position, new int[] {-90}, 2);
    }

    public Figure copy(Cell dest) {
        return new WhitePawn(dest);
    }
}
