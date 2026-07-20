class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        // Step 1: Array ko sort karo
        Arrays.sort(nums);
        int n = nums.length;

        // First element fix karo
        for (int i = 0; i < n - 3; i++) {
            // Duplicate 'i' ko skip karo
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second element fix karo
            for (int j = i + 1; j < n - 2; j++) {
                // Duplicate 'j' ko skip karo
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Integer overflow se bachne ke liye 'long' use kiya hai
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Duplicate 'left' aur 'right' ko skip karo
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } 
                    else if (sum < target) {
                        left++; // Sum chhota hai, bada karne ke liye left pointer badhao
                    } 
                    else {
                        right--; // Sum bada hai, chhota karne ke liye right pointer ghatao
                    }
                }
            }
        }

        return result;
    }
}