class Solution {
        public int firstMissingPositive(int[] nums) {
                int n = nums.length;
                        
    // 1. Numbers ko unke sahi index par bhejo
  for (int i = 0; i < n; i++) {
 while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
  // Swap nums[i] with the element at its target index
            int temp = nums[nums[i] - 1];
           nums[nums[i] - 1] = nums[i];
                 nums[i] = temp;
              }
           } 
   // 2. Check karo kaunsa number missing hai
            for (int i = 0; i < n; i++) {
           if (nums[i] != i + 1) {
          return i + 1; // Jo pehla mismatch mila, wahi answer hai
                                                           } 
            }                                                                                                                                                                                                            
  // 3. Agar 1 se n tak saare numbers hain, to n+1 missing hoga
           return n + 1;
      
}
}
