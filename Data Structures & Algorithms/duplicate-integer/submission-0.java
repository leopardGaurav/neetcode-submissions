class Solution {
    //  Yahan 'containsDuplicate' ki jagah 'hasDuplicate' likhna hai
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        
        return false;
    }
}