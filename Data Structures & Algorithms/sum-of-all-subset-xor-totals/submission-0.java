class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        // Include current number XOR Exclude current number
        int include = dfs(nums, index + 1, currentXOR ^ nums[index]);
        int exclude = dfs(nums, index + 1, currentXOR);

        return include + exclude;
    }
}