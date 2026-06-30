class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap banaya: Key = Number, Value = Uska Index
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        
        // Array par sirf EK baar loop chalega
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            
            // Mujhe target poora karne ke liye kis number ki zaroorat hai?
            int complement = target - currentNum;
            
            // Kya vo zaroorat wala number pehle aa chuka hai?
            if (map.containsKey(complement)) {
                // Agar haan, toh purane wale ka index pehle (map.get) aur current index baad me
                return new int[]{map.get(complement), i};
            }
            
            // Agar nahi aaya, toh current number aur uska index map me save kar lo
            map.put(currentNum, i);
        }
        
        // Agar koi pair nahi mila (waise question ke mutabik hamesha milega)
        return new int[]{};
    }
}