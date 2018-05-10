package ru.job4j.chessboard;

import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.Figure;
import ru.job4j.chessboard.figures.black.BlackKnight;
import ru.job4j.chessboard.figures.white.WhiteKnight;

import java.util.Optional;

public class Board {
    private Figure[] figures = new Figure[32];
    private int position = 0;

    public void add(Figure figure) {
        this.figures[position++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Optional<Integer> index = checkCell(source);
        if (index.isPresent()) {
            Cell[] way = this.figures[index.get()].way(dest);
            if (!(this.figures[index.get()] instanceof BlackKnight || this.figures[index.get()] instanceof WhiteKnight)) {
                for (int i = 1; i < way.length; i++) {
                    if (checkCell(way[i]).isPresent()) {
                        throw new OccupiedWayException("На пути находится фигура");
                    }
                }
            } else {
                if (checkCell(way[way.length - 1]).isPresent()) {
                    throw new OccupiedWayException("На пути находится фигура");
                }
            }
            this.figures[index.get()] = this.figures[index.get()].copy(dest);
            return true;
        } else {
            throw new FigureNotFoundException("В данной клетке нет фигуры");
        }
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.position = 0;
    }

    public Optional<Integer> checkCell(Cell source) {
        for (int i = 0; i < this.position; i++) {
            if (source.x == figures[i].getCell().x && source.y == figures[i].getCell().y) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
