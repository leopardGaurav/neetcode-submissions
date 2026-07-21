class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Boundary case handle karne ke liye

        // Step 1: Poore array ko reverse karo
        reverse(nums, 0, n - 1);

        // Step 2: Pehle k elements ko reverse karo
        reverse(nums, 0, k - 1);

        // Step 3: Baaki bache (n - k) elements ko reverse karo
        reverse(nums, k, n - 1);
    }

    // Helper method: In-place array section ko reverse karne ke liye
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}