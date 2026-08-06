class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        // Establish binary search lower and upper bounds
        for (int weight : weights) {
            left = Math.max(left, weight); // Minimum capacity must fit the heaviest package
            right += weight;              // Maximum capacity is shipping everything in 1 day
        }
        int res = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                res = mid;          // Record valid capacity candidate
                right = mid - 1;    // Try searching for a smaller ship capacity
            } else {
                left = mid + 1;     // Ship capacity too small, increase capacity
            }
        }
        return res;
    }
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                daysNeeded++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return daysNeeded <= days;
    }
}