class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Array ko sort karo
        Arrays.sort(nums);
        
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            // Optimization: Agar smallest element 0 se bada hai, toh sum 0 ho hi nahi sakta
            if (nums[i] > 0) break;
            
            // Duplicate 'i' ko skip karo
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Triplet mil gaya
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Duplicate 'left' aur 'right' elements ko skip karo
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++; // Sum chhota hai, left pointer aage badhao
                } 
                else {
                    right--; // Sum bada hai, right pointer pichhe lao
                }
            }
        }
        
        return result;
    }
}