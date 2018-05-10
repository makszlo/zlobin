package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class BlackKing extends Figure {

    public BlackKing(Cell position) {
        super(position, new int[] {-135, -90, -45, 0, 45, 90, 135, 180}, 2);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BlackKing(dest);
    }
}
