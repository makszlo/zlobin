package ru.job4j.ChessBoard;

import java.util.Optional;

public class Board {
    private Figure[] figures = new Figure[32];
    private int position = 0;

    public void add(Figure figure) {
        this.figures[position++] = figure;
    }

    public static void main(String[] args) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1,1);
        Cell dest = new Cell(8,1);
        Bishop bishop = new Bishop(source);
        Bishop obstacle = new Bishop(dest);
        board.add(bishop);
        board.add(obstacle);
        board.move(source, dest);
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Optional<Integer> index = checkCell(source);
        if (index.isPresent()) {
            Cell[] way = this.figures[index.get()].way(dest);
            for (int i = 1; i < way.length; i++) {
                if (checkCell(way[i]).isPresent()) {
                    throw new OccupiedWayException("На пути находится фигура");
                }
            }
            this.figures[index.get()] = this.figures[index.get()].copy(dest);
            return true;
        } else {
            throw new FigureNotFoundException("В данной клетке нет фигуры");
        }
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
