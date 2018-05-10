package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class WhiteRook extends Figure {

    public WhiteRook(Cell position) {
            super(position, new int[] {-90, 0, 90, 180}, 0);
    }

    public Figure copy(Cell dest) {
        return new WhiteRook(dest);
    }
}
