package com.example.main;

import java.util.Random;

public class CellularAutomata {

    public final int SIZE; // Size of the automaton (number of cells in a row)
    public int[][] matrix; // The matrix holding all generations (each row is a generation)

    // Constructor to initialize the automaton
    public CellularAutomata(int size) {
        this.SIZE = size;
        matrix = new int[SIZE][SIZE]; // Initialize the matrix to hold generations
        initializeFirstRowMatrix();
        calculateNextStates();// Initialize the first row randomly
    }

    // Method to calculate the next generation based on the current one
    public void calculateNextStates() {
        for (int row = 1; row < SIZE; row++) { // Start from the second row (next generation)
            for (int col = 0; col < SIZE; col++) {
                // Get the left, middle, and right neighbors (with wrapping)
                int left = (col == 0) ? matrix[row - 1][SIZE - 1] : matrix[row - 1][col - 1]; // Wrap around for left
                int middle = matrix[row - 1][col];
                int right = (col == SIZE - 1) ? matrix[row - 1][0] : matrix[row - 1][col + 1]; // Wrap around for right

                // Calculate next state based on neighbors
                matrix[row][col] = calculateState(left, middle, right);
            }
        }
    }

    // Rule definition (example: Rule 110)
    public int calculateState(int left, int middle, int right) {
        // Define the rule for cellular automaton (this is for Rule 110)
        if (left == 1 && middle == 1 && right == 1) return 0;
        if (left == 1 && middle == 1 && right == 0) return 1;
        if (left == 1 && middle == 0 && right == 1) return 1;
        if (left == 1 && middle == 0 && right == 0) return 0;
        if (left == 0 && middle == 1 && right == 1) return 1;
        if (left == 0 && middle == 1 && right == 0) return 1;
        if (left == 0 && middle == 0 && right == 1) return 1;
        if (left == 0 && middle == 0 && right == 0) return 0;

        return -1; // Error state (shouldn't happen)
    }

    // Initialize the first row of the matrix randomly (either 0 or 1)
    public void initializeFirstRowMatrix() {
        Random rand = new Random();
        for (int col = 0; col < SIZE; col++) {
            matrix[0][col] = rand.nextInt(2); // Generates either 0 or 1
        }
    }

    // Return the value of the matrix at position (row, col)
    public int getCellState(int row, int col) {
        return matrix[row][col];
    }

    // Print the entire matrix (for visualization purposes)
    public void printMatrix() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }
    }

}