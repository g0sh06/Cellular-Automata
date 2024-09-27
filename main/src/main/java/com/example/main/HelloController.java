package com.example.main;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private TextField inputField1;

    @FXML
    private TextField inputField2;

    @FXML
    private TextField inputField3;

    @FXML
    private TextField inputField4;

    @FXML
    private TextField inputField5;

    @FXML
    private TextField inputField6;

    @FXML
    private TextField inputField7;

    @FXML
    private TextField inputField8;

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

    public void action(){
        cellularAutomata.calculateNextStates();
    }

    private void drawgrid() {
        gc.clearRect(0, 0, SIZE * CUBE_WIDTH, SIZE * CUBE_HEIGHT); // Clear previous drawings
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                double x = col * CUBE_WIDTH; // Note: col for x and row for y
                double y = row * CUBE_HEIGHT;
                if (cellularAutomata.getCellState(row, col) == 1) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);
                }
                gc.setStroke(Color.GRAY); // Set stroke color for grid
                gc.strokeRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);
            }
        }
    }

//    @FXML
//    public void printNumber() {
//        // Concatenate the inputs from all text fields
//        String numberString = inputField1.getText() +
//                inputField2.getText() +
//                inputField3.getText() +
//                inputField4.getText() +
//                inputField5.getText() +
//                inputField6.getText() +
//                inputField7.getText() +
//                inputField8.getText();
//
//        try {
//            // Convert the concatenated string to an integer
//            int number = Integer.parseInt(numberString);
//
//            // Print the resulting number
//            System.out.println("Number: " + number);
//        } catch (NumberFormatException e) {
//            // Handle cases where input might not be valid digits
//            System.out.println("Invalid input: Please enter valid digits.");
//        }
//    }
}