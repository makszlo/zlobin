package ru.job4j.ChessBoard;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BoardTest {

    @Test
    public void moveCheckTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1,1);
        Cell dest = new Cell(8,1);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        boolean answer = board.move(source, dest);
        assertThat(answer, is(true));

    }

    @Test
    public void moveOldDeletedTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1,1);
        Cell dest = new Cell(8,1);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        board.move(source, dest);
        assertThat(board.checkCell(new Cell(1,1)), is(Optional.empty()));
    }

    @Test
    public void moveNewCreatedTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1,1);
        Cell dest = new Cell(8,1);
        Bishop bishop = new Bishop(source);
        board.add(bishop);
        board.move(source, dest);
        assertThat(board.checkCell(new Cell(8,1)).get(), is(0));
    }
    @Test(expected = OccupiedWayException.class)
    public void moveWithObstacleTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1,1);
        Cell dest = new Cell(8,1);
        Bishop bishop = new Bishop(source);
        Bishop obstacle = new Bishop(dest);
        board.add(bishop);
        board.add(obstacle);
        board.move(source, dest);
    }
}
