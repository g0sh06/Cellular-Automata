package com.example.main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private GridPane gridPane;
    private GraphicsContext gc;
    private final static int SIZE = 80;
    private final static double CUBE_HEIGHT = 10.0;
    private final static double CUBE_WIDTH = 10.0;
    CellularAutomata cellularAutomata = new CellularAutomata(SIZE);

    @FXML
    public void initialize() {
        Canvas canvas = new Canvas(SIZE * CUBE_HEIGHT, SIZE * CUBE_WIDTH);
        gridPane.add(canvas, 0, 0);

        gc = canvas.getGraphicsContext2D();

        drawgrid();
    }


    @FXML
    protected void onHelloButtonClick() {

    }

    private void drawgrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                double x = row * CUBE_WIDTH;
                double y = col * CUBE_HEIGHT;
                if(cellularAutomata.printMatrix(row, col) == 1){
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);
                }
                gc.strokeRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);
            }
        }
    }
}