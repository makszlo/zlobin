package ru.job4j.chessboard;

import org.junit.Test;
import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.white.*;
import ru.job4j.chessboard.figures.black.BlackPawn;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardTest {

    @Test
    public void moveCheckTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(8, 1);
        WhiteRook rook = new WhiteRook(source);
        board.add(rook);
        boolean answer = board.move(source, dest);
        assertThat(answer, is(true));

    }

    @Test
    public void moveOldDeletedTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(8, 1);
        WhiteRook rook = new WhiteRook(source);
        board.add(rook);
        board.move(source, dest);
        assertThat(board.checkCell(new Cell(1, 1)), is(Optional.empty()));
    }

    @Test
    public void moveNewCreatedTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(8, 1);
        WhiteRook rook = new WhiteRook(source);
        board.add(rook);
        board.move(source, dest);
        assertThat(board.checkCell(new Cell(8, 1)).get(), is(0));
    }
    @Test(expected = OccupiedWayException.class)
    public void moveWithObstacleTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(8, 1);
        WhiteRook rook = new WhiteRook(source);
        WhiteRook obstacle = new WhiteRook(dest);
        board.add(rook);
        board.add(obstacle);
        board.move(source, dest);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void impossibleMoveTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(7, 1);
        WhiteRook rook = new WhiteRook(source);
        WhiteRook obstacle = new WhiteRook(dest);
        board.add(rook);
        board.add(obstacle);
        board.move(source, dest);
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveNothingTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(7, 1);
        board.move(source, dest);
    }

}
