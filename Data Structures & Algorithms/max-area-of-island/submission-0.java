public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, rows, cols);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int r, int c, int rows, int cols) {
        // Out of bounds or water or already visited
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
            return 0;
        }

        // Mark this cell as visited (sink it)
        grid[r][c] = 0;

        // This cell counts as 1, plus whatever area is reachable in all 4 directions
        int area = 1;
        area += dfs(grid, r + 1, c, rows, cols);
        area += dfs(grid, r - 1, c, rows, cols);
        area += dfs(grid, r, c + 1, rows, cols);
        area += dfs(grid, r, c - 1, rows, cols);
        return area;
    }
}