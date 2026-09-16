
public class Solution {
    private int n;
    private Set<Integer> cols;
    private Set<Integer> posDiagonals; // row - col
    private Set<Integer> negDiagonals; // row + col
    private char[][] board;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.cols = new HashSet<>();
        this.posDiagonals = new HashSet<>();
        this.negDiagonals = new HashSet<>();
        this.result = new ArrayList<>();
        this.board = new char[n][n];

        for (char[] row : board) {
            java.util.Arrays.fill(row, '.');
        }

        backtrack(0);
        return result;
    }

    private void backtrack(int row) {
        // Base case: successfully placed a queen in every row
        if (row == n) {
            result.add(buildSolution());
            return;
        }

        for (int col = 0; col < n; col++) {
            int posDiag = row - col;
            int negDiag = row + col;

            // Skip if this column or either diagonal is under attack
            if (cols.contains(col) || posDiagonals.contains(posDiag) 
                || negDiagonals.contains(negDiag)) {
                continue;
            }

            // Place the queen
            cols.add(col);
            posDiagonals.add(posDiag);
            negDiagonals.add(negDiag);
            board[row][col] = 'Q';

            // Recurse to the next row
            backtrack(row + 1);

            // Backtrack: remove the queen and free up the column/diagonals
            cols.remove(col);
            posDiagonals.remove(posDiag);
            negDiagonals.remove(negDiag);
            board[row][col] = '.';
        }
    }

    private List<String> buildSolution() {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}