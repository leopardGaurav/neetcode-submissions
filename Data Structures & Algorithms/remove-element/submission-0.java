class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // 1. Left ko tab tak badhao jab tak target na mile
            while (left <= right && nums[left] != val) {
                left++;
            }
            // 2. Right ko tab tak ghatao jab tak valid element na mile
            while (left <= right && nums[right] == val) {
                right--;
            }
            // 3. Agar abhi bhi left aur right cross nahi hue hain, to asli swap karo
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        return left; // left hi sahi count hoga
    }
}