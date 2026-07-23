
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Map to store: Key = Number, Value = Last Seen Index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Check if the number was seen before
            if (map.containsKey(nums[i])) {
                int previousIndex = map.get(nums[i]);
                
                // If the index difference is <= k, valid pair found!
                if (i - previousIndex <= k) {
                    return true;
                }
            }
            
            // Put / Update the current element with its latest index
            map.put(nums[i], i);
        }

        // No valid pair found
        return false;
    }
}