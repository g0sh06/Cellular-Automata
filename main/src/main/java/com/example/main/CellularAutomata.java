package com.example.main;

import java.util.Random;

public class CellularAutomata {

    public final int SIZE;
    public int[][] matrix;

    public CellularAutomata(int size) {
        SIZE = size;
        matrix = new int[SIZE][SIZE];  // Initialize the matrix with proper size
        initializeMatrix(SIZE);
    }

    public void initializeMatrix(int size) {
        Random rand = new Random();
        for(int i = 0; i < size; i++) {
            for(int k = 0; k < size; k++) {
                int randomValue = rand.nextInt(2);  // Generates either 0 or 1
                matrix[i][k] = randomValue;
            }
        }
    }

    public int printMatrix(int i, int k) {
        return matrix[i][k];
    }
}