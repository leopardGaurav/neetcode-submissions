class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map banana
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Buckets banana (Array of Lists)
        // Size nums.length + 1 hogi kyunki max frequency array length ke barabar ho sakti hai
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for (int key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            
            // Agar is frequency ki list pehle se nahi bani, toh nayi banisao
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            // Number ko uski frequency waale bucket mein daal do
            bucket[frequency].add(key);
        }
        
        // Step 3: Peeche se scan karke top k elements nikalna
        int[] result = new int[k];
        int counter = 0;
        
        // Aakhiri index (max frequency) se shuru karke 0 tak aayenge
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    result[counter] = num;
                    counter++;
                    
                    // Jaise hi k elements mil jayein, loop rok do
                    if (counter == k) {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}