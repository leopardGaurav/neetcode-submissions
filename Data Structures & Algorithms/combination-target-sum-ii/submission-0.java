
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort to bring duplicate elements together and allow early pruning
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> current, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Early Pruning: candidates[i] is greater than the remaining target
            if (candidates[i] > remainingTarget) {
                break;
            }
            // Skip duplicate elements at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            // Recurse with i + 1 because each element can be used at most once
            backtrack(candidates, remainingTarget - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}