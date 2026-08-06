class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int resIdx = 0;

        // Deque stores indices of elements
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window bound [i - k + 1, i]
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            // 2. Maintain monotonic property: remove indices of smaller elements from back
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // 3. Add current element index to the back
            q.offerLast(i);

            // 4. The front of deque is the maximum element for current window
            if (i >= k - 1) {
                res[resIdx++] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}