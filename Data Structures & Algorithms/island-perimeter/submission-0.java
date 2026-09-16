public class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Check all 4 directions; add 1 for each side that's 
                    // water or out of bounds
                    perimeter += countExposedSides(grid, r, c, rows, cols);
                }
            }
        }
        return perimeter;
    }
    private int countExposedSides(int[][] grid, int r, int c, int rows, int cols) {
        int exposed = 0;

        // Up
        if (r == 0 || grid[r - 1][c] == 0) {
            exposed++;
        }
        // Down
        if (r == rows - 1 || grid[r + 1][c] == 0) {
            exposed++;
        }
        // Left
        if (c == 0 || grid[r][c - 1] == 0) {
            exposed++;
        }
        // Right
        if (c == cols - 1 || grid[r][c + 1] == 0) {
            exposed++;
        }

        return exposed;
    }
}