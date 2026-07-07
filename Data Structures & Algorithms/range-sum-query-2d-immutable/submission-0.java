class NumMatrix {
    // Yeh hamari Prefix Sum Matrix hogi
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        // Agar matrix khali hai toh kuch nahi karna
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Size (rows + 1) aur (cols + 1) rakha hai taaki 0th row aur 0th col ke 
        // pehle waale elements ko handle karne mein out of bounds error na aaye (wo automatic 0 rahenge).
        prefixSum = new int[rows + 1][cols + 1];
        
        // Pure matrix ke liye zones ka sum pehle se calculate karna
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Formula: Naya Sum = Current Element + Upar ka zone + Left ka zone - Kona (jo do baar add hua)
                prefixSum[r + 1][c + 1] = matrix[r][c] 
                                        + prefixSum[r][c + 1] 
                                        + prefixSum[r + 1][c] 
                                        - prefixSum[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // O(1) Time: Bas zones ko plus-minus karke specific area ka sum nikalna
        // Kyunki hamari prefixSum matrix 1 size badi hai, isliye coordinates mein +1 ka dhyan rakha hai.
        return prefixSum[row2 + 1][col2 + 1] 
             - prefixSum[row1][col2 + 1] 
             - prefixSum[row2 + 1][col1] 
             + prefixSum[row1][col1];
    }
}

/**
 * Aapka NumMatrix object is tarah se call hoga:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1, col1, row2, col2);
 */