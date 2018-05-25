package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

/**
 * Реализация черной королевы
 * @author Zlobin Maxim
 */
public class BlackQueen extends Figure {

    public BlackQueen(Cell position) {
        super(position, new int[] {-135, -90, -45, 0, 45, 90, 135, 180}, 0);
    }

    public Figure copy(Cell dest) {
        return new BlackQueen(dest);
    }
}
