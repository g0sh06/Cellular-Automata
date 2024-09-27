# Cellular-Automata
Cellular Automata (CA) are a type of discrete model studied in computer science, mathematics, and theoretical biology. They consist of a grid of cells, where each cell can be in one of a finite number of states (commonly "on" or "off"). The state of a cell in the next generation is determined by a set of rules that considers the current state of the cell and the states of its neighboring cells.

This project implements a basic Cellular Automata simulator using JavaFX for the graphical interface.
## What is Cellular Automata?

Cellular Automata work on a grid (usually 2D) where:

Each cell can have a specific state. For simplicity, states are often binary (e.g., "alive" or "dead").
Time progresses in discrete steps, and at each step, the state of each cell is updated based on the current states of its neighboring cells.
Rules dictate how the states evolve over time. The most well-known example is Conway's Game of Life, where cells follow simple rules to "live", "die", or "reproduce".

## How It Works
Grid Representation

The grid is represented as a 2D array where each element is a "cell".
The state of each cell is updated according to predefined rules that check the states of its neighboring cells.

## JavaFX Implementation

The graphical interface is created using JavaFX to visualize the grid of cells.
Each cell is represented as a square (or another shape) in the JavaFX Scene.
You can start, stop, and reset the simulation using JavaFX controls like buttons.
