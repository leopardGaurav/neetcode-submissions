class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Shuruat mein pehla element candidate hai
        int count = 1;          // Uska vote count 1 hai
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // Purane candidate ke votes khatam, naya candidate chuno
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++; // Same number mila to vote badhao
            } else {
                count--; // Alag number mila to vote ghatao (cancel karo)
            }
        }
        
        return candidate; // Aakhri mein jo bachega, wahi majority element hoga
    }
}