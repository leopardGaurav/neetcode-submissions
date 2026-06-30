class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n]; // 2n size ka naya array
        
        // 1. Pehle half me copy karo (ans ke index 0 se shuru karke)
        System.arraycopy(nums, 0, ans, 0, n);
        
        // 2. Dusre half me copy karo (ans ke index n se shuru karke)
        System.arraycopy(nums, 0, ans, n, n);
        
        return ans;
    }
}