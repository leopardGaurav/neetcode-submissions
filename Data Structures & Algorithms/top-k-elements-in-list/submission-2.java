class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency map banana
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Map ke elements ko list mein daal kar frequency ke basis par bade se chota (descending) sort karna
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        // Step 3: Pehle k elements ko result array mein daal kar return karna
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        
        return result;
    }
}