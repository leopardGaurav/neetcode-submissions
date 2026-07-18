public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers for the ends of valid elements in both arrays
        int p1 = m - 1; 
        int p2 = n - 1;
        // Pointer for the very end of the nums1 array where the next largest element goes
        int pMerge = m + n - 1;
        
        // Loop while there are still elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerge] = nums1[p1];
                p1--;
            } else {
                nums1[pMerge] = nums2[p2];
                p2--;
            }
            pMerge--;
        }
        
        // If nums2 still has remaining elements, copy them over.
        // (If nums1 has remaining elements, they are already in their correct places!)
        while (p2 >= 0) {
            nums1[pMerge] = nums2[p2];
            p2--;
            pMerge--;
        }
    }
}