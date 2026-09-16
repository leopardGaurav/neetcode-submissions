
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }

        // Must be divisible by 4 to form a square
        if (total % 4 != 0) {
            return false;
        }
        int target = total / 4;

        // Sort descending: place larger sticks first for better pruning
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        // If any single matchstick is longer than the target side, impossible
        if (matchsticks[0] > target) {
            return false;
        }

        int[] sides = new int[4]; // current length of each of the 4 sides
        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks, int index, int[] sides, int target) {
        // Base case: all matchsticks placed
        if (index == matchsticks.length) {
            // Since total is divisible by 4 and we've maintained sides[i] <= target
            // throughout, reaching here means all sides equal target.
            return true;
        }

        int stick = matchsticks[index];

        for (int i = 0; i < 4; i++) {
            // Try adding this matchstick to side i, if it fits
            if (sides[i] + stick <= target) {
                sides[i] += stick;
                if (backtrack(matchsticks, index + 1, sides, target)) {
                    return true;
                }
                sides[i] -= stick; // backtrack

                // Pruning: if this side is currently empty (0) and placing 
                // the stick here failed, no point trying other empty sides
                // (they're equivalent by symmetry) — also, if placing here
                // resulted in failure, don't try again on an empty side.
                if (sides[i] == 0) {
                    break;
                }
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}