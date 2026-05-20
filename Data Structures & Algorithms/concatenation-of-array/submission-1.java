class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        
        // 1. Ek naya array banaya jiska size original array se dugna (2 * n) hai
        int[] ans = new int[2 * n]; 
        
        // 2. Loop sirf original array ki length (n) tak chalega
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];     // Pehle half me elements copy ho rahe hain (0 se n-1)
            ans[i + n] = nums[i]; // Dusre half me elements copy ho rahe hain (n se 2n-1)
        }
        
        // 3. Sahi tarike se poora array return kar diya
        return ans; 
    }
}