package ru.job4j.chessboard;

import org.junit.Test;
import ru.job4j.chessboard.figures.Cell;
import ru.job4j.chessboard.figures.white.*;

import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования логики шахматной доски
 * @author Zlobin Maxim
 */
public class BoardTest {
    /**
     * Тест для проверки передвижения
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
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

    /**
     * Проверка удаления предыдущей фигуры
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
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

    /**
     * Проверка создания новой фигуры
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
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

    /**
     * Тест перехвата исключения OccupiedWayException
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
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

    /**
     * Тест перехвата ислючения ImpossibleMoveException
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void impossibleMoveTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(9, 1);
        WhiteRook rook = new WhiteRook(source);
        board.add(rook);
        board.move(source, dest);
    }

    /**
     * Тест преехвата исключения FigureNotFoundException
     * @throws ImpossibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    @Test(expected = FigureNotFoundException.class)
    public void moveNothingTest() throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(7, 1);
        board.move(source, dest);
    }

}
