public class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Try starting the word from this cell
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Found the entire word
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or character mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length 
            || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark this cell as visited (use a char that can't appear in the word)
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore all 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                         dfs(board, word, r - 1, c, index + 1) ||
                         dfs(board, word, r, c + 1, index + 1) ||
                         dfs(board, word, r, c - 1, index + 1);

        // Backtrack: restore the original character
        board[r][c] = temp;

        return found;
    }
}