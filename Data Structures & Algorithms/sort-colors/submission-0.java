public class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        // Jab tak mid pointer, high pointer ko paar nahi kar jata
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Agar 0 dikhe, to use shuruat (low) ki taraf bhejo
                swap(nums, low, mid);
                low++;
                mid++;
            } 
            else if (nums[mid] == 1) {
                // Agar 1 dikhe, to wo apni sahi jagah (beech) par hai, bas aage badho
                mid++;
            } 
            else { // nums[mid] == 2
                // Agar 2 dikhe, to use aakhiri (high) ki taraf bhejo
                swap(nums, mid, high);
                high--;
                // Yahan mid++ nahi karenge, kyunki swap hokar jo naya number 
                // high se aaya hai, use abhi check karna baki hai.
            }
        }
    }
    
    // Elements ko aapas mein badalne (swap) ke liye helper function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}