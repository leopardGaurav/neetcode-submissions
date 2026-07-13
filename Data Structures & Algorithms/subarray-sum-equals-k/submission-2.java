
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store (prefixSum -> count)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: Agar currentSum khud k ke barabar ho jaye, 
        // toh (currentSum - k = 0) hota hai. Isliye 0 ko pehle se 1 baar daal dete hain.
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            // 1. Current element ko sum mein add karo
            currentSum += num;
            
            // 2. Check karo kya (currentSum - k) pehle dikha hai?
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            
            // 3. Current sum ko map mein update ya insert karo
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

   
}