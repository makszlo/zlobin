package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class BlackRook extends Figure {

    public BlackRook(Cell position) {
            super(position, new int[] {-90, 0, 90, 180}, 0);
    }

    public Figure copy(Cell dest) {
        return new BlackRook(dest);
    }
}
