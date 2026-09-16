public class Solution {
    private int n;
    private int count;

    public int totalNQueens(int n) {
        this.n = n;
        this.count = 0;
        backtrack(0, 0, 0, 0);
        return count;
    }
    /**
     * row: current row index (0 to n-1)
     * cols: bitmask of occupied columns
     * posDiag: bitmask of occupied "positive" diagonals (row - col)
     * negDiag: bitmask of occupied "negative" diagonals (row + col)
     */
    private void backtrack(int row, int cols, int posDiag, int negDiag) {
        if (row == n) {
            count++;
            return;
        }

        // Bits set to 1 represent valid (unattacked) positions in this row
        int fullMask = (1 << n) - 1;
        int available = fullMask & ~(cols | posDiag | negDiag);

        while (available != 0) {
            // Extract the lowest set bit -> the next column to try
            int bit = available & (-available);
            available ^= bit; // remove this bit from available for next iteration

            // Place queen: update masks and recurse
            // Shift diagonals: posDiag shifts left as row increases, 
            // negDiag shifts right as row increases
            backtrack(row + 1, cols | bit, (posDiag | bit) << 1, (negDiag | bit) >> 1);
        }
    }
}