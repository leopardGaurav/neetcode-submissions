class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Start both pointers at index 0
        int slow = 0;
        int fast = 0;

        // Move slow by 1 step, fast by 2 steps until collision
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle (the duplicate number)
        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}