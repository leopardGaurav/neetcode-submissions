/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        // 1. Find the peak index using Binary Search
        int peak = findPeak(mountainArr, n);

        // 2. Search target in the left strictly increasing slope
        int leftIdx = binarySearchIncreasing(mountainArr, target, 0, peak);
        if (leftIdx != -1) {
            return leftIdx; // Return minimum index immediately if found
        }

        // 3. Search target in the right strictly decreasing slope
        return binarySearchDecreasing(mountainArr, target, peak + 1, n - 1);
    }

    // Step 1: Binary Search to locate peak element
    private int findPeak(MountainArray mountainArr, int n) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1; // Peak must be to the right
            } else {
                right = mid;    // Peak is at mid or to the left
            }
        }

        return left;
    }

    // Step 2: Standard Binary Search on increasing sequence
    private int binarySearchIncreasing(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Step 3: Reversed Binary Search on decreasing sequence
    private int binarySearchDecreasing(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            } else if (val > target) { // Key difference: higher values are on left
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}