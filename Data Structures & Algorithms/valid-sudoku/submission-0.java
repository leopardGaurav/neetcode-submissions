class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 rows, 9 columns, aur 9 boxes ke liye boolean trackers
        // Size 10 liya hai taaki number 1-9 ko directly index ki tarah use kar sakein
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Agar cell khali hai, toh skip karo
                if (board[r][c] == '.') {
                    continue;
                }
                // Char ko integer me convert karne ke liye '0' subtract karte hain
                int num = board[r][c] - '0';
                
                // Formula se 3x3 box ka index (0 se 8) nikalte hain
                int boxIdx = (r / 3) * 3 + (c / 3);
                // Agar yeh number pehle se row, col, ya box me maujood hai
                if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                    return false; // Invalid Sudoku
                } 
                // Agar pehli baar aaya hai, toh true mark kar do
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIdx][num] = true;
            }
        }
        return true; // Agar kahi bhi rule nahi toota
    }
}