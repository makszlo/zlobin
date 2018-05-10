package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class BlackKnight extends Figure {
    public BlackKnight(Cell position) {
        super(position, new int[] {-153, -116, -63, -26, 26, 63, 116, 153}, 4);
    }

    public int distanceTo(int distance) {
        return distance + 1;
    }

    public Figure copy(Cell dest) {
        return new BlackKnight(dest);
    }
}
