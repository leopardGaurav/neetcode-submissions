

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Step 1: Sort the array to group duplicates together
        Arrays.sort(nums);
        
        // Step 2: Backtrack with a visited array
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] visited) {
        // Base case: if the permutation is complete, add it to the result
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If element is already visited, skip it
            if (visited[i]) {
                continue;
            }
            
            // Skip duplicates: if current element equals the previous one, 
            // and the previous one was not used in this branch, skip to prevent duplicate permutations
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            // Choose
            visited[i] = true;
            tempList.add(nums[i]);

            // Explore
            backtrack(result, tempList, nums, visited);

            // Un-choose (Backtrack)
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}