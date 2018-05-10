package ru.job4j.chessboard.figures.white;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class WhiteKnight extends Figure {
    public WhiteKnight(Cell position) {
        super(position, new int[] {-153, -116, -63, -26, 26, 63, 116, 153}, 4);
    }

    public int distanceTo(int distance) {
        return distance + 1;
    }

    public Figure copy(Cell dest) {
        return new WhiteKnight(dest);
    }
}
