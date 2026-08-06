class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Ambiguity check: cannot determine which half is sorted
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } 
            // Left half is monotonically sorted
            else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Target lies within left sorted portion
                } else {
                    left = mid + 1;  // Target lies in right portion
                }
            } 
            // Right half is monotonically sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Target lies within right sorted portion
                } else {
                    right = mid - 1; // Target lies in left portion
                }
            }
        }

        return false;
    }
}