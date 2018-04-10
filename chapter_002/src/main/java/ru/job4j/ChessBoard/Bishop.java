package ru.job4j.ChessBoard;

public class Bishop extends Figure {

    public Bishop(Cell position) {
            super(position, new int[] {-90, 0, 90, 180});
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
