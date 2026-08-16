public class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int len) {
        // Base case: A 1x1 subgrid is always a leaf node
        if (len == 1) {
            return new Node(grid[row][col] == 1, true);
        }

        int half = len / 2;
        Node topLeft = build(grid, row, col, half);
        Node topRight = build(grid, row, col + half, half);
        Node bottomLeft = build(grid, row + half, col, half);
        Node bottomRight = build(grid, row + half, col + half, half);

        // Merge check: If all 4 children are leaves with identical values
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val
                && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        // Otherwise, construct an internal node with 4 distinct sub-trees
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}