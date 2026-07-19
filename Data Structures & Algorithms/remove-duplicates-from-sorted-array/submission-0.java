class Solution {
    public int removeDuplicates(int[] nums) {
        // 1. TreeSet banaya jo duplicates allow nahi karega aur sort rakhega
        TreeSet<Integer> set = new TreeSet<>();
        
        // 2. Saare elements ko set mein daal diya
        for (int num : nums) {
            set.add(num);
        }
        
        // 3. Unique elements ko wapas original array ke shuruat mein daal diya
        int k = 0;
        for (int num : set) {
            nums[k] = num;
            k++;
        }
        
        // 4. Unique elements ki total ginti return kar di
        return k;
    }
}