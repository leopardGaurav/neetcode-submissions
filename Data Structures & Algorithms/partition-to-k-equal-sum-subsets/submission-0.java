

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If total sum cannot be divided equally into k parts, return false
        if (sum % k != 0) return false;
        int target = sum / k;
        
        // Sort array in ascending order, then reverse to descending
        Arrays.sort(nums);
        reverse(nums);
        
        // If the largest element is greater than the target, it's impossible
        if (nums[0] > target) return false;
        
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, k, target, 0, 0);
    }
    
    private boolean backtrack(int[] nums, boolean[] visited, int k, int target, int currentSum, int startIndex) {
        // Base case: if k - 1 buckets are successfully filled, the last one is valid
        if (k == 1) return true;
        
        // If current bucket reached the target sum, move on to the next bucket
        if (currentSum == target) {
            return backtrack(nums, visited, k - 1, target, 0, 0);
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i]) continue;
            if (currentSum + nums[i] > target) continue;
            
            // Choose
            visited[i] = true;
            
            // Explore
            if (backtrack(nums, visited, k, target, currentSum + nums[i], i + 1)) {
                return true;
            }
            
            // Un-choose (Backtrack)
            visited[i] = false;
            
            // Optimization: if currentSum is 0 and this element failed, 
            // no need to try other elements at this level
            if (currentSum == 0) {
                break;
            }
        }
        
        return false;
    }
    
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}