
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting allows us to stop early when a number exceeds remaining target
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int remainingTarget, int start, List<Integer> current, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Prune branches where the current number exceeds remaining target
            if (nums[i] > remainingTarget) {
                break;
            }

            current.add(nums[i]);
            // Pass 'i' instead of 'i + 1' to allow reusing the same element
            backtrack(nums, remainingTarget - nums[i], i, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}