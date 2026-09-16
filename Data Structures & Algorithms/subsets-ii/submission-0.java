

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to group duplicates together
        Arrays.sort(nums);
        
        // Step 2: Start backtracking
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same tree level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Choose
            tempList.add(nums[i]);
            // Explore
            backtrack(result, tempList, nums, i + 1);
            // Un-choose (Backtrack)
            tempList.remove(tempList.size() - 1);
        }
    }
}