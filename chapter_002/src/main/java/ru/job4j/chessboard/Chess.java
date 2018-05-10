package ru.job4j.chessboard;

import javafx.application   .Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import ru.job4j.chessboard.figures.white.*;
import ru.job4j.chessboard.figures.*;
import ru.job4j.chessboard.figures.black.*;

public class Chess extends Application {
    private static final String JOB4J = "Шахматы на www.job4j.ru";
    private final int size = 8;
    private final Board logic = new Board();

    public static void main(String[] args) {
        launch(args);
    }

    private Rectangle buildRectangle(int x, int y, int size, boolean white) {
        Rectangle rect = new Rectangle();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        if (white) {
            rect.setFill(Color.WHITE);
        } else {
            rect.setFill(Color.GRAY);
        }
        rect.setStroke(Color.BLACK);
        return rect;
    }

    private Rectangle buildFigure(int x, int y, int size, String image) {
        Rectangle rect = new Rectangle();
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(size);
        rect.setWidth(size);
        Image img = new Image(this.getClass().getClassLoader().getResource(image).toString());
        rect.setFill(new ImagePattern(img));
        final Rectangle momento = new Rectangle(x, y);
        rect.setOnDragDetected(
            event -> {
                momento.setX(event.getX());
                momento.setY(event.getY());
            }
        );
        rect.setOnMouseDragged(
            event -> {
                rect.setX(event.getX() - size / 2);
                rect.setY(event.getY() - size / 2);
            }
        );
        rect.setOnMouseReleased(
            event -> {
                boolean movement;
                try {
                    movement = logic.move(this.findBy(momento.getX(), momento.getY()), this.findBy(event.getX(), event.getY()));
                } catch (ImpossibleMoveException | FigureNotFoundException | OccupiedWayException e) {
                    movement = false;
                }
                if (movement) {
                    rect.setX(((int) event.getX() / 40) * 40 + 5);
                    rect.setY(((int) event.getY() / 40) * 40 + 5);
                } else {
                    rect.setX(((int) momento.getX() / 40) * 40 + 5);
                    rect.setY(((int) momento.getY() / 40) * 40 + 5);
                }

            }
        );
        return rect;
    }

    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 1; y <= this.size; y++) {
            for (int x = 1; x <= this.size; x++) {
                panel.getChildren().add(
                        this.buildRectangle(x, y, 40, (x + y) % 2 == 0)
                );
            }
        }
        return panel;
    }

    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Начать");
        start.setOnMouseClicked(
                event -> this.refresh(border)
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 400, 400));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        this.refresh(border);
        stage.show();
    }

    private void refresh(final BorderPane border) {
        Group grid = this.buildGrid();
        this.logic.clean();
        border.setCenter(grid);
        this.buildWhiteTeam(grid);
        this.buildBlackTeam(grid);
    }

    private void buildBlackTeam(Group grid) {
        for (int i = 1; i <= 8; i++) {
            this.add(new WhitePawn(new Cell(i, 7)), grid);
        }
        this.add(new WhiteRook(new Cell(1, 8)), grid);
        this.add(new WhiteRook(new Cell(8, 8)), grid);
        this.add(new WhiteKnight(new Cell(2, 8)), grid);
        this.add(new WhiteKnight(new Cell(7, 8)), grid);
        this.add(new WhiteBishop(new Cell(3, 8)), grid);
        this.add(new WhiteBishop(new Cell(6, 8)), grid);
        this.add(new WhiteQueen(new Cell(4, 8)), grid);
        this.add(new WhiteKing(new Cell(5, 8)), grid);
    }

    public void buildWhiteTeam(Group grid) {
        for (int i = 1; i <= 8; i++) {
            this.add(new BlackPawn(new Cell(i, 2)), grid);
        }
        this.add(new BlackRook(new Cell(1, 1)), grid);
        this.add(new BlackRook(new Cell(8, 1)), grid);
        this.add(new BlackKnight(new Cell(2, 1)), grid);
        this.add(new BlackKnight(new Cell(7, 1)), grid);
        this.add(new BlackBishop(new Cell(3, 1)), grid);
        this.add(new BlackBishop(new Cell(6, 1)), grid);
        this.add(new BlackQueen(new Cell(5, 1)), grid);
        this.add(new BlackKing(new Cell(4, 1)), grid);
    }

    public void add(Figure figure, Group grid) {
        this.logic.add(figure);
        Cell position = figure.getCell();
        grid.getChildren().add(
                this.buildFigure(
                        position.x * 40 + 5,
                        position.y * 40 + 5,
                        30,
                        figure.icon()
                )
        );
    }


    private Cell findBy(double graphX, double graphY) {
        int x = (int) graphX / 40;
        int y = (int) graphY / 40;
        Cell rst = new Cell(x, y);
        return rst;
    }
}