class Solution {
    public int removeDuplicates(int[] nums) {
        // Agar array khali hai, toh unique elements 0 honge
        if (nums.length == 0) {
            return 0;
        }
        
        // 'i' pointer track karega ki unique element kaha tak fill huye hain
        int i = 0; 
        
        // 'j' pointer pure array ko scan karega index 1 se
        for (int j = 1; j < nums.length; j++) {
            // Agar j par koi naya unique number milta hai (jo i ke barabar nahi hai)
            if (nums[j] != nums[i]) {
                i++;             // i ko ek kadam aage badhao
                nums[i] = nums[j]; // Naye unique number ko i ki jagah par rakh do
            }
        }
        
        // Kyunki indexing 0 se shuru hoti hai, total unique elements (i + 1) honge
        return i + 1;
    }
}