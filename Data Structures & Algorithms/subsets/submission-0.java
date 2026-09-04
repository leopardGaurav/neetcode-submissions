

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add a deep copy of current subset to the result
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);                  // Include nums[i]
            backtrack(nums, i + 1, current, result); // Move to next elements
            current.remove(current.size() - 1);    // Backtrack (exclude nums[i])
        }
    }
}