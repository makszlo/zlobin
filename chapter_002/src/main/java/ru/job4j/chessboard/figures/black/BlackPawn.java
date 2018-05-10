package ru.job4j.chessboard.figures.black;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;

public class BlackPawn extends Figure {
    public BlackPawn(Cell position) {
        super(position, new int[] {90}, 2);
    }

    public Figure copy(Cell dest) {
        return new BlackPawn(dest);
    }
}
