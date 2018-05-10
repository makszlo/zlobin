package ru.job4j.chessboard.figures;


import ru.job4j.chessboard.ImpossibleMoveException;

public abstract class Figure {
    private final Cell position;
    private int[] angles;
    private int distance;

    public Figure(Cell position, int[] angles, int dist) {

        this.position = position;
        this.angles = angles;
        this.distance = dist;
    }

    public Cell getCell() {
        return this.position;
    }

    public  Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (dest.x <= 1 || dest.x >= 8 || dest.y >= 8 || dest.y <= 1) {
            throw new ImpossibleMoveException("Невозможно двигать фигуры за пределы доски");
        }
        Cell[] cells = null;
        Cell source = this.getCell();
        int angle = source.angle(dest);
        for (int ang : this.angles) {
            if (ang == angle) {
                int dX = (int) Math.round(Math.cos(Math.toRadians(angle)));
                int dY = (int) Math.round(Math.sin(Math.toRadians(angle)));
                int dist = this.distanceTo(dX * (dest.x - source.x) + dY * (dest.y - source.y));
                if (this.distance != 0 && dist + 1 != this.distance) {
                    throw new ImpossibleMoveException("Эта фигура не двигается так далеко");
                }
                cells = new Cell[dist + 1];
                cells[0] = source;
                cells[dist] = dest;
                for (int in = 1; in < dist; in++) {
                    cells[in] = new Cell(source.x + dX * in, source.y + dY * in);
                }
                break;
            }
        }
        if (cells != null) {
            return cells;
        } else  {
            throw new ImpossibleMoveException("Фигура не может быть передвинута в эту клетку");
        }
    }

    public int distanceTo(int distance) {
        return distance;
    }
    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    public abstract Figure copy(Cell dest);
}
