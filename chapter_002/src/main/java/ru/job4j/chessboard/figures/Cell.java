package ru.job4j.chessboard.figures;

public class Cell {
    public final int x;
    public final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int angle(Cell dest) {
        int difX = dest.x - this.x;
        int difY = dest.y - this.y;
        int angle = (int) Math.toDegrees(Math.acos(difX / Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2))));
        if (difY < 0) {
            return -angle;
        } else {
            return angle;
        }
    }
}
