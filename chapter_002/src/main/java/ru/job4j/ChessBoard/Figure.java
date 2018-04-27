package ru.job4j.ChessBoard;

abstract class Figure {
    private final Cell position;
    private final int[] angles;

    public Figure(Cell position, int[] angles) {
        this.position = position;
        this.angles = angles;
    }

    public Cell getCell() {
        return this.position;
    }

    public  Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (dest.x > 8 && dest.x < 1 && dest.y > 8 && dest.y < 1) {
            throw new ImpossibleMoveException("Невозможно двигать фигуры за пределы доски");
        }
        Cell[] cells = new Cell[0];
        Cell source = this.getCell();
        int angle = source.angle(dest);
        for (int ang : this.angles) {
            if (ang == angle) {
                int dX = (int) Math.round(Math.cos(Math.toRadians(angle)));
                int dY = (int) Math.round(Math.sin(Math.toRadians(angle)));
                int dist = (dX * (dest.x - source.x) + dY * (dest.y - source.y));
                cells = new Cell[dist + 1];
                cells[0] = source;
                cells[dist] = dest;
                for (int in = 1; in < dist; in++) {
                    cells[in] = new Cell(source.x + dX * in, source.y + dY * in);
                }
                break;
            }
        }
        if (cells[0] != null) {
            return cells;
        } else  {
            throw new ImpossibleMoveException("Фигура не может быть передвинута в эту клетку");
        }
    }
    public abstract Figure copy(Cell dest);
}
