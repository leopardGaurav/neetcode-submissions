class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        // Establish binary search lower and upper bounds
        for (int num : nums) {
            left = Math.max(left, num); // Subarray largest sum must at least fit the largest element
            right += num;               // Upper bound is sum of all elements (k = 1)
        }
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                res = mid;          // Record candidate answer
                right = mid - 1;    // Try to minimize the largest subarray sum further
            } else {
                left = mid + 1;     // Threshold too small, need larger subarray sum limit
            }
        }
        return res;
    }
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrayCount = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrayCount++;
                currentSum = 0;
            }
            currentSum += num;
        }
        return subarrayCount <= k;
    }
}