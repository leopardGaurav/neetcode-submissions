class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        // The maximum possible speed required is the maximum pile size
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatInTime(piles, h, mid)) {
                res = mid;          // Mid is a valid eating speed, record candidate
                right = mid - 1;    // Try to find a smaller speed k
            } else {
                left = mid + 1;     // Speed is too slow, increase k
            }
        }
        return res;
    }
    private boolean canEatInTime(int[] piles, int h, int k) {
        long totalHours = 0;

        for (int pile : piles) {
            // Integer ceiling division formula for pile / k: (pile + k - 1) / k
            totalHours += (pile + k - 1) / k;
            
            // Early exit if total hours exceed budget h
            if (totalHours > h) {
                return false;
            }
        }

        return totalHours <= h;
    }
}