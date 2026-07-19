class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Do pointers banaye: ek shuruat mein, ek aakhir mein
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            // 1. Agar target mil gaya
            if (currentSum == target) {
                // Sawaal 1-indexed maang raha hai, isliye +1 kiya
                return new int[]{left + 1, right + 1};
            } 
            // 2. Agar sum bada hai, toh right pointer ko piche lao
            else if (currentSum > target) {
                right--;
            } 
            // 3. Agar sum chota hai, toh left pointer ko aage badhao
            else {
                left++;
            }
        }
        
        // Sawaal mein bola hai exactly one solution hamesha hoga, 
        // isliye ye line kabhi execute nahi hogi, par syntax ke liye zaroori hai.
        return new int[]{-1, -1};
    }
}