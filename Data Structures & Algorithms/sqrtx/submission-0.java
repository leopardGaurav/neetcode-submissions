class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Cast to long to prevent integer overflow during mid * mid
            long square = (long) mid * mid;

            if (square <= x) {
                res = mid; // Record valid floor candidate
                left = mid + 1; // Try to find a larger valid square root
            } else {
                right = mid - 1; // Exceeds x, reduce search space
            }
        }

        return res;
    }
}