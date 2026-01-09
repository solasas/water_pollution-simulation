package com.sashank.waterpollutionsimulator.model;

public class WaterGrid {

    private Zone[][] grid;

    public WaterGrid(int rows, int cols) {
        grid = new Zone[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Zone();
            }
        }
    }

    public Zone[][] getGrid() {
        return grid;
    }
}